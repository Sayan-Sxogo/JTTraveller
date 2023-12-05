package com.jttours.service;

import java.util.List;

import com.jttours.model.tour.GuidedTour;
import com.jttours.model.tourbatch.TourBatch;

public interface TourService {

	public List<GuidedTour> getAllTours();

	public GuidedTour getTourById(Long id);

	public List<TourBatch> getBatchesForTour(Long id);

	public GuidedTour addTour(GuidedTour gt);

	public GuidedTour updateTour(GuidedTour updatedGuidedtour);

	public Boolean deleteTourById(Long id);
	
	public List<GuidedTour> getTourByDays(Integer maxDays, Integer minDays);

	public List<GuidedTour>popularTours();
}
