package com.jttours.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jttours.model.tourbatch.Booking;
import com.jttours.repo.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRepository;

	public List<Booking> getAllBookings() {
		return (List<Booking>) bookingRepository.findAll();
	}
}
