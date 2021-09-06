package svc;

import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class PrivateBrdLikeDelService {

	static PrivateBrdLikeDelService pblds = new PrivateBrdLikeDelService();
	
	public static PrivateBrdLikeDelService instance() {
		return pblds;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public void likeDelete() {
		
	}
	
}
