package svc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class FollowerCountService {

	static FollowerCountService fcs = new FollowerCountService();
	
	public static FollowerCountService instance() {
		return fcs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int followercount (String follower) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("follower", follower);
		
		SqlSession sqlsession = factory.openSession();
		int followercount = sqlsession.selectOne("followercount", map);
		
		sqlsession.close();
		
		return followercount;
	}
	
	
}
