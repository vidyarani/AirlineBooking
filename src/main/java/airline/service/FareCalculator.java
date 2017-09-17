package airline.service;

public interface FareCalculator {
    double PERCENT10 = 0.1;
    double PERCENT40 = 0.4;
    double PERCENT90 = 0.9;
    double PERCENT30 = 0.3;
    double PERCENT60 = 0.6;

    double calculate();
}

