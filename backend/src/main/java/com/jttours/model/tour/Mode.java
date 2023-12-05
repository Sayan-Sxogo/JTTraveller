package com.jttours.model.tour;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum Mode {

	WALK("Walk"), BICYCLE("Bicycle"), MOTORBIKE("Motorbike");

	private String mode;
	
	public static Mode parse(String mode) {
		if (mode == null)
			return null;
		return Mode.valueOf(mode.toUpperCase());
	}

	public String displayString() {
		return this.mode;
	}

	public static List<Map<String,String>> getDisplayPair() {
		List<Map<String,String>>li=new ArrayList<>();
		for (Mode type : Mode.values()) {
			Map<String, String> types = new HashMap<>();
			types.put("optionValue", type.name());
			types.put("optionDisplayString", type.displayString());
			li.add(types);
		}
		return li;

	}
}
