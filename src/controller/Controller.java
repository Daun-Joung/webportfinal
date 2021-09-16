package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardReplyAction;
import action.BoardReplyDeleteAction;
import action.BoardReplyModifyAction;
import action.MagazineAction;
import action.MagazineDeleteAction;
import action.MagazineDetailAction;
import action.MagazineListAction;
import action.MagazineUpdateAction;
import action.MagazineUpdateSelAction;
import action.MarketRegiAction;
import action.MarketSearchAction;
import action.PrivateBrdDelAction;
import action.PrivateBrdDetailAction;
import action.PrivateBrdLikeAction;
import action.PrivateBrdLikeDelAction;
import action.PrivateBrdRegiAction;
import action.PrivateBrdReplyAction;
import action.PrivateBrdReplyDelAction;
import action.PrivateBrdReplyUpAction;
import action.PrivateInfoRegiAction;
import bean.ActionForward;

public class Controller extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // dopost나 doget보다 먼저 수행되는 메소드
	
		request.setCharacterEncoding("utf-8"); // 경우마다 나눠서 이문장을 넣지 말고 항상 controller에 최상단에 이 문장을 작성해줘라 그리고 form에서 넘겨줄때는 method가 post가 아니면 넘어오지 않는다. 아마 보안을 위해서 그런 것 같다.
		
		String comm = request.getParameter("comm"); // request는 servlet의 기능이다 jsp를 사용할때 tomcat의 servlet api를 가져왔었기 때문에 아무문제 없이 사용했던 것이다. 
		
		Action inter = null;
		
		ActionForward forward = null;
				
				if(comm.equals("magazineregi")) {
					inter = MagazineAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}		
				}
				
				else if(comm.equals("magazineList")) {
					inter = MagazineListAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("magazineDetail")) {
					inter = MagazineDetailAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
					
				}
				
				else if(comm.equals("magazineDelete")) {
					inter = MagazineDeleteAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("magazineUpdate")) {
					inter = MagazineUpdateAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("magazineUpdateSel")) {
					inter = MagazineUpdateSelAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("setBoardReply")) {
					inter = BoardReplyAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("replyDelete")) {
					inter = BoardReplyDeleteAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("replyModify")) {
					inter = BoardReplyModifyAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("privateInfoRegi")) {
					inter = PrivateInfoRegiAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("privateBrdRegi")) {
					inter = PrivateBrdRegiAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("privateBrdDetail")) {
					inter = PrivateBrdDetailAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						System.out.println(e);
					}
				}
				
				else if(comm.equals("privatebrdreply")) {
					inter = PrivateBrdReplyAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				else if(comm.equals("prvbrdreplydel")) {
					inter = PrivateBrdReplyDelAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		
				else if(comm.equals("prvbrdreplyup")) {
					inter = PrivateBrdReplyUpAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				else if(comm.equals("prvbrdlikein")) {
					inter = PrivateBrdLikeAction.insatnce();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				else if(comm.equals("prvbrdlikedel")) {
					inter = PrivateBrdLikeDelAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				else if(comm.equals("privatebrddel")) {
					inter = PrivateBrdLikeDelAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				else if(comm.equals("privatebrdtotaldel")) {
					inter = PrivateBrdDelAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				else if(comm.equals("mktbdregi")) {
					inter = MarketRegiAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				else if(comm.equals("mktbdregi")) {
					inter = MarketRegiAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				else if(comm.equals("mktbdsearch")) {
					inter = MarketSearchAction.instance();
					try {
						forward = inter.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				if(forward != null){
					
					if(forward.isRedirect()){
						response.sendRedirect(forward.getPath());
					}else{
						RequestDispatcher dispatcher=
								request.getRequestDispatcher(forward.getPath());
						dispatcher.forward(request, response);
					}
					
				}
				
			
		}
	}


//dataselect, dataModel이 기능별로 하나씩 생성되는 것이다.
