package airline.service;

public class DefaultFareCalculator implements FareCalculator {
    private final double baseFare;

    DefaultFareCalculator(double baseFare) {
        this.baseFare = baseFare;
    }

    @Override
    public double calculate() {
        return baseFare;
    }
}
