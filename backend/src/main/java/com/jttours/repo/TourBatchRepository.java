package com.jttours.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jttours.model.tourbatch.TourBatch;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TourBatchRepository extends JpaRepository<TourBatch, Long> {

	List<TourBatch> findByStartDateAfter(LocalDate startDate);

	// batches before particular date
	List<TourBatch> findByStartDateBefore(LocalDate startDate);

	// batches on same date
	List<TourBatch> findByStartDate(LocalDate startDate);

	List<TourBatch> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
	List<TourBatch> findByEndDate(LocalDate endDate);
}
