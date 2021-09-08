package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bean.ActionForward;
import bean.PrivateInfoDTO;
import svc.PrivateInfoRegiService;

public class PrivateInfoRegiAction implements Action{

	static PrivateInfoRegiAction pira = new PrivateInfoRegiAction();
	
	public static PrivateInfoRegiAction instance() {
		return pira;
	}
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		String realFolder = "";
		String saveFolder = "/privateProfileUpload";
		int filesize = 5*1024*1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, filesize, "UTF-8", new DefaultFileRenamePolicy());
		
		String user_id = multi.getParameter("user_id");
		int user_height = Integer.parseInt(multi.getParameter("user_height"));
		int user_weight = Integer.parseInt(multi.getParameter("user_weight"));
		String user_top =  multi.getParameter("user_top");
		int user_bottom = Integer.parseInt(multi.getParameter("user_bottom"));
		int user_shoe = Integer.parseInt(multi.getParameter("user_shoe"));
		
		PrivateInfoDTO dto = new PrivateInfoDTO();
		
		dto.setUser_id(user_id);
		dto.setUser_height(user_height);
		dto.setUser_weight(user_weight);
		dto.setUser_top(user_top);
		dto.setUser_bottom(user_bottom);
		dto.setUser_shoe(user_shoe);
		dto.setUser_img(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		PrivateInfoRegiService pirs = PrivateInfoRegiService.instance();
		boolean isWriteSuccess = pirs.privateInfoRegi(dto);
		
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
			forward.setPath("../privatepage/privatebrd.jsp");
		}
		
		
		return forward;
	}

}
