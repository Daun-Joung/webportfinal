package svc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class FollowDelService {

	static FollowDelService fds = new FollowDelService();
	
	public static FollowDelService instance() {
		return fds;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void followDel(HashMap<String, String> map) {
		
		SqlSession sqlsession = factory.openSession();
		int deletecount = sqlsession.delete("followdelete", map);
		
		if(deletecount > 0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		sqlsession.close();
	}
	
}
