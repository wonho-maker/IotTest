package ssu.media.iot.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Fields {
	
	@Id
	@Column(name = "field_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*@OneToMany(mappedBy = "mappedField", cascade = CascadeType.ALL)
	private List<SensorDataField> dataField;*/
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "field_ownner_id")
	private Devices fieldOwnner;
	
	public Fields(Long id, List<SensorDataField> dataField) {
		super();
		this.id = id;
		//this.dataField = dataField;
	}
	
	public Fields()
	{
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public List<SensorDataField> getDataField() {
		return dataField;
	}

	public void setDataField(List<SensorDataField> dataField) {
		this.dataField = dataField;
	}*/
	
	
}
