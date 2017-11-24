package tw.com.reinbach.wonderful.order.dao;

import java.util.List;

import tw.com.reinbach.wonderful.order.bean.OrderBean;

public interface OrderDAO {

	public OrderBean insert(OrderBean bean);

	public OrderBean update(OrderBean bean);

	public int delete(String OrderID);

	public OrderBean findByID(String OrderID);

	public List<OrderBean> getAll();

	public List<OrderBean> getAllByMemberID(String MemberID);

	public String getLastID();

}
