package svc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardDTO;
import mybatis.SqlMapConfig;

public class MarketGetService {

	static MarketGetService mgs = new MarketGetService();
	
	public static MarketGetService instance() {
		return mgs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<BoardDTO> marketSelect(){
		
		List<BoardDTO> marketlist = new ArrayList<BoardDTO>();
		
		SqlSession sqlsession = factory.openSession();
		marketlist = sqlsession.selectList("marketbrdget");
		
		sqlsession.close();
		
		return marketlist;
	}
	
}
