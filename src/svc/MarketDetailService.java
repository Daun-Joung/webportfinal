package svc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardDTO;
import mybatis.SqlMapConfig;

public class MarketDetailService {

	static MarketDetailService mds = new MarketDetailService();
	
	public static MarketDetailService instance() {
		return mds;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<BoardDTO> marketDetail(BoardDTO dto){
		
		List<BoardDTO> marketdetail = new ArrayList<BoardDTO>();
		
		SqlSession sqlsession = factory.openSession();
		marketdetail = sqlsession.selectList("marketdetail", dto);
		
		sqlsession.close();
		
		return marketdetail;
	}
}
