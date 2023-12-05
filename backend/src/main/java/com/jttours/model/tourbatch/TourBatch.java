package com.jttours.model.tourbatch;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jttours.model.tour.GuidedTour;
import com.jttours.model.user.Traveller;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tour_batch")
public class TourBatch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "guided_tour_id")
	private GuidedTour baseTour;

	@Max(40)
	private int capacity;
	
	@Min(500)
	private double perParticipantCost;
	
	private int availableSeats;

	@ElementCollection
	@CollectionTable(name="batch_travellers", joinColumns = @JoinColumn(name="tour_batch_id"))
	@Cascade(value = CascadeType.ALL)
	private List<Traveller> travellers;
	
	@Embedded
	private Traveller guide;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;

	public void setGuidedTour(GuidedTour gt) {
		this.baseTour = gt;
	}

	public TourBatch(Long id, LocalDate startDate, @Max(40) int capacity, @Min(500) double perParticipantCost,
			Traveller guide) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.capacity = capacity;
		this.perParticipantCost = perParticipantCost;
		this.guide = guide;
	}
	
	
}
