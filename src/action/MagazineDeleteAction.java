package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MagazineDTO;
import svc.MagazineDeleteService;

public class MagazineDeleteAction implements Action {

	static MagazineDeleteAction magadel = new MagazineDeleteAction();
	
	public static MagazineDeleteAction instance() {
		return magadel;
	}
	
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int magano = Integer.parseInt(request.getParameter("magano"));
		
		MagazineDTO dto = new MagazineDTO();
		
		dto.setMagano(magano);
		
		MagazineDeleteService magadelsrv = new MagazineDeleteService();
		magadelsrv.deleteMagazine(dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("magazinelist.do?comm=magazineList");
		
		return forward;
	}

}
