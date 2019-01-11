import java.util.ArrayList;

public class Plane {
    private AirlineType airline;
    private PlaneType type;
    private ArrayList<Passenger> passengers;
    private Integer maxPassengers;
    private Boolean inHangar;

    public Plane(PlaneType type, AirlineType airline, Integer maxPassengers){
        this.airline = airline;
        this.type = type;
        this.passengers = new ArrayList<>();
        this.maxPassengers = maxPassengers;
        this.inHangar = false;
    }

    public AirlineType getAirline(){
        return airline;
    }

    public PlaneType getType(){
        return type;
    }

    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

    public int getMaxPassengers(){
        return maxPassengers;
    }

    public boolean inHangar(){
        return inHangar;
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    public boolean hasEmptySeats(){
        return maxPassengers > passengers.size();
    }

    public int differenceFromRequiredPassengers(Flight flight) {
        if (maxPassengers > flight.getRequiredPassengers()) {
            return maxPassengers - flight.getRequiredPassengers();
        }
        else {
            return flight.getRequiredPassengers() - maxPassengers;
        }
    }

    public void enterHangar(){
        inHangar = true;
    }

    public void leaveHangar(){
        inHangar = false;
    }
}
