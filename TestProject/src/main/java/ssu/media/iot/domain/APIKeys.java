package ssu.media.iot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "api_keys")
public class APIKeys implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "api_key_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "api_key", nullable = false)
	private String apiKey;
	
	private boolean writeAble = false;
	
	private Date createdTime;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "api_ownner_id")
	private Devices apiOwnner;
	
	public APIKeys(String apiKey, Date createdTime) {
		super();
		this.apiKey = apiKey;
		this.createdTime = createdTime;
	}
	
	public APIKeys()
	{
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public boolean isWriteAble() {
		return writeAble;
	}

	public void setWriteAble(boolean writeAble) {
		this.writeAble = writeAble;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public Devices getApiOwnner() {
		return apiOwnner;
	}

	public void setApiOwnner(Devices apiOwnner) {
		this.apiOwnner = apiOwnner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
