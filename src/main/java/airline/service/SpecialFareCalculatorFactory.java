package airline.service;

import airline.model.Flight;
import airline.model.TravelClassType;

class SpecialFareCalculatorFactory {
    FareCalculator create(TravelClassType travelClassType, Flight flight, double baseFare) {

        if (travelClassType == TravelClassType.ECONOMY)
            return new FareCalculatorByAvailableSeats(flight, baseFare);
        if (travelClassType == TravelClassType.BUSINESS)
            return new FareCalculatorByWeekDay(flight, baseFare);
        if (travelClassType == TravelClassType.FIRST)
            return new FareCalculatorByDepartureDate(flight, baseFare);
        return new DefaultFareCalculator(baseFare);
    }
}
