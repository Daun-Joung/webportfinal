package svc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.MagazineDTO;
import mybatis.SqlMapConfig;

public class MagazineMainService {

	static MagazineMainService magamainsrv = new MagazineMainService();
	
	public static MagazineMainService instance() {
		return magamainsrv;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<MagazineDTO> mainSelect () {
		
		List<MagazineDTO> mainlist = new ArrayList<MagazineDTO>();
		
		SqlSession sqlsession = factory.openSession();
		mainlist = sqlsession.selectList("mainSelect");
	
		sqlsession.close();
		
		return mainlist;
	}
	
	
}
