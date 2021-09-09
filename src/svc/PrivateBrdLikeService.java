package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdLikeDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdLikeService {

	static PrivateBrdLikeService pbls = new PrivateBrdLikeService();
	
	public static PrivateBrdLikeService instance() {
		return pbls;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void likeChk(PrivateBrdLikeDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int insertresult = sqlsession.insert("brdlikein", dto);
		
		if(insertresult>0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}

		sqlsession.close();
		
		
	}
	
}
