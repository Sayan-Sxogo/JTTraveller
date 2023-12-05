package com.jttours.model.tour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
public enum RoomType {

	TWIN_BED("Twin Bed"), DOUBLE_BED("Double Bed");

	private String type;

	public static RoomType parse(String type) {
		if (type == null)
			return null;
		return RoomType.valueOf(type.toUpperCase());
	}

	public String displayString() {
		return this.type;
	}

	public static List<Map<String, String>> getDisplayPair() {
		List<Map<String, String>> li = new ArrayList<>();
		for (RoomType type : RoomType.values()) {
			Map<String, String> types = new HashMap<>();
			types.put("optionValue", type.name());
			types.put("optionDisplayString", type.displayString());
			li.add(types);
		}
		return li;
	}
}
