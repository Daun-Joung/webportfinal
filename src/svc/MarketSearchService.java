package svc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardDTO;
import mybatis.SqlMapConfig;

public class MarketSearchService {

	static MarketSearchService mss = new MarketSearchService();
	
	public static MarketSearchService instance() {
		return mss;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<BoardDTO> getMarketSearchList(int criteria_01, int criteria_02, String searchbox){
		
		List<BoardDTO> searchlist = new ArrayList<BoardDTO>();
		
		SqlSession sqlsession = factory.openSession();
		
		if( criteria_01 == 1) {
		   searchlist = sqlsession.selectList(arg0, arg1);
		}else {
		   searchlist = sqlsession.selectList(arg0, arg1);
		}
		
		
		
		
		
		return searchlist;
	}
	
}
