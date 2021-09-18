package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardGetDTO;
import svc.PrivateBrdDetailService;

public class PrivateBrdDetailAction implements Action{

	static PrivateBrdDetailAction pbda = new PrivateBrdDetailAction();
	
	public static PrivateBrdDetailAction instance() {
		return pbda;
	}
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int pbrdno = Integer.parseInt(request.getParameter("pbrdno"));//int
		
		
		BoardGetDTO dto = new BoardGetDTO();
		dto.setPbrdno(pbrdno);
		
		
		PrivateBrdDetailService srv = PrivateBrdDetailService.instance();
		List<BoardGetDTO> brddetail = srv.getBrdDetail(dto);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("brddetail", brddetail);
		forward.setPath("../privatepage/privatebrddetail.jsp");
		
		return forward;
	}

	
	
}
