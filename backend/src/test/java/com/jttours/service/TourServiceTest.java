package com.jttours.service;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.jttours.repo.TourRepository;

@ExtendWith(MockitoExtension.class)
public class TourServiceTest {

		@Mock
		private TourRepository tourRepository;
		
		@InjectMocks
		private TourServiceImp tourService;
		
		@BeforeEach
		public void setup() {
			MockitoAnnotations.openMocks(this);
		}
		
		public GuidedTour makeTour() {
			Accomodation accomodation1=new Accomodation("Dhule Palace","Near Gurudwara, Dhule-414006",RoomType.TWIN_BED);
			DayPlan dayPlan1= new DayPlan("Dhule",145.0,1,"Ride on Mumbai Agra road. Visit Gurudwara at Dhule",accomodation1);
			Accomodation accomodation2=new Accomodation("Shirpur Guest house", "12, MIDC, Shirpur-433006", RoomType.TWIN_BED);
			DayPlan dayPlan2=new DayPlan("Shirpur", 50.0,2,"Ride on Mumbai Agra road. Visit Gurudwara at Dhule", accomodation2);
			Accomodation accomodation3=new Accomodation("Indore Palace", "12, MIDC, Shirpur-433006", RoomType.TWIN_BED);
			DayPlan dayPlan3=new DayPlan("Indore", 150.0,3,"Continue on Mumbai Agra road to complete our tour\"", accomodation3);
			List<DayPlan> dayPlanList1= List.of(dayPlan1,dayPlan2,dayPlan3);
		Itinerary itinerary= new Itinerary(dayPlanList1);
			GuidedTour guidedTour1=new GuidedTour(1L,"Mumbai-Indore", "Mumbai", "Indore", 6,5,itinerary ,DifficultyLevel.MODERATE, Mode.MOTORBIKE);
			return guidedTour1;		}
		
		@Test
		public void testAllTours() throws Exception{
//			GuidedTour1
			GuidedTour guidedTour1=makeTour();
			Accomodation accomodation4=new Accomodation("Hotel Mayur","SB road, Thane",RoomType.TWIN_BED);
			DayPlan dayPlan4= new DayPlan("Mumbai",0.0,0,"reporting between 5 pm to 7 pm. Introduction, tour briefing and ice breaker",accomodation4);
			Accomodation accomodation5=new Accomodation("Dwarka Hotel", "Dwarka chauk, Nasik", RoomType.DOUBLE_BED);
			DayPlan dayPlan5=new DayPlan("Nasik",155.0,1,"Ride on good highway on Mumbai Agra road. Stay and rest", accomodation5);
			Accomodation accomodation6=new Accomodation("Dhule Palace", "Near Gurudwara, Dhule-414006", RoomType.TWIN_BED);
			DayPlan dayPlan6=new DayPlan("Dhule", 145.0,2,"Ride on Mumbai Agra road. Visit Gurudwara at Dhule", accomodation6);
			List<DayPlan> dayPlanList2= List.of(dayPlan4,dayPlan5,dayPlan6);
			Itinerary itinerary2= new Itinerary(dayPlanList2);
			GuidedTour guidedTour2=new GuidedTour(1L,"Mumbai-Indore", "Mumbai", "Indore", 6,5, itinerary2,DifficultyLevel.MODERATE, Mode.MOTORBIKE);
				
//			Making list of guided tour
			List<GuidedTour> guidedTourList=List.of(guidedTour1,guidedTour2);
			
//			Mimicking the behaviour of findAll()
			Mockito.when(tourRepository.findAll()).thenReturn(guidedTourList);
//			
//			Testing the result expected and actual result obtained
			assertThat(tourService.getAllTours()).isEqualTo(guidedTourList);
			//verify(tourRepository);
		}
		
		@Test
		public void testGetTourById() {
			GuidedTour guidedTour1=makeTour();
			
//			Mimicking the behaviour of findById()
			Mockito.when(tourRepository.findById(1L)).thenReturn(Optional.of(guidedTour1));
			
//			Testing the result expected and actual result obtained
			assertThat(tourService.getTourById(guidedTour1.getId())).isEqualTo(guidedTour1);
		}
		
			@Test
			public void testAddTour() {
				GuidedTour guidedTour1=makeTour();
				
//				Mimicking the behaviour of findById()
				Mockito.when(tourRepository.save(guidedTour1)).thenReturn(guidedTour1);
//				
//				Testing the result expected and actual result obtained
				assertThat(tourService.addTour(guidedTour1)).isEqualTo(guidedTour1);
			}
			
			@Test
			public void testUpdateTour1() {
				GuidedTour guidedTour1=makeTour();
				// GuidedTour guidedTour2=new GuidedTour();
				
//				Mimicking the behaviour of findById()
				Mockito.when(tourRepository.findById(1L)).thenReturn(Optional.of(guidedTour1));
				guidedTour1.setName("Manali-Sissu");
				guidedTour1.setStartAt("Manali");
				guidedTour1.setEndAt("Sissu");
				guidedTour1.setItinerary(guidedTour1.getItinerary());
				guidedTour1.setMode(Mode.WALK);
				guidedTour1.setDifficultyLevel(DifficultyLevel.HIGH);
				guidedTour1.setDays(3);
				Mockito.when(tourRepository.save(guidedTour1)).thenReturn(guidedTour1);
				//Testing the result expected and actual result obtained
				assertThat(tourService.updateTour(guidedTour1)).isEqualTo(guidedTour1);	
			}
			
			@Test
			public void testDeleteById1() {
				GuidedTour guidedTour1=makeTour();
				Mockito.when(tourRepository.findById(1L)).thenReturn(Optional.of(guidedTour1));
				assertThat(tourRepository.findById(1L));
			}

	
}
