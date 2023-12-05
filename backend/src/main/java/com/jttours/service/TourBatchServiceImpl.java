package com.jttours.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jttours.model.tour.GuidedTour;
import com.jttours.model.tourbatch.Booking;
import com.jttours.model.tourbatch.Status;
import com.jttours.model.tourbatch.TourBatch;
import com.jttours.model.user.Traveller;
import com.jttours.repo.BookingRepository;
import com.jttours.repo.TourBatchRepository;

@Service
public class TourBatchServiceImpl implements TourBatchService {

	@Autowired
	TourBatchRepository tourBatchRepo;

	@Autowired
	TourService tourService;

	@Autowired
	BookingRepository bookingRepo;

	public List<TourBatch> getTourBatch(String role) {
		
		updateStatusOFBatch();
		List<TourBatch> batches = tourBatchRepo.findAll();
		List<TourBatch> activeBatches = new ArrayList<>();
		for (TourBatch batch : batches) {
			if (batch.getStatus().equals(Status.ACTIVE)) {
				activeBatches.add(batch);
			}
		}

		if (role.equals("ADMIN")) {
			return batches;
		} else {
			return activeBatches;
		}
	}

	public TourBatch getTourBatchById(Long id) {
		Optional<TourBatch> batch = tourBatchRepo.findById(id);
		if (batch.isPresent()) {
			updateStatusOFBatch();
			return batch.get();
		} else
			return null;
	}

	public TourBatch addTourBatch(Long tourId, TourBatch tourBatch) {
		GuidedTour gt = tourService.getTourById(tourId);
		if (gt == null)
			return null;
		else {
			tourBatch.setGuidedTour(gt);

			LocalDate endDate = calculateEndDate(gt, tourBatch.getStartDate());
			tourBatch.setEndDate(endDate);
			tourBatch.setAvailableSeats(tourBatch.getCapacity());
			tourBatch.setStatus(Status.ACTIVE);
			return tourBatchRepo.save(tourBatch);
		}
	}

	public TourBatch updateTourBatch(TourBatch tourBatch) {
		Optional<TourBatch> tb = tourBatchRepo.findById(tourBatch.getId());
		if (tb.isPresent()) {
			// if batch exists then guided tour will also be exists
			GuidedTour gt = tb.get().getBaseTour();
			tourBatch.setGuidedTour(gt);

			LocalDate endDate = calculateEndDate(gt, tourBatch.getStartDate());
			tourBatch.setEndDate(endDate);

			return tourBatchRepo.save(tourBatch);
		} else
			return null;
	}

	public Boolean deleteTourBatch(Long batchId) {
		if (tourBatchRepo.findById(batchId).isPresent()) {
			tourBatchRepo.deleteById(batchId);
			return true;
		} else
			return false;
	}

	public LocalDate calculateEndDate(GuidedTour guidedTour, LocalDate startDate) {
		int duration = guidedTour.getDays();
		LocalDate endDate = startDate.plusDays(duration);
		return endDate;
	}

	public Booking updateTravellers(Booking booking) {
		TourBatch batch = tourBatchRepo.findById((long) booking.getBatchId()).get();
		if (batch != null) {
			int availSeats = (int) batch.getAvailableSeats();
			List<Traveller> travellers = booking.getTravellers();
			if (availSeats >= travellers.size()) {

				availSeats = availSeats - travellers.size();
				batch.setAvailableSeats(availSeats);

			} else {
				return null;
			}

			if (batch.getAvailableSeats() == 0) {
				batch.setStatus(Status.FULL);
			}

			int participants = batch.getCapacity() - batch.getAvailableSeats();

			for (Traveller traveller : travellers) {
				participants = participants + 1;
				traveller.setSequence(participants);
			}

			booking.setTravellers(travellers);

			List<Traveller> addTravellers = batch.getTravellers();
			addTravellers.addAll(travellers);

			batch.setTravellers(addTravellers);
			tourBatchRepo.save(batch);

			int bookingIndex = 1;
			for (Traveller traveller : travellers) {
				traveller.setSequence(bookingIndex);
				bookingIndex++;
			}

			return bookingRepo.save(booking);
		}
		return null;
	}

	public List<TourBatch> getTourBatchAfterStartingDate(LocalDate startDate) {
		return tourBatchRepo.findByStartDateAfter(startDate);
	}

	public List<TourBatch> getTourBatchBeforeStartingDate(LocalDate startDate) {
		return tourBatchRepo.findByStartDateBefore(startDate);
	}

	public List<TourBatch> getTourBatchOnStartingDate(LocalDate startDate) {
		return tourBatchRepo.findByStartDate(startDate);
	}

	public List<TourBatch> getTourBatchBetweenDate(LocalDate startDate, LocalDate endDate) {
		return tourBatchRepo.findByStartDateBetween(startDate, endDate);
	}

	// for updating status of batch on the basis of available seats
	public void updateStatusOFBatch() {
		LocalDate currantDate = LocalDate.now();
		System.out.println(currantDate);
		List<TourBatch> li = tourBatchRepo.findByStartDate(currantDate);
		List<TourBatch> end = tourBatchRepo.findByEndDate(currantDate);

		if (li.isEmpty()) {
			System.out.println("no batch found");
		} else {
			for (TourBatch li1 : li) {
				if (li1.getAvailableSeats() == li1.getCapacity()) {
					li1.setStatus(Status.CANCELLED);
					tourBatchRepo.save(li1);
				} else {
					li1.setStatus(Status.IN_PROGRESS);
					tourBatchRepo.save(li1);
				}
			}
		}

		if (end.isEmpty()) {
			System.out.println("no batch found");
		} else {
			for (TourBatch li1 : end) {
				if (li1.getStatus().equals(Status.IN_PROGRESS)) {
					li1.setStatus(Status.COMPLETED);
					tourBatchRepo.save(li1);
				}
			}
		}
	}
}
