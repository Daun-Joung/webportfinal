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
	
	public int likeChk(PrivateBrdLikeDTO dto) {
		
		int likecount;
		
		SqlSession sqlsession = factory.openSession();
		likecount = sqlsession.selectOne("privatebrdlike", dto);
		
		sqlsession.close();
		
		return likecount;
		
	}
	
}
