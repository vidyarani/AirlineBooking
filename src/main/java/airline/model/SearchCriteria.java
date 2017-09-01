package airline.model;

public class SearchCriteria {
    private String source;
    private String destination;
    private int numberOfPassengers;

    public SearchCriteria() {
    }

    public SearchCriteria(String source, String destination, int numberOfPassengers) {
        this.source = source;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
