package com.jttours.model.tourbatch;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum Status {

	ACTIVE("Active"), FULL("Full"), IN_PROGRESS("In Progress"), CANCELLED("Cancelled"),COMPLETED("Complete");

	private String status;

	public static Status parse(String status) {
		if (status == null)
			return null;
		return Status.valueOf(status.toUpperCase());
	}

	public String displayString() {
		return this.status;
	}

	public static List<Map<String, String>> getDisplayPair() {
		List<Map<String, String>> li = new ArrayList<>();
		for (Status type : Status.values()) {
			Map<String, String> types = new HashMap<>();
			types.put("optionValue", type.name());
			types.put("optionDisplayString", type.displayString());
			li.add(types);
		}
		return li;

	}
}
