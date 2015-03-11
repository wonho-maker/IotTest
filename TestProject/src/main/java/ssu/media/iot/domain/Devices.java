package ssu.media.iot.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name = "devices")
@JsonInclude(Include.NON_NULL)
public class Devices implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="device_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "must be fill")
	@NotNull
	@Column(name = "device_name")
	private String deviceName;
	
	@NotBlank(message = "must be fill")
	private String description;
	
	@NotBlank(message = "must be fill")
	private String tags;
	
	@NotBlank(message = "must be fill")
	private String location;
	
	private String dataName1;
	
	private String dataName2;
	
	private String dataName3;
	
	private String dataName4;
	
	private String dataName5;
	
	private boolean isPublic;
	
	/*@OneToOne(mappedBy = "fieldOwnner", cascade = CascadeType.ALL)
	private Fields dataField1 = new Fields();
	
	@OneToOne(mappedBy = "fieldOwnner", cascade = CascadeType.ALL)
	private Fields dataField2 = new Fields();
	
	@OneToOne(mappedBy = "fieldOwnner", cascade = CascadeType.ALL)
	private Fields dataField3 = new Fields();
	
	@OneToOne(mappedBy = "fieldOwnner", cascade = CascadeType.ALL)
	private Fields dataField4 = new Fields();
	
	@OneToOne(mappedBy = "fieldOwnner", cascade = CascadeType.ALL)
	private Fields dataField5 = new Fields();*/
	
	@OneToMany(mappedBy = "mappedField", cascade = CascadeType.ALL)
	private List<SensorDataField> dataField;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "ownner_id")
	private TestUser ownner;
	
	
	
	@OneToOne(mappedBy = "apiOwnner", cascade = CascadeType.ALL)
	@JsonBackReference
	private APIKeys apiKey;
	
	
	
	

	public Devices(Long id, String deviceName, String description, String tags,
			String location, String dataName1, String dataName2,
			String dataName3, String dataName4, String dataName5,
			boolean isPublic, Fields dataField1, Fields dataField2,
			Fields dataField3, Fields dataField4, Fields dataField5,
			TestUser ownner, APIKeys apiKey) {
		super();
		this.id = id;
		this.deviceName = deviceName;
		this.description = description;
		this.tags = tags;
		this.location = location;
		this.dataName1 = dataName1;
		this.dataName2 = dataName2;
		this.dataName3 = dataName3;
		this.dataName4 = dataName4;
		this.dataName5 = dataName5;
		this.isPublic = isPublic;
		/*this.dataField1 = dataField1;
		this.dataField2 = dataField2;
		this.dataField3 = dataField3;
		this.dataField4 = dataField4;
		this.dataField5 = dataField5;*/
		this.ownner = ownner;
		this.apiKey = apiKey;
	}

	public Devices(String deviceName)
	{
		super();
		this.deviceName = deviceName;
	}
	
	public Devices()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDataName1() {
		return dataName1;
	}

	public void setDataName1(String dataName1) {
		this.dataName1 = dataName1;
	}

	public String getDataName2() {
		return dataName2;
	}

	public void setDataName2(String dataName2) {
		this.dataName2 = dataName2;
	}

	public String getDataName3() {
		return dataName3;
	}

	public void setDataName3(String dataName3) {
		this.dataName3 = dataName3;
	}

	public String getDataName4() {
		return dataName4;
	}

	public void setDataName4(String dataName4) {
		this.dataName4 = dataName4;
	}

	public String getDataName5() {
		return dataName5;
	}

	public void setDataName5(String dataName5) {
		this.dataName5 = dataName5;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	/*public Fields getDataField1() {
		return dataField1;
	}

	public void setDataField1(Fields dataField1) {
		this.dataField1 = dataField1;
	}

	public Fields getDataField2() {
		return dataField2;
	}

	public void setDataField2(Fields dataField2) {
		this.dataField2 = dataField2;
	}

	public Fields getDataField3() {
		return dataField3;
	}

	public void setDataField3(Fields dataField3) {
		this.dataField3 = dataField3;
	}

	public Fields getDataField4() {
		return dataField4;
	}

	public void setDataField4(Fields dataField4) {
		this.dataField4 = dataField4;
	}

	public Fields getDataField5() {
		return dataField5;
	}

	public void setDataField5(Fields dataField5) {
		this.dataField5 = dataField5;
	}*/
	
	
	
	public TestUser getOwnner() {
		return ownner;
	}

	public List<SensorDataField> getDataField() {
		return dataField;
	}

	public void setDataField(List<SensorDataField> dataField) {
		this.dataField = dataField;
	}

	public void setOwnner(TestUser ownner) {
		this.ownner = ownner;
	}

	public APIKeys getApiKey() {
		return apiKey;
	}

	public void setApiKey(APIKeys apiKey) {
		this.apiKey = apiKey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Devices [id=" + id + ", deviceName=" + deviceName
				+ ", description=" + description + ", tags=" + tags
				+ ", location=" + location + ", dataName1=" + dataName1
				+ ", dataName2=" + dataName2 + ", dataName3=" + dataName3
				+ ", dataName4=" + dataName4 + ", dataName5=" + dataName5
				+ ", ownner=" + ownner + ", isPublic=" + isPublic + "]";
	}
}
