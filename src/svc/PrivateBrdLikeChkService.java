package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdLikeDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdLikeChkService {

	static PrivateBrdLikeChkService pblus = new PrivateBrdLikeChkService();
	
	public static PrivateBrdLikeChkService instance() {
		return pblus;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public int likeCount(PrivateBrdLikeDTO dto) {
		
		int likecount;
		
		SqlSession sqlsession = factory.openSession();
		likecount = sqlsession.selectOne("privatebrdlike", dto);
		
		return likecount;
		
	}
	
}
