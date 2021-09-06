package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.BoardDTO;
import bean.PortDTO;


public class PortDAO {

	private static PortDAO instance;

	public static PortDAO getInstance() {
		if (instance == null)
			instance = new PortDAO(); // 객체 생성 . 싱글톤 패턴
		return instance;
	}
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/webportdbfinal";
	private static final String USER = "root";
	private static final String PASSWD = "1234";

	private Connection con = null;
	private Statement stmt = null;

	public PortDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void connect() {
		try {
			con = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertAct(PortDTO dto) {
		connect();
		
		String user_id = dto.getUser_id();
		String user_pw = dto.getUser_pw();
		String user_name = dto.getUser_name();
		String email = dto.getEmailin() + dto.getEmaildefault();
		String birth = dto.getYear() + dto.getMonth() + dto.getDay();
		String cellnum = dto.getCellnum();
		String gender = dto.getGender();
		String addre = dto.getAddnum() + dto.getAddmain() + dto.getAdddetail() + dto.getAdddetail_2();
		
		try {
			
			stmt = con.createStatement();
			int rs = stmt.executeUpdate("insert into userinfo values('"+user_id+"','"+user_pw+"','"+user_name+"','"+email+"','"+birth+"','"+cellnum+"','"+gender+"','"+addre+"');"); // select문은 출력을 해야하니 반드시 쿼리문에서 받아온 값을 ResultSet에 넣어놔라.
			
			}catch (SQLException e){
				
			}finally {
				disconnect();
			}		
	}
	
	public ArrayList<PortDTO> idchAct() {
		connect();
		
		ArrayList<PortDTO> userlist = new ArrayList<PortDTO>();
		
		
		try {
			
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from userinfo;");
		
		while(rs.next()) { 
			
		PortDTO dto = new PortDTO();
		
		dto.setUser_id(rs.getString("user_id"));
		dto.setEmail(rs.getString("email"));
		dto.setUser_name(rs.getString("user_name"));
			
		userlist.add(dto);
		}
		
		
		}catch (SQLException e){
			
		}finally {
			disconnect();
		}
		
		return userlist;
	}

	public int loginChk(String id, String pw) { // login페이지에서 입력한 아이디 패스워드값 받아오기.
	
		connect();
		int ret = 0;
		
		try {
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select user_pw from userinfo where user_id = '"+id+"';");
			
			if(rs.next()) { 
				
				if(rs.getString("user_pw").equals(pw)) {
					
					ret = 1;
					
				}else {
					
					ret = 2;
					
				}
				
			}else {
				ret = 3;
			}
			
			}catch (SQLException e){
				
			}finally {
				disconnect();
			}
		return ret;
			
	}
	
	public ArrayList<BoardDTO> boardGet() {
		connect();
		
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		
		try {
			
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from market_tbl order by mktbd_num desc;");
		
		while(rs.next()) { 
			
		BoardDTO dto = new BoardDTO();
		
		dto.setMktbd_num(rs.getInt("mktbd_num"));
		dto.setUser_id(rs.getString("user_id"));
		dto.setTitle(rs.getString("title"));
		dto.setMkt_content(rs.getString("mkt_content"));
		dto.setMkt_pic(rs.getString("mkt_pic"));
		dto.setMkt_comment(rs.getString("mkt_comment"));
		dto.setTime(rs.getString("time"));
		
		boardlist.add(dto);
		
		}
		
		
		}catch (SQLException e){
			
		}finally {
			disconnect();
		}
		
		return boardlist;
	}
	
	public void boardInsert(BoardDTO dto) {
		connect();
		
		String user_id = dto.getUser_id();
		String title = dto.getTitle();
		String content = dto.getMkt_content();
		
		try {
			
			stmt = con.createStatement();
			int rs = stmt.executeUpdate("insert into market_tbl(mktbd_num, user_id, title, mkt_content) values(default,'"+user_id+"','"+title+"','"+content+"');"); // select문은 출력을 해야하니 반드시 쿼리문에서 받아온 값을 ResultSet에 넣어놔라.
			
			}catch (SQLException e){
				
			}finally {
				disconnect();
			}		
	}

	
	public ArrayList<BoardDTO> conGet(int mktbd_num) {
		connect();
		
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		try {
			
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from market_tbl where mktbd_num = "+mktbd_num+";");
		
		if(rs.next()) { 
			
		BoardDTO dto = new BoardDTO();
		
		dto.setUser_id(rs.getString("user_id"));
		dto.setMktbd_num(rs.getInt("mktbd_num"));
		dto.setTitle(rs.getString("title"));
		dto.setMkt_content(rs.getString("mkt_content"));
		dto.setTime(rs.getString("time"));
		
		boardlist.add(dto);
		
		}
		
		
		}catch (SQLException e){
			
		}finally {
			disconnect();
		}
		
		return boardlist;
	}
	
	public ArrayList<PortDTO> idsrchGet(String name, String email) {
		connect();
		
		ArrayList<PortDTO> boardlist = new ArrayList<PortDTO>();
		
		try {
			
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from userinfo where user_name = '"+name+"' and email = '"+email+"';");
		
		if(rs.next()) { 
			
		PortDTO dto = new PortDTO();
		
		dto.setUser_id(rs.getString("user_id"));
		
		boardlist.add(dto);
		
		}
		
		
		}catch (SQLException e){
			
		}finally {
			disconnect();
		}
		
		return boardlist;
	}
	
	
	

}
