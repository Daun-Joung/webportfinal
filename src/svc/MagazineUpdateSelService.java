package svc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MagazineDTO;
import mybatis.SqlMapConfig;

public class MagazineUpdateSelService {
	
	static MagazineUpdateSelService magaupselsrv = new MagazineUpdateSelService();
	
	public static MagazineUpdateSelService instance() {
		return magaupselsrv;
	}

	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<MagazineDTO> getMagaUpSel(MagazineDTO dto) throws Exception {
		
		
		SqlSession sqlsession = factory.openSession();
		List<MagazineDTO> magadto = sqlsession.selectList("selectMagaDetail", dto);
	
		sqlsession.close();
		return magadto;
	}
	
}
