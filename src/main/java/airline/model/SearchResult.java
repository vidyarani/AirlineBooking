package airline.model;

public class SearchResult {

    private final String flightNumber;
    private String modelName;
    private String source;
    private String destination;
    private double totalFare;

    public SearchResult(String flightNumber, String modelName, String source, String destination, double totalFare) {
        this.flightNumber = flightNumber;
        this.modelName = modelName;
        this.source = source;
        this.destination = destination;
        this.totalFare = totalFare;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getTotalFare() {
        return totalFare;
    }

    @Override
    public boolean equals(Object object) {
        SearchResult searchResult = (SearchResult) object;
        return (this.modelName.equals(searchResult.modelName) && this.source.equals(searchResult.source) &&
                this.destination.equals(searchResult.destination) && this.totalFare == searchResult.totalFare);
    }
}
