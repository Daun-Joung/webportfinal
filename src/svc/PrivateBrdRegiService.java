package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdRegiService {

	static PrivateBrdRegiService pbrs = new PrivateBrdRegiService();
	
	public static PrivateBrdRegiService instance() {
		return pbrs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public boolean setprivateBrdRegi (PrivateBrdDTO dto) {
	
		SqlSession sqlsession = factory.openSession();
		int insertCount = sqlsession.insert("privatebrdregi", dto);
		boolean isWriteSuccess = false;
	
		if(insertCount > 0){
			sqlsession.commit();
			isWriteSuccess = true;
		}
		else{
			sqlsession.rollback();
		}
		
		sqlsession.close();
		return isWriteSuccess;	
	}
}
	