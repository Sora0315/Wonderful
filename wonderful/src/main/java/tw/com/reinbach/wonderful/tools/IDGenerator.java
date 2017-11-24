package tw.com.reinbach.wonderful.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.reinbach.wonderful.member.dao.MemberDAO;
import tw.com.reinbach.wonderful.order.dao.OrdStatusDAO;
import tw.com.reinbach.wonderful.order.dao.OrderDAO;

@Service
public class IDGenerator {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private OrdStatusDAO ordStatusDAO;

	public String getMemberID() {
		String tempNumber = "0000000" + (Integer.parseInt(memberDAO.getLastID()) + 1);
		System.out.println(tempNumber);
		return "MEM" + tempNumber.substring(tempNumber.length() - 8);
	}

}
