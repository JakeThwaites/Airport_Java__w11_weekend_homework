import java.util.ArrayList;

public class Flight {
    private Integer flightNumber;
    private DestinationType destination;
    private Plane plane;

    public Flight(Integer flightNumber, DestinationType destination){
        this.plane = null;
        this.flightNumber = flightNumber;
        this.destination = destination;
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

    public void addPlane(Plane plane){
        this.plane = plane;
    }

}
