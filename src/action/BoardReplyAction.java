package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardReplyDTO;
import svc.BoardReplyService;

public class BoardReplyAction implements Action{

	static BoardReplyAction brdact = new BoardReplyAction();
	
	public static BoardReplyAction instance() {
		return brdact;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
		BoardReplyDTO dto = new BoardReplyDTO();
		
		int mktbd_num = Integer.parseInt(request.getParameter("mktbd_num"));
		String user_id = request.getParameter("user_id");
		String reply_con = request.getParameter("reply_con");
		
		dto.setMktbd_num(mktbd_num);
		dto.setUser_id(user_id);
		dto.setReply_con(reply_con);
		
		BoardReplyService brdresrv = BoardReplyService.instance();
		brdresrv.setReply(dto);

		ActionForward forward = new ActionForward();
		forward.setPath("/board_01/portboard_01_conshow.jsp");

		return forward;
	}

}
