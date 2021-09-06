package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardReplyDTO;
import svc.BoardReplyModifyService;

public class BoardReplyModifyAction implements Action{

	static BoardReplyModifyAction brdremodify = new BoardReplyModifyAction();
	
	public static BoardReplyModifyAction instance() {
		return brdremodify;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int replyno = Integer.parseInt(request.getParameter("replyno"));
		String reply_con = request.getParameter("reply_con");
		
		BoardReplyDTO dto = new BoardReplyDTO();
		dto.setReplyno(replyno);
		dto.setReply_con(reply_con);
		
		BoardReplyModifyService srv = BoardReplyModifyService.instance();
		srv.replyModify(dto);
		
		return null;
	}

}
