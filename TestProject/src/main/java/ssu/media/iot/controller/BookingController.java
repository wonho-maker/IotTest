package ssu.media.iot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ssu.media.iot.domain.Booking;
import ssu.media.iot.service.BookingRepository;

@RestController
public class BookingController {
	
	@RequestMapping(value="/bookings", method=RequestMethod.GET)
	Collection<Booking> bookings()
	{
		return this.bookingRepository.findAll();
		
	}
	
	@Autowired
	BookingRepository bookingRepository;
}
