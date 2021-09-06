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
		
		boolean isWriteSuccess= false;
		ActionForward forward = null;

		PrivateBrdReplyDTO dto = new PrivateBrdReplyDTO();
		
		String user_id = request.getParameter("user_id");
		String reply_con = request.getParameter("reply_con");
		int pbrdno = Integer.parseInt(request.getParameter("pbno"));
		String id = request.getParameter("id");
		String user_img = request.getParameter("user_img");
		
		dto.setUser_img(user_img);
		dto.setUser_id(user_id);
		dto.setPbrdno(pbrdno);
		dto.setReply_con(reply_con);

		PrivateBrdReplyService pbrs = PrivateBrdReplyService.instance();
		isWriteSuccess = pbrs.setPrivateBrdReply(dto);
		
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패.')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("privateBrdDetail.do?comm=privateBrdDetail&pbrdno="+pbrdno+"&id="+id+"");
		}	

		return forward;
	}

}
