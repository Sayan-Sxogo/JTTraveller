package com.jttours.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jttours.model.tourbatch.Booking;
import com.jttours.service.BookingService;


@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> allBookings() {
		List<Booking> bookingList = bookingService.getAllBookings();
		if (!bookingList.isEmpty())
			return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
		else
			return new ResponseEntity<>("No bookings found", HttpStatus.BAD_REQUEST);
	}

}
