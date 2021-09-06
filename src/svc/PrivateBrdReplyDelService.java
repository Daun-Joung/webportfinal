package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdReplyDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdReplyDelService {

	static PrivateBrdReplyDelService pbrds = new PrivateBrdReplyDelService();
	
	public static PrivateBrdReplyDelService instance() {
		return pbrds;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void prvBrdReplyDel(PrivateBrdReplyDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int deleteresult = sqlsession.delete("prvbrdreplydel", dto);
		
		if(deleteresult > 0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
		}
		
	}
	

