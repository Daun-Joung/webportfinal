package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MagazineDTO;
import mybatis.SqlMapConfig;

public class MagazineService {

	static MagazineService magasrv = new MagazineService();
	
	public static MagazineService instance() {
		return magasrv;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public boolean regiArticle(MagazineDTO dto) throws Exception{
		
		boolean isWriteSuccess = false;
		SqlSession sqlsession = factory.openSession();
		int insertCount = sqlsession.insert("insert", dto);
		
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
