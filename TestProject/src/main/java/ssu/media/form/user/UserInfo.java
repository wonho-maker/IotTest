package ssu.media.form.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserInfo {
	
	@NotNull(message="공백일 수 없습니다.")
	@Size(min=2, max=10)
	private String name;
	
	@NotNull(message="공백일 수 없습니다.")
	private Integer studentNumber;
	
	@NotNull(message="공백일 수 없습니다.")
	private String userID;
	
	@NotNull(message="공백일 수 없습니다.")
	@Size(min=2)
	private String password;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getUserID() {
		return userID;
	}


	public void setUserID(String userId) {
		this.userID = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", studentNumber=" + studentNumber
				+ ", userID=" + userID + ", password=" + password + "]";
	}
	
	
}
