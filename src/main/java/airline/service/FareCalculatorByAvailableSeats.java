package airline.service;

import airline.model.Flight;
import airline.model.TravelClassType;

public class FareCalculatorByAvailableSeats implements FareCalculator {

    private Flight flight;
    private double baseFare;
    FareCalculatorByAvailableSeats(Flight flight, double baseFare) {
        this.flight = flight;
        this.baseFare = baseFare;
    }

    @Override
    public double calculate() {
        double percentageOfAvailableSeats = flight.getPercentageOfAvailableSeats(TravelClassType.ECONOMY);
        if (percentageOfAvailableSeats <= PERCENT40)
            return baseFare;

        if (percentageOfAvailableSeats <= PERCENT90)
            return baseFare + baseFare * PERCENT30;
        return baseFare + baseFare * PERCENT60;
    }
}
