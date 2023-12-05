package com.jttours.service;

import java.util.List;
import java.util.Map;

public interface MetadataService {

	public List<Map<String,String>> allModes();

	public List<Map<String,String>> allDifficultyLevels();

	public List<Map<String,String>> allRoomTypes();

	public List<Map<String,String>> allStatus();
}
