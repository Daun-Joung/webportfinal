package svc;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.PrivateBrdReplyDTO;
import mybatis.SqlMapConfig;

public class PrivateBrdReplySelService {

	static PrivateBrdReplySelService pbrss = new PrivateBrdReplySelService();
	
	public static PrivateBrdReplySelService instance() {
		return pbrss;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<PrivateBrdReplyDTO> getReplyList(PrivateBrdReplyDTO dto){
		
		List<PrivateBrdReplyDTO> replylist = new ArrayList<PrivateBrdReplyDTO>();
		
		SqlSession sqlsession = factory.openSession();
		replylist = sqlsession.selectList("privatebrdreplyget", dto);
		
		sqlsession.close();
		
		return replylist;
	}
	
}
