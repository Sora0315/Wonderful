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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import tw.com.reinbach.wonderful.member.bean.MemberBean;
import tw.com.reinbach.wonderful.product.bean.ProdStatusBean;
import tw.com.reinbach.wonderful.product.bean.ProductBean;

public class ProductDAOHibernate implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

	}

	@Override
	public ProductBean insert(ProductBean bean) {
		ProductBean productBean;
		if (bean != null) {
			productBean = (ProductBean) this.getSession().get(ProductBean.class, bean.getPID());
			if (productBean == null) {
				this.getSession().save(bean);
			}
			return bean;
		}
		return null;
	}

	@Override
	public ProductBean update(ProductBean bean) {
		if (bean != null) {
			this.getSession().saveOrUpdate(bean);
			return bean;
		}
		return null;
	}

	@Override
	public int delete(String PID) {
		if (!PID.equals(null) && PID.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			// create delete
			CriteriaDelete<ProductBean> criteriaDelete = criteriaBuilder.createCriteriaDelete(ProductBean.class);
			// set root class
			Root<ProductBean> root = criteriaDelete.from(ProductBean.class);
			// set where clause
			criteriaDelete.where(criteriaBuilder.equal(root.get("PID"), PID));
			// perform delete
			int n = this.getSession().createQuery(criteriaDelete).executeUpdate();
			return n;
		}
		return 0;
	}

	@Override
	public ProductBean select(String PID) {
		if (!PID.equals(null) && PID.trim().length() != 0) {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<ProductBean> criteriaQuery = criteriaBuilder.createQuery(ProductBean.class);
			Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("PID"), PID));
			ProductBean productBean = this.getSession().createQuery(criteriaQuery).getSingleResult();
			return productBean;
		}
		return null;
	}

	@Override
	public List<ProductBean> select() {
		try {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<ProductBean> criteriaQuery = criteriaBuilder.createQuery(ProductBean.class);
			Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
			criteriaQuery.select(root);
			List<ProductBean> list = this.getSession().createQuery(criteriaQuery).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ProductBean> selectByName(String PName) {
		try {
			CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<ProductBean> criteriaQuery = criteriaBuilder.createQuery(ProductBean.class);
			Root<ProductBean> root = criteriaQuery.from(ProductBean.class);
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("PName"), PName));
			List<ProductBean> list = this.getSession().createQuery(criteriaQuery).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;	
		}
	}

	@Override
	public String getLstID() {
		String sql = "use Wonderful select top 1 substring(p.PID, 4, 7) from Product as p order by substring(p.PID, 4, 7) desc";
		NativeQuery<ProductBean> nativeQuery = this.getSession().createNativeQuery(sql)
				.addSynchronizedEntityClass(ProductBean.class);
		String lastID = (String) nativeQuery.getSingleResult().getPID();
		return lastID;
	}

}
