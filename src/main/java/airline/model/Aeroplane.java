package airline.model;

import java.util.List;

public class Aeroplane {
    private String modelName;
    private List<TravelClass> travelClassList;

    public Aeroplane(String modelName, List<TravelClass> travelClassList1) {
        this.modelName = modelName;
        this.travelClassList = travelClassList1;
    }

    private TravelClass getTravelClass(TravelClassType travelClassType) {
        return travelClassList.stream()
                .filter(travelClass -> travelClass.getTravelClassType().equals(travelClassType))
                .findAny()
                .orElse(null);
    }

    String getAirPlaneName() {
        return modelName;
    }

    int getSeatsByClassType(TravelClassType travelClassType) {
        TravelClass travelClass = getTravelClass(travelClassType);
        if (travelClass == null)
            return 0;
        return travelClass.getAvailableSeats();
    }
}