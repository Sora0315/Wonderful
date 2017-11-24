package tw.com.reinbach.wonderful.order.dao;

import java.util.List;

import tw.com.reinbach.wonderful.order.bean.OrdStatusBean;

public interface OrdStatusDAO {

	public OrdStatusBean insert(OrdStatusBean bean);

	public OrdStatusBean update(OrdStatusBean bean);

	public int delete(String OrdStusName);

	public OrdStatusBean select(String OrdStusName);

	public List<OrdStatusBean> select();
	
	public String getLastID();

}
