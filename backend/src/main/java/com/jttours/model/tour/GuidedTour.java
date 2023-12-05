package com.jttours.model.tour;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jttours.model.tourbatch.TourBatch;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "base_Tour")
public class GuidedTour implements Comparable<GuidedTour> {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Pattern(regexp = "^[\\p{Alnum}_-]{5,60}+$")
	private String name;

	@NotBlank
	@Pattern(regexp = "^[\\p{Alnum}_-]{2,50}+$")
	private String startAt;

	@NotBlank
	@Pattern(regexp = "^[\\p{Alnum}_-]{2,50}+$")
	private String endAt;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Mode mode;

	private int days;

	private int nights;

	@NotNull
	@Enumerated(EnumType.STRING)
	private DifficultyLevel difficultyLevel;

	@Embedded 
	@Valid
	private Itinerary itinerary;

	@JsonIgnore
	@OneToMany(mappedBy = "baseTour", cascade = CascadeType.ALL)
	private List<TourBatch> tourBatches;

	@Override
	public int compareTo(GuidedTour o) {
		return this.name.toUpperCase().compareTo(o.getName().toUpperCase());
	}

	public GuidedTour(@NotNull long id, @NotBlank String name, @NotBlank String startAt, @NotBlank String endAt,
			@Min(1) int days, int nights, Itinerary itinerary, DifficultyLevel difficulty, Mode mode) {
		super();
		this.id = id;
		this.name = name;
		this.startAt = startAt;
		this.endAt = endAt;
		this.days = days;
		this.nights = nights;
		this.itinerary = itinerary;
		this.difficultyLevel = difficulty;
		this.mode = mode;
	}
}
