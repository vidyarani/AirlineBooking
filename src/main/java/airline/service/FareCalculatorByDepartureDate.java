package airline.service;

import airline.model.Flight;

import java.time.LocalDate;

public class FareCalculatorByDepartureDate implements FareCalculator {

    private Flight flight;
    private double baseFare;
    FareCalculatorByDepartureDate(Flight flight, double baseFare) {
        this.flight = flight;
        this.baseFare = baseFare;
    }

    @Override
    public double calculate() {
        int daysToGo = flight.getDepartureDate().compareTo(LocalDate.now());
        return baseFare + baseFare * daysToGo * PERCENT10;
    }
}
