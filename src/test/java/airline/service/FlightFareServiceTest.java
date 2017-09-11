package airline.service;

import airline.model.*;
import airline.repository.FlightFareRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value = FlightFareService.class)
public class FlightFareServiceTest {
    private FlightFareService flightFareService;
    private SearchCriteria searchCriteria;
    private Flight mockFlight;
    private FlightFareRepository flightFareRepository;

    @Before
    public void setUp() {
        flightFareRepository = mock(FlightFareRepository.class);
        flightFareService = new FlightFareService(flightFareRepository);
        searchCriteria = new SearchCriteria();
        List<TravelClass> travelClassList = Arrays.asList(
                new TravelClass(TravelClassType.FIRST, 8),
                new TravelClass(TravelClassType.BUSINESS, 35),
                new TravelClass(TravelClassType.ECONOMY, 195));
        Aeroplane aeroplane = new Aeroplane("Boeing  777-200LR", travelClassList);

        Map<TravelClassType, Integer> availableSeats1 = new HashMap<>();
        availableSeats1.put(TravelClassType.FIRST, 4);
        availableSeats1.put(TravelClassType.BUSINESS, 30);
        availableSeats1.put(TravelClassType.ECONOMY, 100);

        mockFlight = new Flight("F1", "HYD", "BLR", LocalDate.of(2017, 9, 06), aeroplane, availableSeats1);
    }

    @Test
    public void shouldReturnTotalFareForBusinessClass() {
        searchCriteria.setNumberOfPassengers(2);
        searchCriteria.setTravelClassType(TravelClassType.BUSINESS);
        when(flightFareRepository.getBaseFare("F1", TravelClassType.BUSINESS)).thenReturn((double) 13000);
        double totoalFare = flightFareService.calculateTotalFare(searchCriteria, mockFlight);
        assertEquals(26000, totoalFare, 0);
    }

    @Test
    public void shouldReturnSearchResultsWithTotalFare() {
        searchCriteria.setNumberOfPassengers(2);
        searchCriteria.setTravelClassType(TravelClassType.BUSINESS);
        when(flightFareRepository.getBaseFare("F1", TravelClassType.BUSINESS)).thenReturn((double) 13000);
        List<SearchResult> searchResults = flightFareService.getFlightsWithTotalFare(Collections.singletonList(mockFlight), searchCriteria);
        SearchResult searchResult = new SearchResult("F1", "Boeing  777-200LR","HYD","BLR", 26000);
        SearchResult[] expectedResults = new SearchResult[]{searchResult};
        assertArrayEquals(expectedResults, searchResults.toArray());
    }

}