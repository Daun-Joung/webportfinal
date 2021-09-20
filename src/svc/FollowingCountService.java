package svc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class FollowingCountService {

	static FollowingCountService fcs = new FollowingCountService();
	
	public static FollowingCountService instance() {
		return fcs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int followingcount (String following) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("following", following);
		
		SqlSession sqlsession = factory.openSession();
		int followingcount = sqlsession.selectOne("followingcount", map);
		
		sqlsession.close();
		
		return followingcount;
	}
	
}
