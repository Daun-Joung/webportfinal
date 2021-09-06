package svc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardGetDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdDetailService {

	static PrivateBrdDetailService pbds = new PrivateBrdDetailService();
	
	public static PrivateBrdDetailService instance() {
		return pbds;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<BoardGetDTO> getBrdDetail (BoardGetDTO dto) {
		
		List<BoardGetDTO> brddetail = new ArrayList<BoardGetDTO>();
		
		SqlSession sqlsession = factory.openSession();
		brddetail = sqlsession.selectList("getbrddetail", dto);
		
		sqlsession.close();
		
		return brddetail;
	}
	
}
