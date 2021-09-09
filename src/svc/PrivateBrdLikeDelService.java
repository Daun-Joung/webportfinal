package svc;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdLikeDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdLikeDelService {

	static PrivateBrdLikeDelService pblds = new PrivateBrdLikeDelService();
	
	public static PrivateBrdLikeDelService instance() {
		return pblds;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void likeDelete(PrivateBrdLikeDTO dto) {
		
		SqlSession sqlsession = factory.openSession();
		int deleteresult = sqlsession.delete("likedel", dto);
		
		if(deleteresult > 0) {
			sqlsession.commit();
		}else {
			sqlsession.rollback();
		}
		
		sqlsession.close();
		
	}
	
}
