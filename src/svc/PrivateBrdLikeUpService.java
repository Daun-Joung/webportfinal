package svc;

import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class PrivateBrdLikeUpService {

	static PrivateBrdLikeUpService pblus = new PrivateBrdLikeUpService();
	
	public static PrivateBrdLikeUpService instance() {
		return pblus;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void likeUpdate() {
		
	}
	
}
