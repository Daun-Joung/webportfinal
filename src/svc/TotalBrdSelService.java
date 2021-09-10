package svc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardGetDTO;
import mybatis.SqlMapConfig;

public class TotalBrdSelService {

	static TotalBrdSelService tbss = new TotalBrdSelService();
	
	public static TotalBrdSelService instance() {
		return tbss;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<BoardGetDTO> getTotalBrd(){
		
		List<BoardGetDTO> totallist = new ArrayList<BoardGetDTO>(); 
		
		SqlSession sqlsession = factory.openSession();
		totallist = sqlsession.selectList("gettotalbrd");
		
		sqlsession.close();
		
		return totallist;
	}
	
}
