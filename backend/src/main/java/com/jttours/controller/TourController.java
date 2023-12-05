package com.jttours.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jttours.model.tour.GuidedTour;
import com.jttours.model.tourbatch.TourBatch;
import com.jttours.service.TourService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping("/tours")
public class TourController {

	@Autowired
	private TourService tourService;

	@GetMapping
	// @PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> allTours() {
		List<GuidedTour> toursList = tourService.getAllTours();
		if (!toursList.isEmpty())
			return new ResponseEntity<>(tourService.getAllTours(), HttpStatus.OK);
		else
			return new ResponseEntity<>("No tours found, please add a tour", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{id}")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> getTourById(@PathVariable(required = true) Long id) {
		GuidedTour tour = tourService.getTourById(id);
		if (tour != null)
			return new ResponseEntity<>(tour, HttpStatus.OK);
		else
			return new ResponseEntity<>("Tour do not exists", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/batches")
	// @PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> getBatchesForTour(@PathVariable Long id) {
		List<TourBatch> batchesList = tourService.getBatchesForTour(id);
		if (batchesList == null)
			return new ResponseEntity<>("Tour do not exists", HttpStatus.NOT_FOUND);
		if (!batchesList.isEmpty())
			return new ResponseEntity<>(tourService.getBatchesForTour(id), HttpStatus.OK);
		else
			return new ResponseEntity<>("No batch exists, please add a batch", HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> newTour(@RequestBody GuidedTour gt) {
		try {
			return new ResponseEntity<>(tourService.addTour(gt), HttpStatus.OK);
		}
		catch(ConstraintViolationException e) {
			return new ResponseEntity<>(ValidationController.Validation(e).getBody(), HttpStatus.BAD_REQUEST);
		}
		catch(ValidationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping
//	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> editTour(@RequestBody GuidedTour gt) {
		GuidedTour tour = tourService.updateTour(gt);
		if (tour != null)
			return new ResponseEntity<>(tour, HttpStatus.OK);
		else
			return new ResponseEntity<>("Tour do not exists", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> deleteTour(@PathVariable Long id) {
		if (tourService.deleteTourById(id))
			return new ResponseEntity<>("Tour deleted successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Tour do not exists", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/days")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> getTourByDays(@RequestParam(name = "maxDays", required = false) Integer maxDays,
			@RequestParam(name = "minDays", required = false) Integer minDays			) {
		try {
			return new ResponseEntity<>(tourService.getTourByDays(maxDays, minDays), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/popularTours")
	public ResponseEntity<?> popularTours() {
		List<GuidedTour> toursList = tourService.popularTours();
		if (!toursList.isEmpty())
			return new ResponseEntity<>(tourService.popularTours(), HttpStatus.OK);
		else
			return new ResponseEntity<>("No tours found, please add a tour", HttpStatus.BAD_REQUEST);
	}
}
