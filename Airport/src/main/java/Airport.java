import java.util.ArrayList;

public class Airport {
    private ArrayList<Plane> hangar;
    private AirportCodeType airportCode;
    private ArrayList<Flight> flights;
    private ArrayList<Passenger> passengers;

    public Airport(AirportCodeType airportCode){
        this.airportCode = airportCode;
        this.hangar = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.passengers = new ArrayList<>();
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

    public void createFlight(Integer flightNumber, DestinationType destination){
        Flight newFlight = new Flight(flightNumber, destination, 2);
        flights.add(newFlight);
    }

    public void addPlaneToFlight(Flight flight, Plane plane){
        if (plane.inHangar()){
            flight.addPlane(plane);
            hangar.remove(plane);
            plane.leaveHangar();
        }
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

    public Plane findBestPlane(Flight flight){
        Plane bestPlane = hangar.get(0);
        for (Plane plane : hangar) {
            int planeComparison = plane.differenceFromRequiredPassengers(flight);
            int bestPlaneComparison = bestPlane.differenceFromRequiredPassengers(flight);
            int thisPlaneDifference = differenceBetweenNumbers(planeComparison, bestPlaneComparison);
            int bestPlaneDifference = bestPlane.differenceFromRequiredPassengers(flight);

            if (planeComparison == 0){
                return plane;
            }
            else if (thisPlaneDifference < bestPlaneDifference) {
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


}

