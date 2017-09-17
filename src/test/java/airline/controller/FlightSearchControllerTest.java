package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.SearchResult;
import airline.service.CityService;
import airline.service.FlightFareService;
import airline.service.FlightSearchService;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FlightSearchControllerTest {
    CityService cityService;
    FlightSearchService flightSearchService;
    FlightFareService flightFareService;
    FlightSearchController flightSearchController;

    @Test
    public void testGetCities() {
        cityService = mock(CityService.class);
        Model model = mock(Model.class);

        flightSearchController = new FlightSearchController(flightSearchService, cityService, flightFareService);
        ArrayList<City> cities = new ArrayList<>();
        when(cityService.getCities()).thenReturn(cities);
        String flightSearchView = flightSearchController.getCities(model);

        assertEquals("FlightSearch", flightSearchView);

        verify(model).addAttribute("cities", cities);
        verify(cityService).getCities();
    }

    @Test
    public void testSearchFlights() {
        flightSearchService = mock(FlightSearchService.class);
        flightFareService = mock(FlightFareService.class);
        Model model = mock(Model.class);
        SearchCriteria searchCriteria = new SearchCriteria();
        List<Flight> availableFlights = new ArrayList<Flight>();
        List<SearchResult> searchResults = new ArrayList<SearchResult>();
        flightSearchController = new FlightSearchController(flightSearchService, cityService, flightFareService);
        when(flightSearchService.search(searchCriteria)).thenReturn(availableFlights);

        when(flightFareService.getFlightsWithTotalFare(new ArrayList<Flight>(), searchCriteria)).
                thenReturn(searchResults);

        String flightsView = flightSearchController.searchFlights(searchCriteria, model);
        assertEquals("FlightsView", flightsView);

        verify(model).addAttribute("searchResults", availableFlights);
        verify(flightSearchService).search(searchCriteria);
        verify(flightFareService).getFlightsWithTotalFare(new ArrayList<Flight>(), searchCriteria);
    }
}
