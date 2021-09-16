package svc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardDTO;
import bean.BoardSrchDTO;
import mybatis.SqlMapConfig;

public class MarketSearchService {

	static MarketSearchService mss = new MarketSearchService();
	
	public static MarketSearchService instance() {
		return mss;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<BoardDTO> getMarketSearchList(BoardSrchDTO dto){
		
		List<BoardDTO> searchlist = new ArrayList<BoardDTO>();
		
		SqlSession sqlsession = factory.openSession();
		
		
		
		if( dto.getCriteria_01() == 1) {
		   searchlist = sqlsession.selectList("marketidsrch", dto);
		}else if( dto.getCriteria_01() == 2){
		   searchlist = sqlsession.selectList("markettitlesrch", dto);
		}
		
		
		
		
		
		return searchlist;
	}
	
}
