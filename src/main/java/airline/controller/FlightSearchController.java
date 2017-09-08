package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.TravelClassType;
import airline.service.CityService;
import airline.service.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FlightSearchController {
    @Autowired
    private
    FlightSearchService flightSearchService;

    @Autowired
    private
    CityService cityService;

    @Autowired
    FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @Autowired
    FlightSearchController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/airlineTicketing", method = RequestMethod.GET)
    String getCities(Model model) {
        List<City> cities = cityService.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("searchCriteria", new SearchCriteria());
        model.addAttribute("travelClassTypes", TravelClassType.values());
        model.addAttribute("today", LocalDate.now().toString());
        return "FlightSearch";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    String searchFlights(@ModelAttribute(value = "searchCriteria") SearchCriteria searchCriteria, Model model) {
        List<Flight> availableFlights = flightSearchService.search(searchCriteria);
        model.addAttribute("searchResults", availableFlights);
        return "FlightsView";
    }
}