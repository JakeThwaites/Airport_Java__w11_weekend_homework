import java.util.ArrayList;

public class Flight {
    private Integer flightNumber;
    private DestinationType destination;
    private Plane plane;
    private Integer requiredPassengers;

    public Flight(DestinationType destination, Integer requiredPassengers){
        this.plane = null;
        this.flightNumber = 0;
        this.destination = destination;
        this.requiredPassengers = requiredPassengers;
    }

    public Plane getPlane(){
        return plane;
    }

    public int getFlightNumber(){
        return flightNumber;
    }

    public DestinationType getDestination(){
        return destination;
    }

    public int getRequiredPassengers(){
        return requiredPassengers;
    }

    public void addPlane(Plane plane){
        this.plane = plane;
    }

    public void setFlightNumber(int newFlightNumber){
        flightNumber = newFlightNumber;
    }

}
