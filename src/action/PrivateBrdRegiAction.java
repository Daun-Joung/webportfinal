package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ActionForward;
import bean.MagazineDTO;
import bean.PrivateBrdDTO;
import svc.MagazineService;
import svc.PrivateBrdRegiService;

public class PrivateBrdRegiAction implements Action{

	static PrivateBrdRegiAction pbra = new PrivateBrdRegiAction();
	
	public static PrivateBrdRegiAction instance() {
		return pbra;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		String realFolder = "";
		String saveFolder = "/privateBrdUpload";
		int filesize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, filesize, "UTF-8", new DefaultFileRenamePolicy());
				
		String user_id = multi.getParameter("user_id");
		String pbrd_con = multi.getParameter("pbrd_con");
		
		PrivateBrdDTO dto = new PrivateBrdDTO();
		
		dto.setUser_id(user_id);
		dto.setPbrd_con(pbrd_con);
		dto.setPbrd_pic(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		PrivateBrdRegiService pbrs = PrivateBrdRegiService.instance();
		boolean isWriteSuccess = pbrs.setprivateBrdRegi(dto);
		
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
			forward.setPath("privatebrd.jsp");
		}	
		return forward;
	}

}
