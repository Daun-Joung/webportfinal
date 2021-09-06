package svc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bean.BoardReplyDTO;
import mybatis.SqlMapConfig;

public class BoardReplyShowService {

	static BoardReplyShowService brss = new BoardReplyShowService();
	
	public static BoardReplyShowService instance() {
		return brss;
	}
	
	SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<BoardReplyDTO> getBoardReply (String num) {
		
		List<BoardReplyDTO> replylist = new ArrayList<>();
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int mktbd_num = Integer.parseInt(num);	
		map.put("mktbd_num", mktbd_num);
		
		SqlSession sqlsession = factory.openSession();
		replylist = sqlsession.selectList("marketReplySel", map);
		
		sqlsession.close();
		
		return replylist;
		
		
	}
	
}
