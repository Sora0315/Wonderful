package tw.com.reinbach.wonderful.member.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
public class MemberBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String MemID;
	private String Name;
	private String Pwd;
	private String Addr;
	private String Cell;
	// Account register by Email
	private String Email;
	private Date RegDate;

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

	public Date getRegDate() {
		return RegDate;
	}

	public void setRegDate(Date regDate) {
		RegDate = regDate;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPwd() {
		return Pwd;
	}

	public void setPwd(String pwd) {
		Pwd = pwd;
	}

}
