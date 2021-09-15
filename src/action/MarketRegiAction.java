package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ActionForward;
import bean.BoardDTO;
import bean.PrivateBrdDTO;
import svc.MarketRegiService;
import svc.PrivateBrdRegiService;

public class MarketRegiAction implements Action{

	static MarketRegiAction mra = new MarketRegiAction();
	
	public static MarketRegiAction instance() {
		return mra;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
		ActionForward forward = null;
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int filesize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, filesize, "UTF-8", new DefaultFileRenamePolicy());
				
		String user_id = multi.getParameter("user_id");
		String mktbdtitle = multi.getParameter("mktbdtitle");
		int mktbdprice = Integer.parseInt(multi.getParameter("mktbdprice"));
		String mktbdcon = multi.getParameter("mktbdcon");
		
		BoardDTO dto = new BoardDTO();
		
		dto.setUser_id(user_id);
		dto.setMktbdtitle(mktbdtitle);
		dto.setMktbdprice(mktbdprice);
		dto.setMktbdcon(mktbdcon);
		dto.setMktbdimg(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
	
		MarketRegiService mkrs = MarketRegiService.instance();
		boolean isWriteSuccess = mkrs.insertMarket(dto);
		
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
			forward.setPath("../board_01/portBoard_01.jsp");
		}	
		return forward;
	}

	
	
}
