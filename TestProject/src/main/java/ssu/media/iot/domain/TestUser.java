package ssu.media.iot.domain;




import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "users")
public class TestUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="공백일 수 없습니다.")
	@NotNull
	@Column(name = "USERNAME")
	private String userName;
	
	
	@Size(min=6, message="6이상이여야 합니다.")
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	
	@NotNull
	@Size(min=8, max=10, message="8~10사이여야 합니다.")
	@Pattern(regexp="^[0-9]*$", message="숫자만 허용됩니다")
	@Column(name = "student_number", nullable = false)
	private String studentNumber;
	
	@NotBlank(message="공백일 수 없습니다.")
	@NotNull
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "my_devices")
	@JsonBackReference
	@OneToMany(mappedBy = "ownner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Devices> myDevices;
	
	

	public TestUser(Long id, String userName, String password,
			String studentNumber, String name, String role,
			List<Devices> myDevices) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.studentNumber = studentNumber;
		this.name = name;
		this.role = role;
		this.myDevices = myDevices;
	}
	
	public TestUser() {
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Devices> getMyDevices() {
		return myDevices;
	}

	public void setMyDevices(List<Devices> myDevices) {
		this.myDevices = myDevices;
	}
	
	@Override
	public String toString() {
		return "TestUser [id=" + id + ", userName=" + userName + ", password="
				+ password + ", studentNumber=" + studentNumber + ", name="
				+ name + ", role=" + role + "]";
	}
	
	public String toString2() {
		return myDevices.toString();
	}
	
	
}
