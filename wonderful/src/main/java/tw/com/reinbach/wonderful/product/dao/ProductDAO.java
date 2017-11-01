package tw.com.reinbach.wonderful.product.dao;

import java.util.List;

import tw.com.reinbach.wonderful.product.bean.ProductBean;

public interface ProductDAO {

	public ProductBean insert(ProductBean bean);

	public ProductBean update(ProductBean bean);

	public int delete(String PID);

	public ProductBean select(String PID);

	public List<ProductBean> select();

	public List<ProductBean> selectByName(String PName);
	
	public String getLstID();

}
