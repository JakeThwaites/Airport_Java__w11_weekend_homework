import java.util.ArrayList;
import java.util.Collections;

public class Airport {
    private ArrayList<Plane> hangar;
    private AirportCodeType airportCode;
    private ArrayList<Flight> flights;
    private ArrayList<Passenger> passengers;
    private Integer latestFlightNumber;

    public Airport(AirportCodeType airportCode){
        this.airportCode = airportCode;
        this.hangar = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.latestFlightNumber = 0;
    }

    public AirportCodeType getAirportCode(){
        return airportCode;
    }

    public ArrayList<Plane> getHangar(){
        return hangar;
    }

    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    public void addPlaneToHangar(Plane plane){
        hangar.add(plane);
        plane.enterHangar();
    }

    public ArrayList<Flight> getFlights(){
        return flights;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void createFlight(DestinationType destination, Integer requiredPassengers){
        Flight newFlight = new Flight(destination, requiredPassengers);
        flights.add(newFlight);
        latestFlightNumber += 1;
        newFlight.setFlightNumber(latestFlightNumber);
    }

    public void addPlaneToFlight(Flight flight, Plane plane){
        if (plane.inHangar()){
            flight.addPlane(plane);
            hangar.remove(plane);
            plane.leaveHangar();
        }
    }

    public void sellTicket(Passenger passenger, Flight flight){
        if (flight.getPlane().hasEmptySeats() && passengers.contains(passenger)){
            passenger.buyTicket();
            flight.getPlane().addPassenger(passenger);
        }
    }

    public int totalPassengersOnFlight(Flight flight){
        int totalPassengers = flight.getPlane().getPassengers().size();
        return totalPassengers;
    }

    public Plane findBestPlane(Flight flight){
        Plane bestPlane = hangar.get(0);
        for (Plane plane : hangar) {
            int planeComparison = plane.differenceFromRequiredPassengers(flight);
            int bestPlaneComparison = bestPlane.differenceFromRequiredPassengers(flight);
            int thisPlaneDifference = differenceBetweenNumbers(planeComparison, bestPlaneComparison);

            if (planeComparison == 0){
                return plane;
            }
            else if (thisPlaneDifference < bestPlaneComparison) {
                bestPlane = plane;
            }
        }
        return bestPlane;
    }

    public int differenceBetweenNumbers(int number1, int number2) {
        int x = number1 - number2;
        int y = number2 - number1;
        int difference = Math.abs(x * y);

        return difference;
    }

    public Passenger findPassengerByName(String passengerName){

        for (Passenger passenger : passengers){
            if (passenger.getName() == passengerName) {
                return passenger;
            }
        }
        return null;
    }


}

