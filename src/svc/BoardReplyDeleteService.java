package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardReplyDTO;
import mybatis.SqlMapConfig;

public class BoardReplyDeleteService {

	static BoardReplyDeleteService brdredelsrv = new BoardReplyDeleteService();
	
	public static BoardReplyDeleteService instance() {
		return brdredelsrv;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void deleteReply(BoardReplyDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int deleteresult = sqlsession.delete("replyDelete", dto);
		
		if(deleteresult > 0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
		}
		
		
	}
	

