package tw.com.reinbach.wonderful.member.dao;

import java.util.List;

import tw.com.reinbach.wonderful.member.bean.MemberBean;

public interface MemberDAO {
	
	public MemberBean insert(MemberBean bean);
	public MemberBean update(MemberBean bean);
	public int delete (String Email);
	public MemberBean select(String Email);
	public List<MemberBean> select();
	public String getLastID();
	
}
