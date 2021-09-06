package svc;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdSelService {

	static PrivateBrdSelService pbss = new PrivateBrdSelService();
	
	public static PrivateBrdSelService instance() {
		return pbss;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<PrivateBrdDTO> getPrivateBrd(String id){

		List<PrivateBrdDTO> privatebrdlist = new ArrayList<PrivateBrdDTO>();
		
		PrivateBrdDTO dto = new PrivateBrdDTO();
		dto.setUser_id(id);
				
		SqlSession sqlsession = factory.openSession();
		privatebrdlist = sqlsession.selectList("privatebrdsel", dto);
		
		sqlsession.close();
		
		return privatebrdlist;
	}
	
}
