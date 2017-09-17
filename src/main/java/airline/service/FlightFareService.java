package airline.service;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.SearchResult;
import airline.model.TravelClassType;
import airline.repository.FlightFareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightFareService {

    private final SpecialFareCalculatorFactory specialFareCalculatorFactory;
    private final FlightFareRepository flightFareRepository;

    @Autowired
    FlightFareService(FlightFareRepository flightFareRepository) {
        this.flightFareRepository = flightFareRepository;
        this.specialFareCalculatorFactory = new SpecialFareCalculatorFactory();
    }

    public List<SearchResult> getFlightsWithTotalFare(List<Flight> availableFlights, SearchCriteria searchCriteria) {
        List<SearchResult> searchResults = new ArrayList<SearchResult>();
        availableFlights.forEach(flight -> searchResults.add(createSearchResult(searchCriteria, flight)));
        return searchResults;
    }

    double calculateTotalFare(SearchCriteria searchCriteria, Flight flight) {
        TravelClassType travelClassType = searchCriteria.getTravelClassType();
        int numberOfPassengers = searchCriteria.getNumberOfPassengers();
        double baseFare = getBaseFare(flight.getFlightNumber(), travelClassType);

        FareCalculator fareCalculator = specialFareCalculatorFactory.create(travelClassType, flight, baseFare);
        double fareByTravelClass = fareCalculator.calculate();

        return getTotalFare(numberOfPassengers, fareByTravelClass);
    }

    private double getBaseFare(String flightNumber, TravelClassType travelClassType) {
        return flightFareRepository.getBaseFare(flightNumber, travelClassType);
    }

    private double getTotalFare(int numberOfPassengers, double baseFare) {
        return numberOfPassengers * baseFare;
    }

    private SearchResult createSearchResult(SearchCriteria searchCriteria, Flight flight) {
        return new SearchResult(flight.getFlightNumber(), flight.getModelName(), searchCriteria.getSource(),
                searchCriteria.getDestination(), calculateTotalFare(searchCriteria, flight));
    }
}
