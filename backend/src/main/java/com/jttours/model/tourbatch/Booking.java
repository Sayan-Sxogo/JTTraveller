package com.jttours.model.tourbatch;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jttours.model.user.Traveller;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	
	@Min(100) 
	private double amount;
	
	@NotNull
	private int batchId;
	
	private String username;
	
	@ElementCollection
	@CollectionTable(name="booking_travellers", joinColumns = @JoinColumn(name="booking_id"))
	private List<Traveller> travellers;
}
