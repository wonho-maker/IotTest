package ssu.media.iot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class SensorDataField implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="data_field_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dataValue;
	
	private Integer fieldNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date updateTime;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "mapped_field_id")
	private Devices mappedField;


	
	public SensorDataField(Long id, String dataValue, Date updateTime, Integer fieldNumber,
			Devices mappedField) {
		super();
		this.id = id;
		this.dataValue = dataValue;
		this.updateTime = updateTime;
		this.fieldNumber = fieldNumber;
		this.mappedField = mappedField;
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

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public Devices getMappedField() {
		return mappedField;
	}

	public void setMappedField(Devices mappedField) {
		this.mappedField = mappedField;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getFieldNumber() {
		return fieldNumber;
	}

	public void setFieldNumber(Integer fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	
	
}
