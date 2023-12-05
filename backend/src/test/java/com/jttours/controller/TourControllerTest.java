package com.jttours.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jttours.model.tour.Accomodation;
import com.jttours.model.tour.DayPlan;
import com.jttours.model.tour.DifficultyLevel;
import com.jttours.model.tour.GuidedTour;
import com.jttours.model.tour.Itinerary;
import com.jttours.model.tour.Mode;
import com.jttours.model.tour.RoomType;
import com.jttours.service.TourService;

@ExtendWith(MockitoExtension.class)
public class TourControllerTest {

	@Mock
	TourService tourService;

	@InjectMocks
	TourController tourController;

	MockMvc mockMvc;

	ObjectMapper objectMapper = new ObjectMapper();
	ObjectWriter objectWriter = objectMapper.writer();

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(tourController).build();
	}

	public GuidedTour makeTour() {
		Accomodation accomodation1 = new Accomodation("Dhule Palace", "Near Gurudwara, Dhule-414006",
				RoomType.TWIN_BED);
		DayPlan dayPlan1 = new DayPlan("Dhule", 145.0, 1, "Ride on Mumbai Agra road. Visit Gurudwara at Dhule",
				accomodation1);
		Accomodation accomodation2 = new Accomodation("Shirpur Guest house", "12, MIDC, Shirpur-433006",
				RoomType.TWIN_BED);
		DayPlan dayPlan2 = new DayPlan("Shirpur", 50.0, 2, "Ride on Mumbai Agra road. Visit Gurudwara at Dhule",
				accomodation2);
		Accomodation accomodation3 = new Accomodation("Indore Palace", "12, MIDC, Shirpur-433006", RoomType.TWIN_BED);
		DayPlan dayPlan3 = new DayPlan("Indore", 150.0, 3, "Continue on Mumbai Agra road to complete our tour\"",
				accomodation3);
		List<DayPlan> dayPlanList1 = List.of(dayPlan1, dayPlan2, dayPlan3);
		Itinerary itinerary = new Itinerary(dayPlanList1);
		GuidedTour guidedTour1 = new GuidedTour(1L, "Mumbai-Indore", "Mumbai", "Indore", 6, 5, itinerary,
				DifficultyLevel.MODERATE, Mode.MOTORBIKE);
		return guidedTour1;
	}

	@Test
	public void TestAllTours() throws Exception {
		GuidedTour guidedTour1 = makeTour();
		Accomodation accomodation4 = new Accomodation("Hotel Mayur", "SB road, Thane", RoomType.TWIN_BED);
		DayPlan dayPlan4 = new DayPlan("Mumbai", 0.0, 0,
				"reporting between 5 pm to 7 pm. Introduction, tour briefing and ice breaker", accomodation4);
		Accomodation accomodation5 = new Accomodation("Dwarka Hotel", "Dwarka chauk, Nasik", RoomType.DOUBLE_BED);
		DayPlan dayPlan5 = new DayPlan("Nasik", 155.0, 1, "Ride on good highway on Mumbai Agra road. Stay and rest",
				accomodation5);
		Accomodation accomodation6 = new Accomodation("Dhule Palace", "Near Gurudwara, Dhule-414006",
				RoomType.TWIN_BED);
		DayPlan dayPlan6 = new DayPlan("Dhule", 145.0, 2, "Ride on Mumbai Agra road. Visit Gurudwara at Dhule",
				accomodation6);
		List<DayPlan> dayPlanList2 = List.of(dayPlan4, dayPlan5, dayPlan6);
		Itinerary itinerary2 = new Itinerary(dayPlanList2);
		GuidedTour guidedTour2 = new GuidedTour(1L, "Mumbai-Indore", "Mumbai", "Indore", 6, 5, itinerary2,
				DifficultyLevel.MODERATE, Mode.MOTORBIKE);

		// Making list of guided tour
		List<GuidedTour> guidedTourList = List.of(guidedTour1, guidedTour2);

		// Mocking tourService.getAllTours()
		Mockito.when(tourService.getAllTours()).thenReturn(guidedTourList);

		// Mocking the get request
		mockMvc.perform(MockMvcRequestBuilders.get("/tours").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[1].name", is("Mumbai-Indore")))
				.andExpect(jsonPath("$[1].itinerary.dayPlans[0].place", is("Mumbai")));

	}

	@Test
	public void testGetTourById() throws Exception {
		GuidedTour guidedTour1 = makeTour();

		// Mimicking the behaviour of findById()
		Mockito.when(tourService.getTourById(1L)).thenReturn(guidedTour1);

		// Mocking the get request.
		mockMvc.perform(MockMvcRequestBuilders.get("/tours/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.name", is("Mumbai-Indore")))
				.andExpect(jsonPath("$.itinerary.dayPlans[0].place", is("Dhule")));
	}

	@Test
	@WithMockUser(authorities = "ADMIN")
	public void testAddTour() throws Exception {
		GuidedTour guidedTour1 = makeTour();
		String content = objectWriter.writeValueAsString(guidedTour1);

		when(tourService.addTour(guidedTour1)).thenReturn(guidedTour1);

		// Act
		ResponseEntity<?> responseEntity = tourController.newTour(guidedTour1);

		// Add more assertions based on your specific response structure

		mockMvc.perform(MockMvcRequestBuilders.post("/tours")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(content))
				.andExpect(status().isOk());
	}
}
