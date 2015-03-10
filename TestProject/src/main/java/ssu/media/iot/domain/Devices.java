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
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "ownner_id")
	private TestUser ownner;
	
	@OneToMany(mappedBy = "mappedDevice", cascade = CascadeType.ALL)
	private List<SensorDataField> dataFields;
	
	@OneToOne(mappedBy = "apiOwnner", cascade = CascadeType.ALL)
	@JsonBackReference
	private APIKeys apiKey;
	
	
	
	
	public Devices(Long id, String deviceName, String description, String tags,
			String location, TestUser ownner, List<SensorDataField> dataFields,
			boolean isPublic) {
		super();
		this.id = id;
		this.deviceName = deviceName;
		this.description = description;
		this.tags = tags;
		this.location = location;
		this.ownner = ownner;
		this.dataFields = dataFields;
		this.isPublic = isPublic;
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

	public TestUser getOwnner() {
		return ownner;
	}

	public void setOwnner(TestUser ownner) {
		this.ownner = ownner;
	}

	public List<SensorDataField> getDataFields() {
		return dataFields;
	}

	public void setDataFields(List<SensorDataField> dataFileds) {
		this.dataFields = dataFileds;
	}

	public APIKeys getApiKey() {
		return apiKey;
	}

	public void setApiKey(APIKeys apiKey) {
		this.apiKey = apiKey;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
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
