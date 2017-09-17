package airline.service;

import airline.model.Flight;

import java.time.DayOfWeek;
import java.util.Arrays;

public class FareCalculatorByWeekDay implements FareCalculator {
    private final DayOfWeek[] SPECIAL_DAYS = new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.FRIDAY, DayOfWeek.SUNDAY};
    private Flight flight;
    private double baseFare;

    FareCalculatorByWeekDay(Flight flight, double baseFare) {
        this.flight = flight;
        this.baseFare = baseFare;
    }

    @Override
    public double calculate() {
        if (Arrays.asList(SPECIAL_DAYS).contains(flight.getDepartureDate().getDayOfWeek()))
            return baseFare + baseFare * PERCENT40;
        return baseFare;
    }
}
