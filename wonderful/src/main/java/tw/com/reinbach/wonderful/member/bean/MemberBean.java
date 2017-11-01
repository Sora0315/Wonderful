package tw.com.reinbach.wonderful.member.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Member")
public class MemberBean {

	@Id
	private String MemID;
	private String Name;
	private String Addr;
	private String Cell;
	//Account register by Email
	private String Email;
	
	public String getMemID() {
		return MemID;
	}
	public void setMemID(String memID) {
		MemID = memID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public String getCell() {
		return Cell;
	}
	public void setCell(String cell) {
		Cell = cell;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
