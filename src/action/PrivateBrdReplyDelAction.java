package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.PrivateBrdReplyDTO;
import svc.PrivateBrdReplyDelService;

public class PrivateBrdReplyDelAction implements Action{

	static PrivateBrdReplyDelAction pbrd = new PrivateBrdReplyDelAction();
	
	public static PrivateBrdReplyDelAction instance() {
		return pbrd;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int privatereplyno = Integer.parseInt(request.getParameter("privatereplyno"));
		String id = request.getParameter("id");
		int pbrdno = Integer.parseInt(request.getParameter("pbrdno"));
		
		PrivateBrdReplyDTO dto = new PrivateBrdReplyDTO();
		
		dto.setPrivatereplyno(privatereplyno);
		
		PrivateBrdReplyDelService pbrds = PrivateBrdReplyDelService.instance();
		pbrds.prvBrdReplyDel(dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("privateBrdDetail.do?comm=privateBrdDetail&pbrdno="+pbrdno+"&id="+id+"");
		return forward;
	}

}
