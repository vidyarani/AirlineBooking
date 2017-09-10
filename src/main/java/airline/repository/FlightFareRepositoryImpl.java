package airline.repository;

import airline.model.FlightFare;
import airline.model.TravelClassType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightFareRepositoryImpl implements FlightFareRepository {

    private List<FlightFare> flightFares;

    FlightFareRepositoryImpl() {
        flightFares = new ArrayList<FlightFare>();
        flightFares.add(new FlightFare("F1", TravelClassType.BUSINESS, 2000));
        flightFares.add(new FlightFare("F1", TravelClassType.FIRST, 3000));
        flightFares.add(new FlightFare("F1", TravelClassType.ECONOMY, 1000));
        flightFares.add(new FlightFare("F2", TravelClassType.ECONOMY, 1000));
        flightFares.add(new FlightFare("F2", TravelClassType.FIRST, 3000));
        flightFares.add(new FlightFare("F2", TravelClassType.ECONOMY, 1000));
        flightFares.add(new FlightFare("F3", TravelClassType.ECONOMY, 1000));
        flightFares.add(new FlightFare("F3", TravelClassType.FIRST, 3000));
        flightFares.add(new FlightFare("F3", TravelClassType.ECONOMY, 1000));
        flightFares.add(new FlightFare("F4", TravelClassType.ECONOMY, 1000));
        flightFares.add(new FlightFare("F4", TravelClassType.FIRST, 3000));
        flightFares.add(new FlightFare("F4", TravelClassType.ECONOMY, 1000));

    }

    @Override
    public double getBaseFare(String flightNumber, TravelClassType travelClassType) {
        for (FlightFare flightFare : flightFares) {
            boolean sameFlight = flightNumber.equals(flightFare.getFlightNumber());
            boolean sameTravelClassType = travelClassType.equals(flightFare.getTravelClassType());
            if (sameFlight && sameTravelClassType)
                return flightFare.getBaseFare();
        }
        return 0;
    }
}
