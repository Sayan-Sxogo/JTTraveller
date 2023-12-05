package com.jttours.controller;

import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jttours.auth.model.User;
import com.jttours.auth.repository.UserRepository;
import com.jttours.auth.service.JwtService;
import com.jttours.model.tourbatch.Booking;
import com.jttours.model.tourbatch.TourBatch;
import com.jttours.service.BookingService;
import com.jttours.service.TourBatchService;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping("/batches")
public class TourBatchController {

	@Autowired
	TourBatchService tourBatchService;

	@Autowired
	BookingService bookingService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	UserRepository userRepo;

	@GetMapping("/startDate")
	public ResponseEntity<?> getTourByDuration(@RequestParam(name = "minDate", required = false) LocalDate minDate,
			@RequestParam(name = "maxDate", required = false) LocalDate maxDate) {

		List<TourBatch> filteredTourBatch = new ArrayList<>();

		if (maxDate != null && minDate != null && maxDate.isEqual(minDate)) {
			filteredTourBatch.addAll(tourBatchService.getTourBatchOnStartingDate(maxDate));
		} else if (maxDate != null && minDate != null) {
			filteredTourBatch.addAll(tourBatchService.getTourBatchBetweenDate(minDate, maxDate));
		} else if (maxDate != null) {
			filteredTourBatch.addAll(tourBatchService.getTourBatchBeforeStartingDate(maxDate));
			filteredTourBatch.addAll(tourBatchService.getTourBatchOnStartingDate(maxDate));
		} else if (minDate != null) {
			filteredTourBatch.addAll(tourBatchService.getTourBatchAfterStartingDate(minDate));
			filteredTourBatch.addAll(tourBatchService.getTourBatchOnStartingDate(minDate));
		}

		if (filteredTourBatch.isEmpty())
			return new ResponseEntity<>("INVALID", HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(filteredTourBatch, HttpStatus.OK);
	}


	@GetMapping()
	public ResponseEntity<?> getTourBatch() {
		String token = "";
		String email = "";
		String role = "";
		try {
			token = request.getHeader("Authorization").substring(7);
			email = jwtService.extractUsername(token);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		List<User> users = userRepo.findAll();
		
		
		for(User user : users) {
			if(user.getUserName().equals(email)) {
				role = user.getRole().name();
			}
		}

		if (role.equals("")) {
			role = "CUSTOMER";
		}
		List<TourBatch> batches = tourBatchService.getTourBatch(role);
		if (!batches.isEmpty()) {
			return new ResponseEntity<>(batches, HttpStatus.OK);
			}
		else
			return new ResponseEntity<>("No batches found, please add a batch", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{batchId}")
	public ResponseEntity<?> getTourBatchById(@PathVariable Long batchId) {
		TourBatch batch = tourBatchService.getTourBatchById(batchId);
		if (batch != null)
			return new ResponseEntity<>(batch, HttpStatus.OK);
		else
			return new ResponseEntity<>("Batch do not exists", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/tours/{tourId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> newTourBatch(@RequestBody TourBatch tourBatch,
			@PathVariable(required = true) Long tourId) {
		TourBatch batch = tourBatchService.addTourBatch(tourId, tourBatch);
		if (batch != null)
			return new ResponseEntity<>(batch, HttpStatus.OK);
		else
			return new ResponseEntity<>("Tour do not exist, cannot add a batch", HttpStatus.NOT_FOUND);
	}

	@PutMapping
//	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> updateTourBatch(@RequestBody TourBatch tourBatch) {
		TourBatch batch = tourBatchService.updateTourBatch(tourBatch);
		if (batch != null)
			return new ResponseEntity<>(batch, HttpStatus.OK);
		else
			return new ResponseEntity<>("Batch do not exists", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{batchId}")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> deleteTourBatch(@PathVariable(required = true) Long batchId) {
		boolean status = tourBatchService.deleteTourBatch(batchId);
		if (status)
			return new ResponseEntity<>("Batch deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Batch do not exists", HttpStatus.NOT_FOUND);
	}

	@PostMapping("/book")
//	@PreAuthorize("hasAuthority('ADMIN') and hasAuthority('CUSTOMER')")
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public ResponseEntity<?> updateBooking(@RequestBody Booking booking) {
//		Booking bookingCheck = tourBatchService.updateTravellers(booking);
//		if (bookingCheck != null) {
			return new ResponseEntity<>(tourBatchService.updateTravellers(booking), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("Selected number of seats not available", HttpStatus.BAD_REQUEST);
//		}
	}
}