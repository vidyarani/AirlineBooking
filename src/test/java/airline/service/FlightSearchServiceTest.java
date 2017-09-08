package airline.service;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.TravelClassType;
import airline.repository.CityRepository;
import airline.repository.FlightRepository;
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
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightSearchService.class)
public class FlightSearchServiceTest {
    @Autowired
    private
    FlightSearchService flightSearchService;
    @MockBean
    private
    FlightRepository flightRepository;
    private SearchCriteria searchCriteria;
    private List<Flight> mockRepository;

    @Before
    public void setUp() {
        searchCriteria = new SearchCriteria();
        searchCriteria.setNumberOfPassengers(1);
        mockRepository = MockFlightRepository.getFlights();
        Mockito.when(flightRepository.getFlights()).thenReturn((ArrayList<Flight>) mockRepository);
    }

    @Test
    public void shouldRetrieveAllCitiesFromRepository() {
        CityRepository cityRepository = new CityRepository();
        assertEquals(3, cityRepository.getCities().size());
    }

    @Test
    public void shouldRetrieveAllFlights() {
        assertEquals(4, mockRepository.size());
    }

    @Test
    public void shouldRetrieveFlightsStartingFromHyd() {
        searchCriteria.setSource("HYD");
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        assertEquals(3, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsWithDestinationAsBlr() {
        searchCriteria.setDestination("BLR");
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsThatAccommodatePassengersForBusinessClass() {
        searchCriteria.setNumberOfPassengers(2);
        searchCriteria.setTravelClassType(TravelClassType.BUSINESS);
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        assertEquals(3, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsThatAccommodatePassengersForFirstClass() {
        searchCriteria.setNumberOfPassengers(2);
        searchCriteria.setTravelClassType(TravelClassType.FIRST);
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsThatAccommodatePassengersForEconomyClass() {
        searchCriteria.setNumberOfPassengers(160);
        searchCriteria.setTravelClassType(TravelClassType.ECONOMY);
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsBySourceAndDestinationIFDepartureDateNotGiven() {
        searchCriteria.setSource("HYD");
        searchCriteria.setDestination("BLR");
        List<Flight> searchResults = flightSearchService.search(searchCriteria);
        assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsFromHydToBlrGivenDate() {
        searchCriteria.setSource("HYD");
        searchCriteria.setDestination("BLR");
        searchCriteria.setDepartureDate(LocalDate.now().toString());
        List<Flight> searchResults = flightSearchService.search(searchCriteria);
        assertEquals(1, searchResults.size());
    }
}