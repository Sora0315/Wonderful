package tw.com.reinbach.wonderful.order.bean;

import java.sql.Timestamp;
import javax.persistence.*;
import tw.com.reinbach.wonderful.member.bean.MemberBean;

@Entity
@Table(name = "Order")
public class OrderBean {
	
	@Id
	private String OID;
	@ManyToOne
	@JoinColumn(name = "MemID")
	private MemberBean memberBean;
	@ManyToOne
	@JoinColumn(name = "OStusID")
	private OrdStatusBean ordStatusBean;
	private Timestamp OTime;
	private int Total;

	public String getOID() {
		return OID;
	}

	public void setOID(String oID) {
		OID = oID;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public OrdStatusBean getOrdStatusBean() {
		return ordStatusBean;
	}

	public void setOrdStatusBean(OrdStatusBean ordStatusBean) {
		this.ordStatusBean = ordStatusBean;
	}

	public Timestamp getOTime() {
		return OTime;
	}

	public void setOTime(Timestamp oTime) {
		OTime = oTime;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

}
