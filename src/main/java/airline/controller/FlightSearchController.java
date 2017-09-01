package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.repositories.CityRepository;
import airline.services.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class FlightSearchController {
    CityRepository cityRepository;
    @Autowired
    FlightSearchService flightSearchService;

    @RequestMapping(value = "/airlineTicketing", method = RequestMethod.GET)
    public String getCities(Model model) {
        cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new SearchCriteria("HYD", "BLR",1));
        return "FlightSearch";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getFlights(@ModelAttribute(value = "searchCriteria")SearchCriteria searchCriteria, Model model) {
        List<Flight> availableFlights = flightSearchService.search(searchCriteria);
        model.addAttribute("searchResults", availableFlights);
        return "FlightsView";
    }
}
