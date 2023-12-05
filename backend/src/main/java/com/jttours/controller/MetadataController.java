package com.jttours.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jttours.service.MetadataServiceImpl;

@RestController
@RequestMapping("/metadata")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MetadataController {
	
	@Autowired
	MetadataServiceImpl mds;

	@GetMapping("/modes")
	public ResponseEntity<?> getModes() {
		return new ResponseEntity<>(mds.allModes(), HttpStatus.OK);
	}

	@GetMapping("/difficulties")
	public ResponseEntity<?>  getDifficultyLevels() {
		return new ResponseEntity<>(mds.allDifficultyLevels(), HttpStatus.OK);
	}

	@GetMapping("/roomTypes")
	public ResponseEntity<?>  getRoomTypes() {
		return new ResponseEntity<>(mds.allRoomTypes(), HttpStatus.OK);
	}
	
	@GetMapping("/batchstatuses")
	public ResponseEntity<?>  getStatus() {
		return new ResponseEntity<>(mds.allStatus(), HttpStatus.OK);
	}
}
