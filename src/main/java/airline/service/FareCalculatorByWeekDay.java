package airline.service;

import airline.model.Flight;

public class FareCalculatorByWeekDay implements FareCalculator {
    private Flight flight;
    private double baseFare;

    FareCalculatorByWeekDay(Flight flight, double baseFare) {
        this.flight = flight;
        this.baseFare = baseFare;
    }

    @Override
    public double calculate() {
        return flight.departsOnSpecialDays() ? baseFare + baseFare * PERCENT40 : baseFare;
    }
}
