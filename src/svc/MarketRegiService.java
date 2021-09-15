package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardDTO;
import mybatis.SqlMapConfig;

public class MarketRegiService {

	static MarketRegiService mrs = new MarketRegiService();
	
	public static MarketRegiService instance() {
		return mrs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public boolean insertMarket(BoardDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int insertCount = sqlsession.insert("marketbrdregi", dto);
		boolean isWriteSuccess = false;
	
		if(insertCount > 0){
			sqlsession.commit();
			isWriteSuccess = true;
		}
		else{
			sqlsession.rollback();
		}
		
		sqlsession.close();
		return isWriteSuccess;

	}
	
}
