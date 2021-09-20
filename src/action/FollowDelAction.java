package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import svc.FollowDelService;

public class FollowDelAction implements Action{

	static FollowDelAction fda = new FollowDelAction();
	
	public static FollowDelAction instance() {
		return fda;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String following = request.getParameter("following");
		String follower = request.getParameter("follower");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("following", following);
		map.put("follower", follower);
		
		FollowDelService fds = FollowDelService.instance();
		fds.followDel(map);
		
		ActionForward forward = new ActionForward();
		forward.setPath("../memberBrd/memberbrd.jsp?user_id="+follower+"");
		
		return forward;
	}

}
