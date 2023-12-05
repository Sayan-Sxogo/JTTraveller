package com.jttours.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jttours.auth.model.Role;
import com.jttours.auth.model.User;
import com.jttours.auth.repository.UserRepository;
import com.jttours.auth.service.JwtService;
import com.jttours.model.tour.GuidedTour;
import com.jttours.model.tourbatch.Status;
import com.jttours.model.tourbatch.TourBatch;
import com.jttours.repo.TourRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;

@Service
public class TourServiceImp implements TourService {

	@Autowired
	TourRepository tourRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	JwtService jwtService;

	@Autowired
	HttpServletRequest request;

	public List<GuidedTour> getAllTours() {
		return (List<GuidedTour>) tourRepo.findAll();
	}

	public GuidedTour getTourById(Long id) {
		if (tourRepo.findById(id).isPresent())
			return tourRepo.findById(id).get();
		else
			return null;
	}

	public List<TourBatch> getBatchesForTour(Long id) {
		if (tourRepo.findById(id).isPresent()) {
			List<TourBatch> batches = tourRepo.findById(id).get().getTourBatches();
			List<TourBatch> activeBatches = new ArrayList<>();
			for (TourBatch batch : batches) {
				if (batch.getStatus().equals(Status.ACTIVE)) {
					activeBatches.add(batch);
				}
			}
			
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
			if(role.equals("ADMIN"))
				return batches;
			else 
				return activeBatches;
		} else
			return null;
	}

	public GuidedTour addTour(@Valid GuidedTour gt) {
		// checks if day-plan is not null && sets days and nights
		ValidateDayPlan_SetDayNight(gt);
		return tourRepo.save(gt);
	}

	public GuidedTour updateTour(GuidedTour gt) {
		if (tourRepo.findById(gt.getId()).isPresent()) {
			ValidateDayPlan_SetDayNight(gt);
			return tourRepo.save(gt);
		} else
			return null;
	}

	public void ValidateDayPlan_SetDayNight(GuidedTour gt) throws ValidationException {
		if (gt.getItinerary().getDayPlans().isEmpty())
			throw new ValidationException("DayPlans list cannot be empty");

		gt.setDays(gt.getItinerary().getDayPlans().size());
		System.out.println(gt.getDays());
//		System.out.println(gt.getNights());
		if (gt.getDays() == 0)
			gt.setNights(0);
		else
			gt.setNights(gt.getDays() - 1);

	}

	public Boolean deleteTourById(Long id) {
		if (tourRepo.findById(id).isPresent()) {
			tourRepo.deleteById(id);
			return true;
		} else
			return false;
	}

	public List<GuidedTour> getTourByDays(Integer maxDays, Integer minDays) {

		List<GuidedTour> filteredTour = new ArrayList<>();

		validateDays(maxDays, minDays);

		if (maxDays != null && minDays != null && maxDays == minDays) {
			filteredTour.addAll(tourRepo.findByDays(maxDays));
		} else if (maxDays != null && minDays != null && minDays < maxDays) {
			filteredTour.addAll(tourRepo.findByDaysBetween(minDays, maxDays));
		} else if (maxDays != null) {
			filteredTour.addAll(tourRepo.findByDaysGreaterThan(maxDays));
			filteredTour.addAll(tourRepo.findByDays(maxDays));
		} else if (minDays != null) {
			filteredTour.addAll(tourRepo.findByDaysLessThan(minDays));
			filteredTour.addAll(tourRepo.findByDays(minDays));
		}

		return filteredTour;
	}

	private static void validateDays(Integer maxDays, Integer minDays) {

		if (maxDays == null && minDays == null) {
			throw new RuntimeException("Invalid Days");
		}
		if (maxDays != null && minDays != null && maxDays < minDays) {
			throw new RuntimeException("Invalid Days");
		}
	}

	public List<GuidedTour> popularTours() {
		List<GuidedTour> gt = tourRepo.findAll();
		List<GuidedTour> popularTours = new ArrayList<>();
		HashMap<Long, Integer> data = new HashMap<>();
		for (GuidedTour li : gt) {
			data.put(li.getId(), li.getTourBatches().size());
			System.out.println(li.getTourBatches().size());
		}
		TreeMap<Long, Integer> sortedMap = new TreeMap<>(Comparator.<Long, Integer>comparing(data::get).reversed());

		for (Map.Entry<Long, Integer> entry : data.entrySet()) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		Iterator<Map.Entry<Long, Integer>> iterator = sortedMap.entrySet().iterator();
		int count = 0;
		while (iterator.hasNext() && count < 3) {
			Map.Entry<Long, Integer> entry = iterator.next();

			popularTours.add(tourRepo.findById(entry.getKey()).get());
			count++;
		}
		return popularTours;
	}
}
