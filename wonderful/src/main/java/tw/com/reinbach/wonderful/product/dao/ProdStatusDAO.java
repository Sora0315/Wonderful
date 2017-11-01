package tw.com.reinbach.wonderful.product.dao;

import java.util.List;

import tw.com.reinbach.wonderful.product.bean.ProdStatusBean;

public interface ProdStatusDAO {

	public ProdStatusBean insert(ProdStatusBean bean);

	public ProdStatusBean update(ProdStatusBean bean);

	public int delete(String PStatusID);

	public ProdStatusBean findByPrimaryKey(String PStatusID);

	public List<ProdStatusBean> getAll();
	
	public String getLastID();

}
