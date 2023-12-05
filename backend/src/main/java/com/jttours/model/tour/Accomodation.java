package com.jttours.model.tour;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Accomodation implements Comparable<Accomodation>{

	@NotBlank
	private String hotelName;
	
	@NotBlank
	private String address;

	@NotNull
	@Enumerated(EnumType.STRING)
	private RoomType roomType;

	@Override
	public int compareTo(Accomodation o) {
		return this.hotelName.compareTo(o.getHotelName());
	}
}
