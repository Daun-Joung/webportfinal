package svc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateInfoDTO;
import mybatis.SqlMapConfig;

public class MystyleMainService {

	static MystyleMainService mms = new MystyleMainService();
	
	public static MystyleMainService instance() {
		return mms;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<PrivateInfoDTO> getPrivateInfo(String id){
		
		List<PrivateInfoDTO> privatelist = new ArrayList<PrivateInfoDTO>();
		PrivateInfoDTO dto = new PrivateInfoDTO();
		dto.setUser_id(id);
		
		SqlSession sqlsession = factory.openSession();
		privatelist = sqlsession.selectList("getprivateinfo", dto);
		
		sqlsession.close();
		
		return privatelist;
		
	}
	
}
