package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.service.CityService;
import airline.service.FlightSearchService;
import org.junit.Test;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FlightSearchControllerTest {

    @Test
    public void testGetCities() {
        CityService cityService = mock(CityService.class);
        Model model = mock(Model.class);

        FlightSearchController flightSearchController = new FlightSearchController(cityService);
        ArrayList<City> cities = new ArrayList<>();
        when(cityService.getCities()).thenReturn(cities);
        String flightSearchView = flightSearchController.getCities(model);

        assertEquals("FlightSearch", flightSearchView);

        verify(model).addAttribute("cities", cities);
        verify(cityService).getCities();

        SearchCriteria searchCriteria = new SearchCriteria();
    }

    @Test
    public void testSearchFlights() {

        FlightSearchService flightSearchService = mock(FlightSearchService.class);
        Model model = mock(Model.class);
        SearchCriteria searchCriteria = new SearchCriteria();
        List<Flight> availableFlights = new ArrayList<Flight>();

        FlightSearchController flightSearchController = new FlightSearchController(flightSearchService);
        when(flightSearchService.search(searchCriteria)).thenReturn(availableFlights);

        String flightsView = flightSearchController.searchFlights(searchCriteria, model);

        assertEquals("FlightsView", flightsView);
        verify(model).addAttribute("searchResults", availableFlights);
        verify(flightSearchService).search(searchCriteria);
    }
}