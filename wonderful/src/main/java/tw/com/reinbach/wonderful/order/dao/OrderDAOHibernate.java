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
import tw.com.reinbach.wonderful.order.bean.OrderBean;

@Repository
public class OrderDAOHibernate implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

	}

	@Override
	public OrderBean insert(OrderBean bean) {
		OrderBean orderBean;
		if (bean != null) {
			orderBean = (OrderBean) this.getSession().get(OrderBean.class, bean.getOID());
			if (orderBean == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public OrderBean update(OrderBean bean) {
		if (bean != null) {
			this.getSession().saveOrUpdate(bean);
			return bean;
		}
		return null;
	}

	@Override
	public int delete(String OrderID) {
		if (!OrderID.equals(null) && OrderID.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaDelete<OrderBean> criteriaDelete = criteriaBuilder.createCriteriaDelete(OrderBean.class);
			Root<OrderBean> root = criteriaDelete.from(OrderBean.class);
			criteriaDelete.where(criteriaBuilder.equal(root.get("OID"), OrderID));
			int n = this.getSession().createQuery(criteriaDelete).executeUpdate();
			return n;
		}
		return 0;
	}

	@Override
	public OrderBean findByID(String OrderID) {
		if (!OrderID.equals(null) && OrderID.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<OrderBean> criteriaQuery = criteriaBuilder.createQuery(OrderBean.class);
			Root<OrderBean> root = criteriaQuery.from(OrderBean.class);
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("OID"), OrderID));
			OrderBean orderBean = (OrderBean) this.getSession().createQuery(criteriaQuery).getSingleResult();
			return orderBean;
		}
		return null;
	}

	@Override
	public List<OrderBean> getAll() {
		try {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<OrderBean> criteriaQuery = criteriaBuilder.createQuery(OrderBean.class);
			Root<OrderBean> root = criteriaQuery.from(OrderBean.class);
			criteriaQuery.select(root);
			List<OrderBean> list = (List<OrderBean>) this.getSession().createQuery(criteriaQuery).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OrderBean> getAllByMemberID(String MemberID) {
		try {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<OrderBean> criteriaQuery = criteriaBuilder.createQuery(OrderBean.class);
			Root<OrderBean> root = criteriaQuery.from(OrderBean.class);
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("MemID"), MemberID));
			List<OrderBean> list = this.getSession().createQuery(criteriaQuery).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getLastID() {
		String sql = "use Wonderful select top 1 * from Order as o order by substring(o.OID, 2, 14) desc";
		NativeQuery<OrderBean> nativeQuery = this.getSession().createNativeQuery(sql, OrderBean.class);
		return nativeQuery.getSingleResult().getOID().substring(1);
	}

}
