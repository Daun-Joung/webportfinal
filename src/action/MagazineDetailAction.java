package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MagazineDTO;
import svc.MagazineDetailService;
import svc.MagazineListService;

public class MagazineDetailAction implements Action{

	static MagazineDetailAction magade = new MagazineDetailAction();
	
	public static MagazineDetailAction instance() {
		return magade;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		List<MagazineDTO> magadto = new ArrayList<MagazineDTO>();
		
		int magano = Integer.parseInt(request.getParameter("magano"));
		String page = request.getParameter("page");
		
		MagazineDTO dto = new MagazineDTO();
		
		dto.setMagano(magano);
		
		MagazineDetailService magadetailsrv = MagazineDetailService.instance();
		
		magadto = magadetailsrv.getMagaDetail(dto);
		magadetailsrv.updateReadCount(dto);
		
		request.setAttribute("page", page);
		request.setAttribute("magadetail", magadto);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("/magazinebrd/magazineDetailView.jsp");

		return forward;
	}

}
