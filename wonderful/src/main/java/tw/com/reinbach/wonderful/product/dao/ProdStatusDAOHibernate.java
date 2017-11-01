package tw.com.reinbach.wonderful.product.dao;

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

import tw.com.reinbach.wonderful.member.bean.MemberBean;
import tw.com.reinbach.wonderful.product.bean.ProdStatusBean;

@Repository
public class ProdStatusDAOHibernate implements ProdStatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

	}

	@Override
	public ProdStatusBean insert(ProdStatusBean bean) {
		ProdStatusBean prodStatusBean;
		if (bean != null) {
			prodStatusBean = (ProdStatusBean) this.getSession().get(ProdStatusBean.class, bean.getPStatusID());
			if (prodStatusBean == null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public ProdStatusBean update(ProdStatusBean bean) {
		if (bean != null) {
			this.getSession().saveOrUpdate(bean);
			return bean;
		}
		return null;
	}

	@Override
	public int delete(String PStatusID) {
		if (!PStatusID.equals(null) && PStatusID.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			// create delete
			CriteriaDelete<ProdStatusBean> criteriaDelete = criteriaBuilder.createCriteriaDelete(ProdStatusBean.class);
			// set root class
			Root<ProdStatusBean> root = criteriaDelete.from(ProdStatusBean.class);
			// set where clause
			criteriaDelete.where(criteriaBuilder.equal(root.get("PStusID"), PStatusID));
			// perform delete
			int n = this.getSession().createQuery(criteriaDelete).executeUpdate();
			return n;
		}
		return 0;
	}

	@Override
	public ProdStatusBean findByPrimaryKey(String PStatusID) {
		if (!PStatusID.equals(null) && PStatusID.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<ProdStatusBean> criteriaQuery = criteriaBuilder.createQuery(ProdStatusBean.class);
			Root<ProdStatusBean> root = criteriaQuery.from(ProdStatusBean.class);
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("PStusID"), PStatusID));
			ProdStatusBean prodStatusBean = this.getSession().createQuery(criteriaQuery).getSingleResult();
			return prodStatusBean;
		}
		return null;
	}

	@Override
	public List<ProdStatusBean> getAll() {
		try {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<ProdStatusBean> criteriaQuery = criteriaBuilder.createQuery(ProdStatusBean.class);
			Root<ProdStatusBean> root = criteriaQuery.from(ProdStatusBean.class);
			criteriaQuery.select(root);
			List<ProdStatusBean> list = this.getSession().createQuery(criteriaQuery).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getLastID() {
		String sql = "use Wonderful select top 1 substring(p.PStusID, 3, 3) from ProdStatus as p order by substring(p.PStusID, 3, 3) desc";
		NativeQuery<ProdStatusBean> nativeQuery = this.getSession().createNativeQuery(sql)
				.addSynchronizedEntityClass(ProdStatusBean.class);
		String lastID = (String) nativeQuery.getSingleResult().getPStatusID();
		return lastID;
	}

}
