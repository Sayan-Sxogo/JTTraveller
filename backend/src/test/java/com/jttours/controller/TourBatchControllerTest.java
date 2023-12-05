package com.jttours.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.jttours.auth.model.Role;
import com.jttours.auth.model.User;
import com.jttours.auth.repository.UserRepository;
import com.jttours.auth.service.JwtService;
import com.jttours.model.tour.Accomodation;
import com.jttours.model.tour.DayPlan;
import com.jttours.model.tour.DifficultyLevel;
import com.jttours.model.tour.GuidedTour;
import com.jttours.model.tour.Itinerary;
import com.jttours.model.tour.Mode;
import com.jttours.model.tour.RoomType;
import com.jttours.model.tourbatch.Status;
import com.jttours.model.tourbatch.TourBatch;
import com.jttours.model.user.MobileNumber;
import com.jttours.model.user.Name;
import com.jttours.model.user.Traveller;
import com.jttours.service.BookingService;
import com.jttours.service.TourBatchServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
public class TourBatchControllerTest {

	@Mock
	TourBatchServiceImpl tourBatchService;
	@Mock
	BookingService bookingService;
	@Mock
	JwtService jwtService;
	@Mock
	UserRepository userRepo;
	@Mock
	HttpServletRequest request;

	@InjectMocks
	TourBatchController tourBatchController;
	MockMvc mockMvc;
	ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
	ObjectWriter objectWriter = objectMapper.writer();

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(tourBatchController).build();
	}

	public TourBatch makeTourBatch() {
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
		MobileNumber mob1 = new MobileNumber("7982463643");
		Name name1 = new Name();
		Traveller traveller1 = new Traveller(1, mob1, name1);

		MobileNumber mob2 = new MobileNumber("8964590876");
		Name name2 = new Name("Arnab", "Patra");
		Traveller traveller2 = new Traveller(2, mob2, name2);
		MobileNumber mob3 = new MobileNumber("6789543267");
		Name name3 = new Name("Saptadeepa", "Mitra");
		Traveller traveller3 = new Traveller(3, mob3, name3);
		MobileNumber mob4 = new MobileNumber("9876421098");
		Name name4 = new Name("Deep", "Bhakat");
		Traveller traveller4 = new Traveller(4, mob4, name4);
		MobileNumber mob5 = new MobileNumber("4567890345");
		Name name5 = new Name("Bibhu", "Ray");
		Traveller guide = new Traveller(5, mob5, name5);
		List<Traveller> list = List.of(traveller1, traveller2, traveller3, traveller4);
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		TourBatch tourBatch1 = new TourBatch(1L, LocalDate.parse("2023-09-25", date),
				LocalDate.parse("2023-09-28", date), guidedTour1, 20, 2000D, 5, list, guide, Status.ACTIVE);
		return tourBatch1;

	}

	@Test
		public void TestAllTourBatches() throws Exception
		{
			TourBatch tourBatch1=makeTourBatch();
			Accomodation accomodation1=new Accomodation("Dhule Palace","Near Gurudwara, Dhule-414006",RoomType.TWIN_BED);
			DayPlan dayPlan1= new DayPlan("Dhule",145.0,1,"Ride on Mumbai Agra road. Visit Gurudwara at Dhule",accomodation1);
			Accomodation accomodation2=new Accomodation("Shirpur Guest house", "12, MIDC, Shirpur-433006", RoomType.TWIN_BED);
			DayPlan dayPlan2=new DayPlan("Shirpur", 50.0,2,"Ride on Mumbai Agra road. Visit Gurudwara at Dhule", accomodation2);
			Accomodation accomodation3=new Accomodation("Indore Palace", "12, MIDC, Shirpur-433006", RoomType.TWIN_BED);
			DayPlan dayPlan3=new DayPlan("Indore", 150.0,3,"Continue on Mumbai Agra road to complete our tour\"", accomodation3);
			List<DayPlan> dayPlanList1= List.of(dayPlan1,dayPlan2,dayPlan3);
			Itinerary itinerary= new Itinerary(dayPlanList1);
			GuidedTour guidedTour1=new GuidedTour(1L,"Mumbai-Indore", "Mumbai", "Indore", 6,5,itinerary ,DifficultyLevel.MODERATE, Mode.MOTORBIKE);
			MobileNumber mob1=new MobileNumber("7982463643");
			Name name1=new Name("Proyeti","Mitra");
			Traveller traveller1=new Traveller(1,mob1,name1);

			MobileNumber mob2=new MobileNumber("8964590876");
			Name name2=new Name("Arnab","Patra");
			Traveller traveller2=new Traveller(2,mob2,name2);
			MobileNumber mob3=new MobileNumber("6789543267");
			Name name3=new Name("Saptadeepa","Mitra");
			Traveller traveller3=new Traveller(3,mob3,name3);
			MobileNumber mob4=new MobileNumber("9876421098");
			Name name4=new Name("Deep","Bhakat");
			Traveller traveller4=new Traveller(4,mob4,name4);
			MobileNumber mob5=new MobileNumber("4567890345");
			Name name5=new Name("Bibhu","Ray");
			Traveller guide=new Traveller(5,mob5,name5);
			 List<Traveller> list=List.of(traveller1,traveller2,traveller3,traveller4);
			DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			TourBatch tourBatch2=new TourBatch(1L,LocalDate.parse("2023-09-25",date),LocalDate.parse("2023-09-28",date),guidedTour1,20,2000D,5,list,guide,Status.ACTIVE);


			List<TourBatch> tourBatchList=List.of(tourBatch1,tourBatch2);
			 
	        when(request.getHeader("Authorization")).thenReturn("Bearer mockToken");
	        when(jwtService.extractUsername("mockToken")).thenReturn("mockEmail");
	 
	        User mockUser = new User();
	        mockUser.setUserName("mockEmail");
	        mockUser.setRole(Role.ADMIN); 
	        when(userRepo.findAll()).thenReturn(List.of(mockUser));
	 
	        List<TourBatch> mockBatches = List.of(new TourBatch(/* parameters here */));
	        when(tourBatchService.getTourBatch("ADMIN")).thenReturn(mockBatches);
	 
	     
	        mockMvc.perform(MockMvcRequestBuilders
					.get("/batches")
					.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	        // Verify that methods were called
	        verify(request, times(1)).getHeader("Authorization");
	        verify(jwtService, times(1)).extractUsername("mockToken");
	        verify(userRepo, times(1)).findAll();
	        verify(tourBatchService, times(1)).getTourBatch("ADMIN");
			
		}

	@Test
	public void testGetTourBatchById() throws Exception {
		TourBatch tourBatch1 = makeTourBatch();
		// Mimicking the behaviour of findById()
		Mockito.when(tourBatchService.getTourBatchById(1L)).thenReturn(tourBatch1);
		// Mocking the get request.
		mockMvc.perform(MockMvcRequestBuilders.get("/batches/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.capacity", is(20))).andExpect(jsonPath("$.guide.name.first", is("Bibhu")));
	}

	@Test
	public void testAddTourBatch() throws Exception {

		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		MobileNumber mob5 = new MobileNumber("4567890345");
		Name name5 = new Name("Bibhu", "Ray");
		Traveller guide = new Traveller(1, mob5, name5);

		TourBatch tourBatch2 = new TourBatch(1L, LocalDate.parse("2023-11-15", date), 10, 5000.00, guide);
		String content = objectWriter.writeValueAsString(tourBatch2);

		lenient().when(tourBatchService.addTourBatch(1L, tourBatch2)).thenReturn(tourBatch2);

		mockMvc.perform(MockMvcRequestBuilders.post("/batches/tours/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()));

	}
}