package com.jttours.model.tour;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Itinerary {

	@ElementCollection
	@CollectionTable(name = "dayPlan", joinColumns = @JoinColumn(name = "itinerary_id"))
	private List<DayPlan> dayPlans;
}
