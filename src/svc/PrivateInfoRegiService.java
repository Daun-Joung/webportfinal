package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateInfoDTO;
import mybatis.SqlMapConfig;

public class PrivateInfoRegiService {

	static PrivateInfoRegiService pirs = new PrivateInfoRegiService();
	
	public static PrivateInfoRegiService instance() {
		return pirs;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public boolean privateInfoRegi(PrivateInfoDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int insertCount = sqlsession.insert("privateinforegi",dto);
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
