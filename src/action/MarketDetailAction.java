package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardDTO;
import svc.MarketDetailService;

public class MarketDetailAction implements Action{

	static MarketDetailAction mda = new MarketDetailAction();
	
	public static MarketDetailAction instance() {
		return mda;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int mktbdno = Integer.parseInt(request.getParameter("mktbdno"));
		
		BoardDTO dto = new BoardDTO();
		dto.setMktbdno(mktbdno);
		
		MarketDetailService mds =  MarketDetailService.instance();
		List<BoardDTO> marketdetail = mds.marketDetail(dto);
		
		request.setAttribute("marketdetail", marketdetail);
		ActionForward forward = new ActionForward();
		forward.setPath("../board_01/boardDetail.jsp");
		
		return forward;
	}

}
