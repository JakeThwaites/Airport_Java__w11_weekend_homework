import java.util.ArrayList;

public class Plane {
    private AirlineType airline;
    private PlaneType type;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType type, AirlineType airline){
        this.airline = airline;
        this.type = type;
        this.passengers = new ArrayList<>();
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

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }
}
