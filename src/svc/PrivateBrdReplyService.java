package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdReplyDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdReplyService {

	static PrivateBrdReplyService pbrs = new PrivateBrdReplyService();
	
	public static PrivateBrdReplyService instance() {
		return pbrs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	
	public void setPrivateBrdReply (PrivateBrdReplyDTO dto) {

		
		SqlSession sqlsession = factory.openSession();
		int insertCount = sqlsession.insert("privatebrdreply", dto);
				
		if(insertCount > 0){
			sqlsession.commit();
		}
		else{
			sqlsession.rollback();
		}
		
		sqlsession.close();
		
		
	}
}
