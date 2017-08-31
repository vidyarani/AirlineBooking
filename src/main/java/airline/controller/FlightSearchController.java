package airline.controller;

import airline.model.City;
import airline.model.Flight;
import airline.services.CityRepository;
import airline.services.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by rajashrk on 8/8/17.
 */

@Controller
public class FlightSearchController {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    FlightSearchService flightSearchService;

    @RequestMapping(value = "/airlineTicketing", method = RequestMethod.GET)
    public String getCities(Model model) {
        cityRepository = new CityRepository();
        List<City> cities = cityRepository.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("flight", new Flight("F1","HYD","BLR"));
        return "FlightSearch";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getFlights(@ModelAttribute(value = "flight") Flight flight, Model model) {
        flightSearchService = new FlightSearchService();
        List<Flight> availableFlights = flightSearchService.search(flight.getSource(), flight.getDestination());
        System.out.println("results size: "+availableFlights.size());
        model.addAttribute("searchResults",availableFlights);
        return "FlightsView";
    }
}
