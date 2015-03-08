package ssu.media.iot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@JsonInclude(Include.NON_NULL)
public class SensorDataField implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="data_field_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer dataValue1;
	
	private Integer dataValue2;

	private Integer dataValue3;
	
	private Integer dataValue4;
	
	private Integer dataValue5;
	
	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date updateTime;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "mapped_device_id")
	private Devices mappedDevice;

	public SensorDataField(Long id, 
			Integer dataValue1, Integer dataValue2, Integer dataValue3,
			Integer dataValue4, Integer dataValue5, Date updateTime,
			Devices mappedDevice) {
		super();
		this.id = id;
		this.dataValue1 = dataValue1;
		this.dataValue2 = dataValue2;
		this.dataValue3 = dataValue3;
		this.dataValue4 = dataValue4;
		this.dataValue5 = dataValue5;
		this.updateTime = updateTime;
		this.mappedDevice = mappedDevice;
	}
	
	public SensorDataField()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Integer getDataValue1() {
		return dataValue1;
	}

	public void setDataValue1(Integer dataValue1) {
		this.dataValue1 = dataValue1;
	}

	public Integer getDataValue2() {
		return dataValue2;
	}

	public void setDataValue2(Integer dataValue2) {
		this.dataValue2 = dataValue2;
	}

	public Integer getDataValue3() {
		return dataValue3;
	}

	public void setDataValue3(Integer dataValue3) {
		this.dataValue3 = dataValue3;
	}

	public Integer getDataValue4() {
		return dataValue4;
	}

	public void setDataValue4(Integer dataValue4) {
		this.dataValue4 = dataValue4;
	}

	public Integer getDataValue5() {
		return dataValue5;
	}

	public void setDataValue5(Integer dataValue5) {
		this.dataValue5 = dataValue5;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Devices getMappedDevice() {
		return mappedDevice;
	}

	public void setMappedDevice(Devices mappedDevice) {
		this.mappedDevice = mappedDevice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SensorDataField [id=" + id 
				+ ", dataValue1=" + dataValue1 + ", dataValue2=" + dataValue2
				+ ", dataValue3=" + dataValue3 + ", dataValue4=" + dataValue4
				+ ", dataValue5=" + dataValue5 + ", updateTime=" + updateTime
				+ ", mappedDevice=" + mappedDevice + "]";
	}
	
	
	
}
