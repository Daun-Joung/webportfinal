package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.PrivateBrdLikeDTO;
import svc.PrivateBrdLikeService;

public class PrivateBrdLikeAction implements Action{

	static PrivateBrdLikeAction pbla = new PrivateBrdLikeAction();
	
	public static PrivateBrdLikeAction insatnce() {
		return pbla;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int pbrdno = Integer.parseInt(request.getParameter("pbrdno"));
		String user_id = request.getParameter("user_id");
		
		PrivateBrdLikeDTO dto = new PrivateBrdLikeDTO();
		
		dto.setPbrdno(pbrdno);
		dto.setUser_id(user_id);
		
		PrivateBrdLikeService pbls = PrivateBrdLikeService.instance();
		pbls.likeChk(dto);
		
		
		return null;
	}

}
