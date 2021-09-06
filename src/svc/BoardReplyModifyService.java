package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardReplyDTO;
import mybatis.SqlMapConfig;

public class BoardReplyModifyService {

	static BoardReplyModifyService brdremosrv = new BoardReplyModifyService();
	
	public static BoardReplyModifyService instance() {
		return brdremosrv;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void replyModify(BoardReplyDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int updateresult = sqlsession.update("replyModify", dto);
		
		if(updateresult >0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
	}
	
}
