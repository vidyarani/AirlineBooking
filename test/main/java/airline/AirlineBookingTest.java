package airline;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.repositories.CityRepository;
import airline.repositories.FlightRepository;
import airline.services.FlightSearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class AirlineBookingTest {
    FlightRepository flightRepository;
    FlightSearchService flightSearchService;
    SearchCriteria searchCriteria;

    @Before
    public void setUp() {
        flightRepository = new FlightRepository();
        flightSearchService = new FlightSearchService();
        searchCriteria = new SearchCriteria();
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
        searchCriteria.setSource("HYD");
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        Assert.assertEquals(3, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsWithDestinationAsBlr() {
        searchCriteria.setDestination("BLR");
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        Assert.assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsThatAccommodateGivenPassengers() {
        searchCriteria.setNumberOfPassengers(2);
        List<Flight> searchResults = (flightSearchService.search(searchCriteria));
        Assert.assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsBySourceAndDestinationIFDepartureDateNotGiven() {
        searchCriteria.setSource("HYD");
        searchCriteria.setDestination("BLR");
        List<Flight> searchResults = flightSearchService.search(searchCriteria);
        Assert.assertEquals(2, searchResults.size());
    }

    @Test
    public void shouldRetrieveFlightsFromHydToBlrGivenDate(){
        searchCriteria.setSource("HYD");
        searchCriteria.setDestination("BLR");
        searchCriteria.setDepartureDate(LocalDate.now().toString());
        List<Flight> searchResults = flightSearchService.search(searchCriteria);
        Assert.assertEquals(1, searchResults.size());
    }
}