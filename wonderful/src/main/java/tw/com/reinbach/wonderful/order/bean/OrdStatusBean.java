package tw.com.reinbach.wonderful.order.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrdStatus")
public class OrdStatusBean {

	@Id
	private String OStusID;
	private String OStusName;

	public String getOStusID() {
		return OStusID;
	}

	public void setOStusID(String oStusID) {
		OStusID = oStusID;
	}

	public String getOStusName() {
		return OStusName;
	}

	public void setOStusName(String oStusName) {
		OStusName = oStusName;
	}
}
