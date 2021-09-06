package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MagazineDTO;
import mybatis.SqlMapConfig;

public class MagazineUpdateService {

	static MagazineUpdateService magaupsrv = new MagazineUpdateService();
	
	public static MagazineUpdateService instance() {
		return magaupsrv;
	}

	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void updateMagazine(MagazineDTO dto) {
		SqlSession sqlsession = factory.openSession();
		int updateCount = sqlsession.update("updateMaga", dto);
		if(updateCount>0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
		
	}
	
}
