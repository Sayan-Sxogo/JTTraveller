package com.jttours.model.user;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Traveller {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sequence;
	
	@Embedded
	private MobileNumber mobile;

	@Embedded
	private Name name;

	public Traveller() {
		this.sequence = 0;
	}
	
	
}
