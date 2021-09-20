package svc;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class PrivateBrdCountService {

	static PrivateBrdCountService pbcs = new PrivateBrdCountService();
	
	public static PrivateBrdCountService instance() {
		return pbcs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int getPrivateBrdCount(String user_id) {
		
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("user_id", user_id);
		
		SqlSession sqlsession = factory.openSession();
		int count = sqlsession.selectOne("privatebrdcount",map);
		
		sqlsession.close();
		
		return count;
	}
	
}
