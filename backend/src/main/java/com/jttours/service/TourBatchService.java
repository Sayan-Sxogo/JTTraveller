package com.jttours.service;

import java.time.LocalDate;
import java.util.List;
import com.jttours.model.tourbatch.Booking;
import com.jttours.model.tourbatch.TourBatch;

public interface TourBatchService {

	public TourBatch addTourBatch(Long tourId, TourBatch tourBatch);

	public List<TourBatch> getTourBatch(String role);

	public TourBatch getTourBatchById(Long id);

	public TourBatch updateTourBatch(TourBatch updatedTourBatch);

	public Boolean deleteTourBatch(Long batchId);
	
	public Booking updateTravellers(Booking booking);

	public List<TourBatch> getTourBatchAfterStartingDate(LocalDate startDate);

	public List<TourBatch> getTourBatchBeforeStartingDate(LocalDate startDate);

	public List<TourBatch> getTourBatchOnStartingDate(LocalDate startDate);


	public List<TourBatch> getTourBatchBetweenDate(LocalDate startDate,LocalDate endDate);

public void updateStatusOFBatch();
}
