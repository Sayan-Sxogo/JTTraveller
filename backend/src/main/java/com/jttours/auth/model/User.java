package com.jttours.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	
	@Id
	@NotNull
	private String userName;

	@NotBlank
	private String password;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;
}
