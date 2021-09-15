package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardGetDTO;
import bean.PrivateBrdDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdDelService {

	static PrivateBrdDelService pbds = new PrivateBrdDelService();
	
	public static PrivateBrdDelService instance() {
		
		return pbds;
		
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void privateBrdDelete(PrivateBrdDTO dto) {
		
		
		SqlSession sqlsession = factory.openSession();
		sqlsession.delete("privatebrddel", dto);
		sqlsession.delete("privatebrdreplydel",dto);
		sqlsession.delete("privatebrdlikedel",dto);
		
		sqlsession.commit();
		
		sqlsession.close();
		
		
	}
	
}
