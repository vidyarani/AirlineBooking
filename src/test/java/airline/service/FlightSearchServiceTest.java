package airline.service;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.TravelClassType;
import airline.repository.CityRepository;
import airline.repository.FlightSearchRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightSearchService.class)
public class FlightSearchServiceTest {
    private MockFlightRepository mockRepository;
    @Autowired
    private FlightSearchService flightSearchService;
    @MockBean
    private FlightSearchRepositoryImpl flightSearchRepositoryImpl;
    private SearchCriteria searchCriteria;
    private List<Flight> mockFlights;

    @Before
    public void setUp() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setNumberOfPassengers(1);
        mockRepository = new MockFlightRepository();
        mockFlights = mockRepository.getFlights();
        Mockito.when(flightSearchRepositoryImpl.getFlights()).thenReturn((ArrayList<Flight>) mockFlights);
    }

    @Test
    public void shouldRetrieveAllCitiesFromRepository() {
        CityRepository cityRepository = new CityRepository();
        assertEquals(3, cityRepository.getCities().size());
    }

    @Test
    public void shouldRetrieveAllFlights() {
        assertEquals(4, flightSearchService.search(searchCriteria).size());
    }

    @Test
    public void shouldRetrieveFlightsStartingFromHyd() {
        searchCriteria.setSource("HYD");
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        List<Flight> expectedResults = Arrays.asList(mockRepository.getFlightFromHydToBlr(),
                mockRepository.getFlightFromHydToPune(), mockRepository.getFlightFromHydToChennai());
        assertArrayEquals(expectedResults.toArray(), searchResults.toArray());
    }

    @Test
    public void shouldRetrieveFlightsWithDestinationAsBlr() {
        searchCriteria.setDestination("BLR");
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        Flight[] expectedResults = new Flight[]{mockRepository.getFlightFromHydToBlr()};
        assertArrayEquals(expectedResults, searchResults.toArray());
    }

    @Test
    public void shouldRetrieveFlightsThatCanAccommodatePassengersForBusinessClass() {
        searchCriteria.setNumberOfPassengers(2);
        searchCriteria.setTravelClassType(TravelClassType.BUSINESS);
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        Flight[] expectedResults = new Flight[]{mockRepository.getFlightFromHydToBlr(),
                mockRepository.getFlightFromBlrToPune(), mockRepository.getFlightFromHydToChennai()};
        assertArrayEquals(expectedResults, searchResults.toArray());
    }

    @Test
    public void shouldRetrieveFlightsThatCanAccommodatePassengersForFirstClass() {
        searchCriteria.setNumberOfPassengers(2);
        searchCriteria.setTravelClassType(TravelClassType.FIRST);
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        Flight[] expectedResults = new Flight[]{mockRepository.getFlightFromHydToBlr(),
                mockRepository.getFlightFromHydToChennai()};
        assertArrayEquals(expectedResults, searchResults.toArray());
    }

    @Test
    public void shouldRetrieveFlightsThatCanAccommodatePassengersForEconomyClass() {
        searchCriteria.setNumberOfPassengers(160);
        searchCriteria.setTravelClassType(TravelClassType.ECONOMY);
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        assertEquals(0, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsBySourceAndDestinationIFDepartureDateNotGiven() {
        searchCriteria.setSource("HYD");
        searchCriteria.setDestination("BLR");
        List<Flight> searchResults = flightSearchService.search(searchCriteria);
        Flight[] expectedResults = new Flight[]{mockRepository.getFlightFromHydToBlr()};
        assertArrayEquals(expectedResults, searchResults.toArray());
    }

    @Test
    public void shouldRetrieveFlightsFromHydToBlrGivenDate() {
        searchCriteria.setSource("HYD");
        searchCriteria.setDestination("BLR");
        searchCriteria.setDepartureDate(LocalDate.now().toString());
        List<Flight> searchResults = flightSearchService.search(searchCriteria);
        Flight[] expectedResults = new Flight[]{mockRepository.getFlightFromHydToBlr()};
        assertArrayEquals(expectedResults, searchResults.toArray());
    }

    @Test
    public void shouldRetrieveFlightsFromHydToChennaiIfDateIsLessThan10DaysFromDepartureDate(){
        searchCriteria.setSource("HYD");
        searchCriteria.setDestination("CHN");
        searchCriteria.setDepartureDate(LocalDate.now().plusDays(2).toString());
        List<Flight> searchResults = flightSearchService.search(searchCriteria);
        Flight[] expectedResults = new Flight[]{mockRepository.getFlightFromHydToChennai()};
        assertArrayEquals(expectedResults, searchResults.toArray());
    }

}