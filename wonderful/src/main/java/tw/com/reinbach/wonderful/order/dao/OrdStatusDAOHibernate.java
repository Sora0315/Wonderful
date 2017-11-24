package tw.com.reinbach.wonderful.order.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import tw.com.reinbach.wonderful.order.bean.OrdStatusBean;

@Repository
public class OrdStatusDAOHibernate implements OrdStatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

	}

	@Override
	public OrdStatusBean insert(OrdStatusBean bean) {
		OrdStatusBean ordStatusBean;
		if (bean != null) {
			ordStatusBean = (OrdStatusBean) this.getSession().get(OrdStatusBean.class, bean.getOStusID());
			if (ordStatusBean == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public OrdStatusBean update(OrdStatusBean bean) {
		if (bean != null) {
			this.getSession().saveOrUpdate(bean);
			return bean;
		}
		return null;
	}

	@Override
	public int delete(String OrdStusName) {
		if (!OrdStusName.equals(null) && OrdStusName.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaDelete<OrdStatusBean> criteriaDelete = criteriaBuilder.createCriteriaDelete(OrdStatusBean.class);
			Root<OrdStatusBean> root = criteriaDelete.from(OrdStatusBean.class);
			criteriaDelete.where(criteriaBuilder.equal(root.get("OrdStusName"), OrdStusName));
			int n = this.getSession().createQuery(criteriaDelete).executeUpdate();
			return n;
		}
		return 0;
	}

	@Override
	public OrdStatusBean select(String OrdStusName) {
		if (!OrdStusName.equals(null) && OrdStusName.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<OrdStatusBean> criteriaQuery = criteriaBuilder.createQuery(OrdStatusBean.class);
			Root<OrdStatusBean> root = criteriaQuery.from(OrdStatusBean.class);
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("OrdStusName"), OrdStusName));
			OrdStatusBean ordStatusBean = this.getSession().createQuery(criteriaQuery).getSingleResult();
			return ordStatusBean;
		}
		return null;
	}

	@Override
	public List<OrdStatusBean> select() {
		try {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<OrdStatusBean> criteriaQuery = criteriaBuilder.createQuery(OrdStatusBean.class);
			Root<OrdStatusBean> root = criteriaQuery.from(OrdStatusBean.class);
			criteriaQuery.select(root);
			List<OrdStatusBean> list = this.getSession().createQuery(criteriaQuery).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getLastID() {
		String sql = "use Wonderful select top 1 * from OrdStatus as o order by substring(o.OStusID, 2, 3) desc";
		NativeQuery<OrdStatusBean> nativeQuery = this.getSession().createNativeQuery(sql, OrdStatusBean.class);
		return nativeQuery.getSingleResult().getOStusID().substring(2);
	}

}
