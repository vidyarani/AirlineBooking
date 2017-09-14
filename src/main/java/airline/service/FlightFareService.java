package airline.service;

import airline.model.Flight;
import airline.model.SearchCriteria;
import airline.model.SearchResult;
import airline.model.TravelClassType;
import airline.repository.FlightFareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightFareService {

    private FlightFareRepository flightFareRepository;

    @Autowired
    FlightFareService(FlightFareRepository flightFareRepository) {
        this.flightFareRepository = flightFareRepository;
    }

    public List<SearchResult> getFlightsWithTotalFare(List<Flight> availableFlights, SearchCriteria searchCriteria) {
        List<SearchResult> searchResults = new ArrayList<SearchResult>();
        availableFlights.stream().forEach(flight -> searchResults.add(createSearchResult(searchCriteria, flight)));
        return searchResults;
    }

    private SearchResult createSearchResult(SearchCriteria searchCriteria, Flight flight) {
        return new SearchResult(flight.getFlightNumber(), flight.getModelName(), searchCriteria.getSource(),
                searchCriteria.getDestination(), calculateTotalFare(searchCriteria, flight));
    }

    double calculateTotalFare(SearchCriteria searchCriteria, Flight flight) {
        TravelClassType travelClassType = searchCriteria.getTravelClassType();
        int numberOfPassengers = searchCriteria.getNumberOfPassengers();
        double baseFare = getBaseFare(flight.getFlightNumber(), travelClassType);
        int percentageOfAvailableSeats = flight.getPercentageOfAvailableSeats(travelClassType);
        double fareByTravelClass = 0;

        switch (travelClassType) {
            case ECONOMY:
                fareByTravelClass = getFareBasedOnPercentageOfAvailableSeats(percentageOfAvailableSeats,
                        baseFare);break;
            case BUSINESS:
                fareByTravelClass = checkAndApplyFareBasedOnDayOfDepartureDate(searchCriteria.getDepartureDate(),
                        baseFare);break;
            case FIRST:
                fareByTravelClass = getFirstClassFareBasedOnDepartureDate(searchCriteria.getDepartureDate(),
                        baseFare);break;
            default:
                fareByTravelClass = baseFare;
        }

        return getTotalFare(numberOfPassengers, fareByTravelClass);
    }

    private double getFareBasedOnPercentageOfAvailableSeats(int percentageOfAvailableSeats, double baseFare) {
        if (percentageOfAvailableSeats <= 40)
            return baseFare;
        if (percentageOfAvailableSeats <= 90)
            return baseFare * 1.03;
        return baseFare * 1.06;
    }

    private double checkAndApplyFareBasedOnDayOfDepartureDate(String departureDate, double fare) {
        if (departureDate != null) {
            String dayOfWeek = LocalDate.parse(departureDate).getDayOfWeek().name();
            if (dayOfWeek.equals("MONDAY") || dayOfWeek.equals("FRIDAY") || dayOfWeek.equals("SUNDAY"))
                return fare * 1.04;
        }
        return fare;
    }

    private double getFirstClassFareBasedOnDepartureDate(String departureDate, double baseFare) {
        return baseFare;
    }

    private double getBaseFare(String flightNumber, TravelClassType travelClassType) {
        return flightFareRepository.getBaseFare(flightNumber, travelClassType);
    }

    private double getTotalFare(int numberOfPassengers, double baseFare) {
        return numberOfPassengers * baseFare;
    }
}
