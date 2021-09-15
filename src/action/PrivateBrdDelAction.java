package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardGetDTO;
import bean.PrivateBrdDTO;
import svc.PrivateBrdDelService;

public class PrivateBrdDelAction implements Action{

	static PrivateBrdDelAction pbda = new PrivateBrdDelAction();
	
	public static PrivateBrdDelAction instance() {
		return pbda;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int pbrdno = Integer.parseInt(request.getParameter("pbrdno"));
		String user_id = request.getParameter("user_id");
		
		PrivateBrdDTO dto = new PrivateBrdDTO();
		dto.setUser_id(user_id);
		dto.setPbrdno(pbrdno);
		
		PrivateBrdDelService pbds = PrivateBrdDelService.instance();
		pbds.privateBrdDelete(dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("../privatepage/privatebrd.jsp");
		
		return forward;
	}

	
	
}
