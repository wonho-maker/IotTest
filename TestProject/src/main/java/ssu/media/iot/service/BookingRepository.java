package ssu.media.iot.service;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ssu.media.iot.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	Collection<Booking> findByBookingName(String bookingName);
	
}
