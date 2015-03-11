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
	
	private Integer dataValue;

	@Temporal(TemporalType.TIMESTAMP)
	//@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date updateTime;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "mapped_field_id")
	private Fields mappedField;


	
	public SensorDataField(Long id, Integer dataValue, Date updateTime,
			Fields mappedField) {
		super();
		this.id = id;
		this.dataValue = dataValue;
		this.updateTime = updateTime;
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

	public Integer getDataValue() {
		return dataValue;
	}

	public void setDataValue(Integer dataValue) {
		this.dataValue = dataValue;
	}

	public Fields getMappedField() {
		return mappedField;
	}

	public void setMappedField(Fields mappedField) {
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

	
	
}
