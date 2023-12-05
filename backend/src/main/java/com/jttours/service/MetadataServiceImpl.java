package com.jttours.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jttours.model.tour.DifficultyLevel;
import com.jttours.model.tour.Mode;
import com.jttours.model.tour.RoomType;
import com.jttours.model.tourbatch.Status;

@Service
public class MetadataServiceImpl implements MetadataService {
	@Autowired

	public List<Map<String,String>> allModes() {
		return Mode.getDisplayPair();
	}

	public List<Map<String,String>> allDifficultyLevels() {
		return DifficultyLevel.getDisplayPair();
	}

	public List<Map<String,String>> allRoomTypes() {
		return RoomType.getDisplayPair();
	}

	public List<Map<String,String>> allStatus() {
		return Status.getDisplayPair();
	}
}
