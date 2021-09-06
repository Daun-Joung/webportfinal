package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardReplyDTO;
import svc.BoardReplyDeleteService;

public class BoardReplyDeleteAction implements Action {

	static BoardReplyDeleteAction brdredel = new BoardReplyDeleteAction();
	
	public static BoardReplyDeleteAction instance () {
		return brdredel;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int replyno = Integer.parseInt(request.getParameter("replyno"));
		int mktbd_num = Integer.parseInt(request.getParameter("mktbd_num"));
		
		BoardReplyDTO dto = new BoardReplyDTO();
		dto.setReplyno(replyno);
		
		BoardReplyDeleteService brdredelsrv = BoardReplyDeleteService.instance();
		brdredelsrv.deleteReply(dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("portboard_01_conshow.jsp?mktbd_num="+mktbd_num+"");
		
		return forward;
	}
	
	
	
}
