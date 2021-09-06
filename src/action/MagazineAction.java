package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ActionForward;
import bean.MagazineDTO;
import svc.MagazineService;

public class MagazineAction implements Action {

	static MagazineAction magain = new MagazineAction();
	
	public static MagazineAction instance() {
		return magain;
	}
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		MagazineDTO dto = null;
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int filesize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, filesize, "UTF-8", new DefaultFileRenamePolicy());
		
		dto = new MagazineDTO();
		
		dto.setMagatitle(multi.getParameter("magatitle"));
		dto.setMagacon(multi.getParameter("magacon"));
		dto.setMagaimg(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		MagazineService magasrv = MagazineService.instance();
		boolean isWriteSuccess = magasrv.regiArticle(dto);
		
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
			forward.setPath("magazineList.do?comm=magazineList");
		}
		
		
		return forward;
	}

}
