package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.BoardDTO;
import svc.MarketSearchService;

public class MarketSearchAction implements Action{

	static MarketSearchAction msa = new MarketSearchAction();
	
	public static MarketSearchAction instance() {
		return msa;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		
		int criteria_01 = Integer.parseInt(request.getParameter("criteria_01"));
		int criteria_02 = Integer.parseInt(request.getParameter("criteria_02"));
		String searchbox = request.getParameter("searchbox");
		
		MarketSearchService mss = new MarketSearchService();
		List<BoardDTO> searchlist = mss.getMarketSearchList(criteria_01,criteria_02,searchbox);
		
		request.setAttribute("searchlist", searchlist);
		
		ActionForward forward = new ActionForward();
		forward.setPath(string);	
		
		return forward;
	}

}
