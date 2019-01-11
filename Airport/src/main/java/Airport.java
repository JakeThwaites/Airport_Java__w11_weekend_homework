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
        Flight newFlight = new Flight(flightNumber, destination, 2);
        flights.add(newFlight);
    }

    public void addPlaneToFlight(Flight flight, Plane plane){
        flight.addPlane(plane);
    }

    public void sellTicket(Passenger passenger, Flight flight){
        if (flight.getPlane().hasEmptySeats()){
            passenger.buyTicket();
            flight.getPlane().addPassenger(passenger);
        }
    }

    public int totalPassengersOnFlight(Flight flight){
        int totalPassengers = flight.getPlane().getPassengers().size();
        return totalPassengers;
    }
}

