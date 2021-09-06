package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MagazineDTO;
import mybatis.SqlMapConfig;

public class MagazineDeleteService {

	static MagazineDeleteService magadelsrv = new MagazineDeleteService();
	
	public static MagazineDeleteService instance() {
		return magadelsrv;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void deleteMagazine(MagazineDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int deleteresult = sqlsession.delete("deleteMaga", dto);
		
		if(deleteresult > 0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
		}
	
}
