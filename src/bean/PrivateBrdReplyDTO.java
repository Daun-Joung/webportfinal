package bean;

public class PrivateBrdReplyDTO {

	int privatereplyno;
	int pbrdno;
	String user_id;
	String reply_con;
	int private_reply_ref;
	int private_reply_lev;
	int prviate_reply_seq;
	String privatereplydate;
	String user_img;
	
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getReply_con() {
		return reply_con;
	}
	public void setReply_con(String private_reply_con) {
		this.reply_con = private_reply_con;
	}
	public int getPrivatereplyno() {
		return privatereplyno;
	}
	public void setPrivatereplyno(int privatereplyno) {
		this.privatereplyno = privatereplyno;
	}
	public int getPbrdno() {
		return pbrdno;
	}
	public void setPbrdno(int pbrdno) {
		this.pbrdno = pbrdno;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPrivate_reply_ref() {
		return private_reply_ref;
	}
	public void setPrivate_reply_ref(int private_reply_ref) {
		this.private_reply_ref = private_reply_ref;
	}
	public int getPrivate_reply_lev() {
		return private_reply_lev;
	}
	public void setPrivate_reply_lev(int private_reply_lev) {
		this.private_reply_lev = private_reply_lev;
	}
	public int getPrviate_reply_seq() {
		return prviate_reply_seq;
	}
	public void setPrviate_reply_seq(int prviate_reply_seq) {
		this.prviate_reply_seq = prviate_reply_seq;
	}
	public String getPrivatereplydate() {
		return privatereplydate;
	}
	public void setPrivatereplydate(String privatereplydate) {
		this.privatereplydate = privatereplydate;
	}
	
}