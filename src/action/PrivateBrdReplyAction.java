package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.PrivateBrdReplyDTO;
import svc.PrivateBrdReplyService;

public class PrivateBrdReplyAction implements Action{

	static PrivateBrdReplyAction pbra = new PrivateBrdReplyAction();
	
	public static PrivateBrdReplyAction instance() {
		return pbra;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		PrivateBrdReplyDTO dto = new PrivateBrdReplyDTO();
		
		String user_id = request.getParameter("user_id");
		String reply_con = request.getParameter("reply_con");
		int pbrdno = Integer.parseInt(request.getParameter("pbrdno"));
		String user_img = request.getParameter("user_img");
		
		dto.setUser_img(user_img);
		dto.setUser_id(user_id);
		dto.setPbrdno(pbrdno);
		dto.setReply_con(reply_con);

		PrivateBrdReplyService pbrs = PrivateBrdReplyService.instance();
		pbrs.setPrivateBrdReply(dto);
		
		return null;
	}

}
