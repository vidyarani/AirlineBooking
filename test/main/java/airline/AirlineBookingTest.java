package airline;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.repositories.CityRepository;
import airline.repositories.FlightRepository;
import airline.services.FlightSearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AirlineBookingTest {
    FlightRepository flightRepository;
    FlightSearchService flightSearchService;
    SearchCriteria searchCriteria;

    @Before
    public void setUp() {
        flightRepository = new FlightRepository();
        flightSearchService = new FlightSearchService();
        searchCriteria = new SearchCriteria("HYD", "BLR", 2);
    }

    @Test
    public void shouldRetrieveAllCitiesFromRepository() {
        CityRepository cityRepository = new CityRepository();
        Assert.assertEquals(3, cityRepository.getCities().size());
    }

    @Test
    public void shouldRetrieveAllFlights() {
        Assert.assertEquals(4, flightRepository.getFlights().size());
    }

    @Test
    public void shouldRetrieveFlightsStartingFromHyd() {
        List<Flight> searchResults = convertPredicateToList(flightSearchService.searchBySource(searchCriteria));
        Assert.assertEquals(3, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsWithDestinationAsBlr() {
        List<Flight> searchResults = convertPredicateToList(flightSearchService.searchByDestination(searchCriteria));
        Assert.assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsThatAccommodateGivenPassengers() {
        List<Flight> searchResults = convertPredicateToList(flightSearchService.searchByPassengers(searchCriteria));
        Assert.assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldReturnFlightsFromHydToBlr() {
        List<Flight> searchResults = flightSearchService.search(searchCriteria);
        Assert.assertEquals(1, searchResults.size());
    }

    private List<Flight> convertPredicateToList(Predicate<Flight> predicate) {
        return flightRepository.getFlights().stream().filter(predicate).collect(Collectors.toList());
    }
}
