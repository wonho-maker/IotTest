package ssu.media.iot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id @GeneratedValue
	private Long id;
	private String bookingName;
	public Booking(String bookingName) {
		super();
		this.bookingName = bookingName;
	}
	
	public Booking() {
		
	}

	public Long getId() {
		return id;
	}


	public String getBookingName() {
		return bookingName;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingName=" + bookingName + "]";
	}
}
