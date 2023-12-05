package com.jttours.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jttours.model.tour.GuidedTour;

@Repository
public interface TourRepository extends JpaRepository<GuidedTour, Long> {
	
	List<GuidedTour> findByDaysGreaterThan(int maxDays);
	List<GuidedTour> findByDaysLessThan(int minDays);
	List<GuidedTour> findByDays(int eqDays);
	List<GuidedTour> findByDaysBetween(int maxDays, int minDays);	
	
}
