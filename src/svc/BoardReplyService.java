package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardReplyDTO;
import mybatis.SqlMapConfig;

public class BoardReplyService {

	static BoardReplyService brdresrv = new BoardReplyService();
	
	public static BoardReplyService instance() {
		return brdresrv;
	}
	
	SqlSessionFactory factory  = SqlMapConfig.getSqlSession();
	
	public void setReply(BoardReplyDTO dto) throws Exception  {
		
		SqlSession sqlsession = factory.openSession();
		int insertresult = sqlsession.insert("marketReplyin", dto);
		
		if(insertresult>0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
	}
	
	
	
}
