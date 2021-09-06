package svc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MagazineDTO;
import mybatis.SqlMapConfig;

public class MagazineListService {

	static MagazineListService magalistservice = new MagazineListService();
	
	public static MagazineListService instacne() {
		return magalistservice;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int getListCount() throws Exception {
		
		Integer listCount = 0;
		
		SqlSession sqlsession = factory.openSession();
		listCount = sqlsession.selectOne("selectcount");
		
		int listcount = listCount.intValue();
		
		sqlsession.close();
	
		return listcount;
	}
	
	public List<MagazineDTO> getArticleList(int page, int limit){
		
		List<MagazineDTO> list = null;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("StartRow", (page-1)*10);
		map.put("Limit", limit);
		
		SqlSession sqlsession = factory.openSession();
		list = sqlsession.selectList("selectMagaList", map);
		
		sqlsession.close();
		
		return list;
		
	}
	
}
