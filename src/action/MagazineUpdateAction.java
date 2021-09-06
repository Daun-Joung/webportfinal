package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MagazineDTO;
import svc.MagazineUpdateService;

public class MagazineUpdateAction implements Action {

	static MagazineUpdateAction magaup = new MagazineUpdateAction();
	
	public static MagazineUpdateAction instance() {
		return magaup;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 
		int magano = Integer.parseInt(request.getParameter("magano"));
		String magatitle = request.getParameter("magatitle");
		String magacon = request.getParameter("magacon");
		int page = Integer.parseInt(request.getParameter("page"));
		
		MagazineDTO dto = new MagazineDTO();
		
		dto.setMagano(magano);
		dto.setMagatitle(magatitle);
		dto.setMagacon(magacon);

		MagazineUpdateService magaupsrv = MagazineUpdateService.instance();
		magaupsrv.updateMagazine(dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("magazindetail.do?comm=magazineDetail&magano="+magano+"&page="+page+"");
		return forward;
	}

}
