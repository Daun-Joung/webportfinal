package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.PrivateBrdReplyDTO;
import svc.PrivateBrdReplyUpService;

public class PrivateBrdReplyUpAction implements Action{

	static PrivateBrdReplyUpAction pbrua = new PrivateBrdReplyUpAction();
	
	public static PrivateBrdReplyUpAction instance() {
		return pbrua;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		int privatereplyno = Integer.parseInt(request.getParameter("privatereplyno"));
		String reply_con = request.getParameter("reply_con");
		
		PrivateBrdReplyDTO dto = new PrivateBrdReplyDTO();
		dto.setPrivatereplyno(privatereplyno);
		dto.setReply_con(reply_con);
		
		PrivateBrdReplyUpService pbrus = PrivateBrdReplyUpService.instance();
		pbrus.modiBrdReply(dto);
		
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
