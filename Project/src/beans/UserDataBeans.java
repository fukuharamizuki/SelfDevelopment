package beans;

import java.io.Serializable;
import java.util.Date;

public class UserDataBeans implements Serializable {

	private int id;
	private String name;
	private String address;
	private String tel;
	private Date birthDate;
	private String loginId;
	private String loginPass;
	private String userType;

	public UserDataBeans(int id2, String name2, String address2, String tel2, java.sql.Date birthDate2, String loginId2,
			String loginPassword, String userType2) {
		this.id = id2;
		this.name = name2;
		this.address = address2;
		this.tel = tel2;
		this.birthDate = birthDate2;
		this.loginId =loginId2;
		this.loginPass = loginPassword;
		this.userType = userType2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
