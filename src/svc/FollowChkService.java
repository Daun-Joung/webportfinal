package svc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class FollowChkService {

	static FollowChkService fcs = new FollowChkService();
	
	public static FollowChkService instance() {
		return fcs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int followcheck(HashMap<String, String> map) {
		
		SqlSession sqlsession = factory.openSession();
		int followchk = sqlsession.selectOne("followcheck", map);
		
		sqlsession.close();
		
		return followchk;
	}
	
}
