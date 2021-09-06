package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.BoardDTO;
import bean.PortDTO;




public class BoardDAO {

	private static BoardDAO instance;

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO(); // 객체 생성 . 싱글톤 패턴
		return instance;
	}
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/webportdbfinal";
	private static final String USER = "root";
	private static final String PASSWD = "1234";

	private Connection con = null;
	private Statement stmt = null;

	public BoardDAO() {
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
	
	public void updateAct (BoardDTO dto) {
		connect(); // 같은 파일안의 퍼블릭이기 때문에 단순히 메소드명만 호출하면 된다. 객체생성 할 필요 없음.
	
		String id = dto.getUser_id();
		String title = dto.getTitle();
		String content = dto.getMkt_content();
		int num = dto.getMktbd_num();
		
		try {
			
		stmt = con.createStatement();
		int rs = stmt.executeUpdate("update market_tbl set title ='"+title+"', mkt_content ='"+content+"', time=now() where mktbd_num ="+num+";");
		
		
		}catch (SQLException e){
			
		}finally {
			disconnect();
		}
	}
	
	public ArrayList<BoardDTO> srchGet (String day, String srchde, String srchtxt, int mktbd_num) {
		connect(); // 같은 파일안의 퍼블릭이기 때문에 단순히 메소드명만 호출하면 된다. 객체생성 할 필요 없음.
	
		ArrayList<BoardDTO> srchlist = new ArrayList<BoardDTO>();
		
		try {
			
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from market_tbl where "+srchde+" like '%"+srchtxt+"%' and time>=date_add(now(), interval "+day+") order by mktbd_num desc;");
		
		while(rs.next()) { 
			
			BoardDTO dto = new BoardDTO();
			
			dto.setMktbd_num(rs.getInt("mktbd_num"));
			dto.setTitle(rs.getString("title"));
			dto.setTime(rs.getString("time"));
			dto.setMkt_content(rs.getString("mkt_content"));
			dto.setUser_id(rs.getString("user_id"));
			
			srchlist.add(dto);
			
			}
			
		
		}catch (SQLException e){
			
		}finally {
			disconnect();
		}
		
		return srchlist;
		
	}
	
	public void deleteBoard(int num) {
		connect(); // 같은 파일안의 퍼블릭이기 때문에 단순히 메소드명만 호출하면 된다. 객체생성 할 필요 없음.
		
		try {
			
		stmt = con.createStatement();
		stmt.executeUpdate("delete from market_tbl where mktbd_num ="+num+"");
		
		
		}catch (SQLException e){
			
		}finally {
			disconnect();
		}
	}
	
	
}
