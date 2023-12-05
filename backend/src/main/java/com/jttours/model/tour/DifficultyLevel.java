package com.jttours.model.tour;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum DifficultyLevel {

	HIGH("High"), MODERATE("Moderate"), EASY("Easy");

	private String level;

	public static DifficultyLevel parse(String level) {
		if (level == null)
			return null;
		return DifficultyLevel.valueOf(level.toUpperCase());
	}

	public String displayString() {
		return this.level;
	}

	public static List<Map<String,String>> getDisplayPair() {
		List<Map<String,String>>li=new ArrayList<>();
		for (DifficultyLevel type : DifficultyLevel.values()) {
			Map<String, String> types = new HashMap<>();
			types.put("optionValue", type.name());
			types.put("optionDisplayString", type.displayString());
			li.add(types);
		}
		return li;

	}
}
