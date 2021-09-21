package svc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PortMainDTO;
import mybatis.SqlMapConfig;

public class PortMainService {

	static PortMainService pms = new PortMainService();
	
	public static PortMainService instance() {
		return pms;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<PortMainDTO> portMain(String id) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("user_id", id);
		
		List<PortMainDTO> mainlist = new ArrayList<PortMainDTO>();
		
		SqlSession sqlsession = factory.openSession();
		mainlist = sqlsession.selectList("portmain", map);
		
		sqlsession.close();
		
		return mainlist;
	}
}
