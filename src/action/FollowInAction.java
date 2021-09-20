package action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import svc.FollowInService;

public class FollowInAction implements Action {

	static FollowInAction fia = new FollowInAction();
	
	public static FollowInAction instance() {
		return fia;
	}
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String following = request.getParameter("following");
		String follower = request.getParameter("follower");
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("following", following);
		map.put("follower", follower);
		
		FollowInService fis = FollowInService.instance();
		fis.followIn(map);
		
		ActionForward forward = new ActionForward();
		forward.setPath("../memberBrd/memberbrd.jsp?user_id="+follower+"");
		
		return forward;
	}
}
