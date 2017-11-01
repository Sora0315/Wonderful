package tw.com.reinbach.wonderful.member.dao;

import java.util.List;
import javax.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import tw.com.reinbach.wonderful.member.bean.MemberBean;

@Repository
public class MemberDAOHibernate implements MemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

	}

	@Override
	public MemberBean insert(MemberBean bean) {
		MemberBean memberBean;
		if (bean != null) {
			memberBean = (MemberBean) this.getSession().get(MemberBean.class, bean.getMemID());
			if (memberBean == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public MemberBean update(MemberBean bean) {
		if (bean != null) {
			this.getSession().saveOrUpdate(bean);
			return bean;
		}
		return null;
	}

	@Override
	public int delete(String Email) {
		if (!Email.equals(null) && Email.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			// create delete
			CriteriaDelete<MemberBean> criteriaDelete = criteriaBuilder.createCriteriaDelete(MemberBean.class);
			// set root class
			Root<MemberBean> root = criteriaDelete.from(MemberBean.class);
			// set where clause
			criteriaDelete.where(criteriaBuilder.equal(root.get("Email"), Email));
			// perform delete
			int n = this.getSession().createQuery(criteriaDelete).executeUpdate();
			return n;
		}
		return 0;
	}

	@Override
	public MemberBean select(String Email) {
		if (!Email.equals(null) && Email.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<MemberBean> criteriaQuery = criteriaBuilder.createQuery(MemberBean.class);
			Root<MemberBean> root = criteriaQuery.from(MemberBean.class);
			criteriaQuery.select(root.get("MemID")).where(criteriaBuilder.equal(root.get("Email"), Email));
			Query<MemberBean> query = this.getSession().createQuery(criteriaQuery);
			MemberBean memberBean = query.getSingleResult();
			return memberBean;
		}
		return null;
	}

	@Override
	public List<MemberBean> select() {
		try {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<MemberBean> criteriaQuery = criteriaBuilder.createQuery(MemberBean.class);
			Root<MemberBean> root = criteriaQuery.from(MemberBean.class);
			criteriaQuery.select(root);
			Query<MemberBean> query = this.getSession().createQuery(criteriaQuery);
			List<MemberBean> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getLastID() {
		String sql = "use Wonderful select top 1 substring(m.MemID, 4, 8) from Member as m order by substring(m.MemID, 4, 8) desc";
		NativeQuery<MemberBean> nativeQuery = this.getSession().createNativeQuery(sql)
				.addSynchronizedEntityClass(MemberBean.class);
		String lastID = (String) nativeQuery.getSingleResult().getMemID();
		return lastID;
	}

}
