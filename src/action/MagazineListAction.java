package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ActionForward;
import bean.MagazineDTO;
import bean.PageInfo;
import svc.MagazineListService;

public class MagazineListAction implements Action{

	static MagazineListAction magalist = new MagazineListAction();
	
	public static MagazineListAction instance() {
		return magalist;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<MagazineDTO> magazinelist = new ArrayList<MagazineDTO>();
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		MagazineListService listsrv = MagazineListService.instacne();
		int listCount = listsrv.getListCount();
		magazinelist = listsrv.getArticleList(page, limit);
		
		int maxPage = (int)((double)listCount/limit + 0.95);
		
		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		
		int endPage = startPage+10-1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageinfo = new PageInfo();
		pageinfo.setEndPage(endPage);
		pageinfo.setListCount(listCount);
		pageinfo.setMaxPage(maxPage);
		pageinfo.setPage(page);
		pageinfo.setStartPage(startPage);
		
		request.setAttribute("PageInfo", pageinfo);
		request.setAttribute("MagazineList", magazinelist);
		ActionForward forward = new ActionForward();
		forward.setPath("/magazinebrd/magazineView.jsp");
		return forward;
	}
}
