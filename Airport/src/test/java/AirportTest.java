import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportTest {
    private Passenger passenger1;
    private Plane plane1;
    private Flight flight1;
    private Airport airport;

    @Before
    public void before(){
        passenger1 = new Passenger("Striker", 10);
        plane1 = new Plane(PlaneType.SPITFIRE, AirlineType.EMIRATES, 2);
        flight1 = new Flight(1, DestinationType.BARCELONA, 2);
        airport = new Airport(AirportCodeType.EDI);
    }

    @Test
    public void hasAirportCode(){
        assertEquals(AirportCodeType.EDI, airport.getAirportCode());
    }

    @Test
    public void startsWithoutPlanes(){
        assertEquals(0, airport.getHangar().size());
    }

    @Test
    public void startsWithoutFlights(){
        assertEquals(0, airport.getFlights().size());
    }

    @Test
    public void canAddPlaneToHangar(){
        assertEquals(0, airport.getHangar().size());
        airport.addPlaneToHangar(plane1);
        assertEquals(1, airport.getHangar().size());
    }

    @Test
    public void canAddFlights(){
        assertEquals(0, airport.getFlights().size());
        airport.addFlight(flight1);
        assertEquals(1, airport.getFlights().size());
    }

    @Test
    public void canCreateFlight(){
        assertEquals(0, airport.getFlights().size());
        airport.createFlight(2, DestinationType.NEWYORK);
        Flight newFlight = airport.getFlights().get(0);
        assertEquals(newFlight.getDestination(), DestinationType.NEWYORK);
        assertEquals(newFlight.getFlightNumber(), 2);
    }

    @Test
    public void creatingFlightAddsToFlightList(){
        assertEquals(0, airport.getFlights().size());
        airport.createFlight(2, DestinationType.NEWYORK);
        assertEquals(1, airport.getFlights().size());
    }

    @Test
    public void canAddPlaneToFlight(){
        airport.createFlight(2, DestinationType.BARCELONA);
        Flight newFlight = airport.getFlights().get(0);
        airport.addPlaneToFlight(newFlight, plane1);
        assertEquals(plane1, newFlight.getPlane());
    }

    @Test
    public void sellingTicketReducesPassengerMoney(){
        assertEquals(10, passenger1.getMoney());
        flight1.addPlane(plane1);
        airport.sellTicket(passenger1, flight1);
        assertEquals(5, passenger1.getMoney());
    }

    @Test
    public void sellingTicketAddsPassengerToFlight(){
        flight1.addPlane(plane1);
        ArrayList<Passenger> flightPassengers = flight1.getPlane().getPassengers();
        assertEquals(0, flightPassengers.size());
        airport.sellTicket(passenger1, flight1);
        assertEquals(1, flightPassengers.size());
    }

    @Test
    public void canShowTicketPassengersOnFlight(){
        flight1.addPlane(plane1);
        airport.sellTicket(passenger1, flight1);
        assertEquals(1, airport.totalPassengersOnFlight(flight1));
    }

    @Test
    public void onlySellsTicketIfRoomOnFlight(){
        airport.addPlaneToFlight(flight1, plane1);
        airport.sellTicket(passenger1, flight1);
        airport.sellTicket(passenger1, flight1);
        assertEquals(2, airport.totalPassengersOnFlight(flight1));
        airport.sellTicket(passenger1, flight1);
        assertEquals(2, airport.totalPassengersOnFlight(flight1));
    }

    @Test
    public void canFindPlaneWithClosestPassengersToFlight(){

    }
}
