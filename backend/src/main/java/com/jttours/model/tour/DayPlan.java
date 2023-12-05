package com.jttours.model.tour;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DayPlan implements Comparable<DayPlan> {

	@NotBlank
	private String place;
	
	@NotBlank
	private Double distance;
	
	private int dayCount;
	
	@NotBlank
	private String activity;

	@Embedded
//	@Valid
	private Accomodation accomodation;

	@Override
	public int compareTo(DayPlan o) {
		return ((Integer)this.dayCount).compareTo(o.getDayCount());
	}
}
