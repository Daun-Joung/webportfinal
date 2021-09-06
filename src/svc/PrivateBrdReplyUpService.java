package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdReplyDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdReplyUpService {

	static PrivateBrdReplyUpService pbrus = new PrivateBrdReplyUpService();
	
	public static PrivateBrdReplyUpService instance() {
		return pbrus;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void modiBrdReply(PrivateBrdReplyDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int updateresult = sqlsession.update("prvbrdreplyup", dto);
		
		if(updateresult > 0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
		
	}
	
}
