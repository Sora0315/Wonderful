package tw.com.reinbach.wonderful.product.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProdStatus")
public class ProdStatusBean {
	
	@Id
	private String PStatusID;
	private String PStatusName;
	
	public String getPStatusID() {
		return PStatusID;
	}
	public void setPStatusID(String pStatusID) {
		PStatusID = pStatusID;
	}
	public String getPStatusName() {
		return PStatusName;
	}
	public void setPStatusName(String pStatusName) {
		PStatusName = pStatusName;
	}

}
