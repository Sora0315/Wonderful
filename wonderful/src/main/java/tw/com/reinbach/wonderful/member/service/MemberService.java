package tw.com.reinbach.wonderful.member.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.reinbach.wonderful.member.bean.MemberBean;
import tw.com.reinbach.wonderful.member.dao.MemberDAO;

@Service
public class MemberService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MemberDAO memberDAO;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public MemberBean insert(MemberBean bean) {
		return memberDAO.insert(bean);
	}

	public List<MemberBean> select(MemberBean memberBean) {
		List<MemberBean> list = null;
		if (memberBean != null && memberBean.getEmail().trim().length() != 0) {
			MemberBean tempBean = memberDAO.select(memberBean.getEmail());
			if (tempBean != null) {
				list = new ArrayList<MemberBean>();
				list.add(tempBean);
			}
		} else {
			list = memberDAO.select();
		}
		return list;
	}

	public MemberBean select(String email) {
		return memberDAO.select(email);
	}
	
	public MemberBean update(MemberBean memberBean){
		return memberDAO.update(memberBean);
	}

}
