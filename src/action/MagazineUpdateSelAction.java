package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MagazineDTO;
import svc.MagazineDetailService;
import svc.MagazineUpdateSelService;

public class MagazineUpdateSelAction implements Action{

	static MagazineUpdateSelAction magaupsel = new MagazineUpdateSelAction();
	
	public static MagazineUpdateSelAction instance() {
		return magaupsel;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<MagazineDTO> magadto = new ArrayList<MagazineDTO>();
		
		int magano = Integer.parseInt(request.getParameter("magano"));
		String page = request.getParameter("page");
		
		MagazineDTO dto = new MagazineDTO();
		
		dto.setMagano(magano);
		
		MagazineUpdateSelService magadetailsrv = MagazineUpdateSelService.instance();
		
		magadto = magadetailsrv.getMagaUpSel(dto);
		
		request.setAttribute("page", page);
		request.setAttribute("magadetail", magadto);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("/magazinebrd/magazineUpdate.jsp");

		return forward;
	}

}
