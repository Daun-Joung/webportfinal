package svc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class FollowInService {

	static FollowInService fis = new FollowInService();
	
	public static FollowInService instance() {
		return fis;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void followIn(HashMap<String, String> map) {
		
		SqlSession sqlsession = factory.openSession();
		int insertcount = sqlsession.insert("followin", map);
		
		if(insertcount >0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
	}
	
}
