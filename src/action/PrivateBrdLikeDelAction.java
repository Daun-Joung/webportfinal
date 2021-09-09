package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.PrivateBrdLikeDTO;
import svc.PrivateBrdLikeDelService;

public class PrivateBrdLikeDelAction implements Action{

	static PrivateBrdLikeDelAction pbld = new PrivateBrdLikeDelAction();
	
	public static PrivateBrdLikeDelAction instance() {
		return pbld;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int pbrdno = Integer.parseInt(request.getParameter("pbrdno"));
		String user_id = request.getParameter("user_id");
		
		PrivateBrdLikeDTO dto = new PrivateBrdLikeDTO();
		
		dto.setPbrdno(pbrdno);
		dto.setUser_id(user_id);
		
		PrivateBrdLikeDelService pblds = PrivateBrdLikeDelService.instance();
		pblds.likeDelete(dto);
		
		
		return null;
	}

}
