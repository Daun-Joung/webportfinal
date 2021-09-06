package svc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MagazineDTO;
import mybatis.SqlMapConfig;

public class MagazineDetailService {

	static MagazineDetailService magadesrv = new MagazineDetailService();
	
	public static MagazineDetailService instance() {
		return magadesrv;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<MagazineDTO> getMagaDetail(MagazineDTO dto) throws Exception {
		
		
		SqlSession sqlsession = factory.openSession();
		List<MagazineDTO> magadto = sqlsession.selectList("selectMagaDetail", dto);
	
		sqlsession.close();
		return magadto;
	}
	
	public int updateReadCount(MagazineDTO dto) throws Exception{
		
		SqlSession sqlsession = factory.openSession();
		int readCount = sqlsession.update("updateReadCount",dto);
		
		if(readCount >0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
		return readCount;
		
	}
	
}
