package com.jttours.auth.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Role {
	
	ADMIN("admin"), CUSTOMER("customer");

	@NotBlank
	private String authority;

	public String displayString() {
		return this.authority;
	}
}
