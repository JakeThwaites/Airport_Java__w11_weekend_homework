import java.util.ArrayList;

public class Airport {
    private ArrayList<Plane> hangar;
    private AirportCodeType airportCode;
    private ArrayList<Flight> flights;

    public Airport(AirportCodeType airportCode){
        this.airportCode = airportCode;
        this.hangar = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public AirportCodeType getAirportCode(){
        return airportCode;
    }

    public ArrayList<Plane> getHangar(){
        return hangar;
    }

    public void addPlaneToHangar(Plane plane){
        hangar.add(plane);
    }

    public ArrayList<Flight> getFlights(){
        return flights;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void createFlight(Integer flightNumber, DestinationType destination){
        Flight newFlight = new Flight(flightNumber, destination);
        flights.add(newFlight);
    }
}

