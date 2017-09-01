import airline.model.Flight;
import airline.services.CityRepository;
import airline.services.FlightRepository;
import airline.services.FlightSearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AirlineBookingTest {
    FlightRepository flightRepository;
    FlightSearchService flightSearchService;

    @Before
    public void setUp() {
        flightRepository = new FlightRepository();
        flightSearchService = new FlightSearchService();
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
    public void shouldReturnFlightsFromHydToBlr() {
        List<Flight> searchResults = flightSearchService.search("HYD", "BLR");
        Assert.assertEquals(2, searchResults.size());
    }
}
