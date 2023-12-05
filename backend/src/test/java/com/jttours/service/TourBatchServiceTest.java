package com.jttours.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

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
import com.jttours.repo.TourBatchRepository;

@ExtendWith(MockitoExtension.class)
public class TourBatchServiceTest {
	
	@Mock
	private TourBatchRepository tourBatchRepo;
	
	@Mock
	private TourServiceImp tourService;
	
	@InjectMocks
	private TourBatchServiceImpl tourBatchService;
	
	
	GuidedTour guidedTour;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	public TourBatch makeTour()
	{
		Accomodation accomodation1=new Accomodation("Dhule Palace","Near Gurudwara, Dhule-414006",RoomType.TWIN_BED);
		DayPlan dayPlan1= new DayPlan("Dhule",145.0,1,"Ride on Mumbai Agra road. Visit Gurudwara at Dhule",accomodation1);
		Accomodation accomodation2=new Accomodation("Shirpur Guest house", "12, MIDC, Shirpur-433006", RoomType.TWIN_BED);
		DayPlan dayPlan2=new DayPlan("Shirpur", 50.0,2,"Ride on Mumbai Agra road. Visit Gurudwara at Dhule", accomodation2);
		Accomodation accomodation3=new Accomodation("Indore Palace", "12, MIDC, Shirpur-433006", RoomType.TWIN_BED);
		DayPlan dayPlan3=new DayPlan("Indore", 150.0,3,"Continue on Mumbai Agra road to complete our tour\"", accomodation3);
		List<DayPlan> dayPlanList1= List.of(dayPlan1,dayPlan2,dayPlan3);
	Itinerary itinerary= new Itinerary(dayPlanList1);
		GuidedTour guidedTour1=new GuidedTour(1L,"Mumbai-Indore", "Mumbai", "Indore", 6,5,itinerary ,DifficultyLevel.MODERATE, Mode.MOTORBIKE);
		
		MobileNumber mobileNumber1=new MobileNumber("8234609819");
		Name name1=new Name("Saptadeepa","Mitra");
		Traveller traveller1= new Traveller(1,mobileNumber1,name1);
		
		MobileNumber mobileNumber2=new MobileNumber("9830265789");
		Name name2=new Name("Prashanta","Sen");
		Traveller traveller2= new Traveller(2,mobileNumber2,name2);
		
		MobileNumber mobileNumber3=new MobileNumber("7806823561");
		Name name3=new Name("Proyeti","Mitra");
		Traveller traveller3= new Traveller(3,mobileNumber3,name3);
		
		MobileNumber mobileNumber4=new MobileNumber("8759016724");
		Name name4=new Name("Arnab","Patra");
		Traveller traveller4= new Traveller(4,mobileNumber4,name4);
		
		MobileNumber mobileNumber5=new MobileNumber("7640917865");
		Name name5=new Name("Deep","Bhakat");
		Traveller traveller5= new Traveller(5,mobileNumber5,name5);
		
		MobileNumber mobileNumber6=new MobileNumber("6789123560");
		Name name6=new Name("Bibhudyuti","Ray");
		Traveller traveller6= new Traveller(6,mobileNumber6,name6);
		
		MobileNumber mobileNumber7=new MobileNumber("9874350971");
		Name name7=new Name("Shivam","Agarwal");
		Traveller traveller7= new Traveller(7,mobileNumber7,name7);
		
		MobileNumber mobileNumber_guide=new MobileNumber("8760263791");
		Name name_guide=new Name("Prateek","R");
		Traveller guide= new Traveller(0,mobileNumber_guide,name_guide);
		
		List<Traveller> travellerList1=List.of(traveller1,traveller2,traveller3,traveller4,traveller5,traveller6,traveller7);
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		TourBatch tourBatch=new TourBatch(1L,LocalDate.parse("2023-09-25",formatter),LocalDate.parse("2023-09-28",formatter),guidedTour1,20,2000D,5,travellerList1,guide,Status.ACTIVE);
		return tourBatch;
	}
	
	@Test
	public void testAllTourBatches() throws Exception
	{
		TourBatch tourBatch1=makeTour();
		Accomodation accomodation4=new Accomodation("Hotel Mayur","SB road, Thane",RoomType.TWIN_BED);
		DayPlan dayPlan4= new DayPlan("Mumbai",0.0,0,"reporting between 5 pm to 7 pm. Introduction, tour briefing and ice breaker",accomodation4);
		Accomodation accomodation5=new Accomodation("Dwarka Hotel", "Dwarka chauk, Nasik", RoomType.DOUBLE_BED);
		DayPlan dayPlan5=new DayPlan("Nasik",155.0,1,"Ride on good highway on Mumbai Agra road. Stay and rest", accomodation5);
		Accomodation accomodation6=new Accomodation("Dhule Palace", "Near Gurudwara, Dhule-414006", RoomType.TWIN_BED);
		DayPlan dayPlan6=new DayPlan("Dhule", 145.0,2,"Ride on Mumbai Agra road. Visit Gurudwara at Dhule", accomodation6);
		List<DayPlan> dayPlanList2= List.of(dayPlan4,dayPlan5,dayPlan6);
		Itinerary itinerary2= new Itinerary(dayPlanList2);
		GuidedTour guidedTour2=new GuidedTour(1L,"Mumbai-Indore", "Mumbai", "Indore", 6,5, itinerary2,DifficultyLevel.MODERATE, Mode.MOTORBIKE);
		
		
		MobileNumber mobileNumber1=new MobileNumber("8234609819");
		Name name1=new Name("Diya","Banerjee");
		Traveller traveller1= new Traveller(1,mobileNumber1,name1);
		
		MobileNumber mobileNumber2=new MobileNumber("9830265789");
		Name name2=new Name("Swarnali","Saha");
		Traveller traveller2= new Traveller(2,mobileNumber2,name2);
		
		MobileNumber mobileNumber3=new MobileNumber("7806823561");
		Name name3=new Name("Pavan","Chinimili");
		Traveller traveller3= new Traveller(3,mobileNumber3,name3);
		
		MobileNumber mobileNumber4=new MobileNumber("8759016724");
		Name name4=new Name("Saurav","Kundu");
		Traveller traveller4= new Traveller(4,mobileNumber4,name4);
		
		MobileNumber mobileNumber5=new MobileNumber("7640917865");
		Name name5=new Name("Saptarshi","Bose");
		Traveller traveller5= new Traveller(5,mobileNumber5,name5);
		
		MobileNumber mobileNumber6=new MobileNumber("6789123560");
		Name name6=new Name("Sayan","Ghosh");
		Traveller traveller6= new Traveller(6,mobileNumber6,name6);
		
		MobileNumber mobileNumber7=new MobileNumber("9874350971");
		Name name7=new Name("Puru","Soni");
		Traveller traveller7= new Traveller(7,mobileNumber7,name7);
		
		MobileNumber mobileNumber_guide=new MobileNumber("8760263791");
		Name name_guide=new Name("Arpita","Mohahir");
		Traveller guide= new Traveller(0,mobileNumber_guide,name_guide);
		
		List<Traveller> travellerList1=List.of(traveller1,traveller2,traveller3,traveller4,traveller5,traveller6,traveller7);
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		TourBatch tourBatch2=new TourBatch(2L,LocalDate.parse("2023-10-10",formatter),LocalDate.parse("2023-10-13",formatter),guidedTour2,10,2000D,7,travellerList1,guide,Status.ACTIVE);
		
		List<TourBatch> TourBatchList=List.of(tourBatch1,tourBatch2);
		
		//Mimicking the behavior of findAll()
		Mockito.when(tourBatchRepo.findAll()).thenReturn(TourBatchList);
		
		//Testing the result expected and actual result obtained
		assertThat(tourBatchService.getTourBatch("ADMIN")).isEqualTo(TourBatchList);
	}

	@Test
	public void testGetTourBatchById()
	{
		TourBatch tourBatch1=makeTour();
		
		//Mocking the behavior of findById()
		Mockito.when(tourBatchRepo.findById(1L)).thenReturn(Optional.of(tourBatch1));
		
		//Testing the result expected and actual result obtained
		assertThat(tourBatchService.getTourBatchById(tourBatch1.getId())).isEqualTo(tourBatch1);

	}
	
	@Test
	public void testAddTourBatch()
	{
		TourBatch tourBatch1=makeTour();
		guidedTour=tourBatch1.getBaseTour();
		
		Mockito.when(tourService.getTourById(1L)).thenReturn(guidedTour);
		//Mimicking the behavior of findById()
		Mockito.when(tourBatchRepo.save(tourBatch1)).thenReturn(tourBatch1);
//		
//		//Testing the result expected and actual result obtained
		assertThat(tourBatchService.addTourBatch(1L,tourBatch1)).isEqualTo(tourBatch1);
	}
	

}
