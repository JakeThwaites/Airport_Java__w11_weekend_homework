import org.junit.Before;
import org.junit.Test;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportTest {
    private Passenger passenger1;
    private Passenger passenger2;
    private Plane plane1;
    private Plane plane2;
    private Plane plane3;
    private Flight flight1;
    private Flight flight2;
    private Airport airport;

    @Before
    public void before(){
        passenger1 = new Passenger("Striker", 10);
        passenger2 = new Passenger("Jake", 20);
        plane1 = new Plane(PlaneType.SPITFIRE, AirlineType.EMIRATES, 2);
        plane2 = new Plane(PlaneType.MAGICCARPET, AirlineType.EASYJET, 10);
        plane3 = new Plane(PlaneType.MILLENIUMFALCON, AirlineType.EASYJET, 13);
        flight1 = new Flight(DestinationType.BARCELONA, 2);
        flight2 = new Flight(DestinationType.NEWYORK, 11);
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
        airport.createFlight(DestinationType.NEWYORK, 2);
        Flight newFlight = airport.getFlights().get(0);
        assertEquals(newFlight.getDestination(), DestinationType.NEWYORK);
        assertEquals(newFlight.getRequiredPassengers(), 2);
    }

    @Test
    public void creatingFlightAddsToFlightList(){
        assertEquals(0, airport.getFlights().size());
        airport.createFlight(DestinationType.NEWYORK, 2);
        assertEquals(1, airport.getFlights().size());
    }

    @Test
    public void canAddPlaneToFlight(){
        airport.createFlight(DestinationType.BARCELONA, 2);
        Flight newFlight = airport.getFlights().get(0);
        airport.addPlaneToHangar(plane1);
        airport.addPlaneToFlight(newFlight);
        assertEquals(plane1, newFlight.getPlane());
    }

    @Test
    public void assigningPlaneToFlightRemovesPlaneFromHangar(){
        airport.createFlight(DestinationType.BARCELONA, 2);
        airport.addPlaneToHangar(plane1);
        Flight newFlight = airport.getFlights().get(0);
        assertEquals(1, airport.getHangar().size());
        airport.addPlaneToFlight(newFlight);
        assertEquals(0, airport.getHangar().size());
    }

    @Test
    public void canOnlyAssignPlaneToFlightIfPlaneInHangar(){
        airport.createFlight(DestinationType.BARCELONA, 2);
        Flight newFlight = airport.getFlights().get(0);
        assertEquals(null, newFlight.getPlane() );
        airport.addPlaneToFlight(newFlight);
        assertEquals(null, newFlight.getPlane() );
    }

    @Test
    public void sellingTicketReducesPassengerMoney(){
        assertEquals(10, passenger1.getMoney());
        flight1.addPlane(plane1);
        airport.addPassenger(passenger1);
        airport.sellTicket(passenger1, flight1);
        assertEquals(5, passenger1.getMoney());
    }

    @Test
    public void sellingTicketAddsPassengerToFlight(){
        flight1.addPlane(plane1);
        airport.addPassenger(passenger1);
        ArrayList<Passenger> flightPassengers = flight1.getPlane().getPassengers();
        assertEquals(0, flightPassengers.size());
        airport.sellTicket(passenger1, flight1);
        assertEquals(1, flightPassengers.size());
    }

    @Test
    public void canShowTicketPassengersOnFlight(){
        flight1.addPlane(plane1);
        airport.addPassenger(passenger1);
        airport.sellTicket(passenger1, flight1);
        assertEquals(1, airport.totalPassengersOnFlight(flight1));
    }

    @Test
    public void onlySellsTicketIfRoomOnFlight(){
        airport.addPlaneToHangar(plane1);
        airport.addPlaneToFlight(flight1);
        airport.addPassenger(passenger1);
        airport.addPassenger(passenger2);
        airport.sellTicket(passenger1, flight1);
        airport.sellTicket(passenger2, flight1);
        assertEquals(2, airport.totalPassengersOnFlight(flight1));
        airport.sellTicket(passenger1, flight1);
        assertEquals(2, airport.totalPassengersOnFlight(flight1));
    }

    @Test
    public void canFindPlaneWithClosestPassengersToFlight(){
        airport.addPlaneToHangar(plane1);
        airport.addPlaneToHangar(plane2);
        airport.addPlaneToHangar(plane3);
        Plane bestPlane = airport.findBestPlane(flight2);
    }

    @Test
    public void startsWithNoPassengersInAirport(){
        assertEquals(0, airport.getPassengers().size());
    }

    @Test
    public void canAddPassengers(){
        assertEquals(0, airport.getPassengers().size());
        airport.addPassenger(passenger1);
        assertEquals(1, airport.getPassengers().size());
    }

    @Test
    public void canFindASpecificPassengerInAirport(){
        airport.addPassenger(passenger1);
        airport.addPassenger(passenger2);
        assertEquals(passenger2, airport.findPassengerByName("Jake"));
    }

    @Test
    public void creatingFlightSetsIncrementalFlightNumber(){
        airport.createFlight(DestinationType.NEWYORK, 3);
        airport.createFlight(DestinationType.NEWYORK, 3);
        Flight flight1 = airport.getFlights().get(0);
        Flight flight2 = airport.getFlights().get(1);
        assertEquals(flight1.getFlightNumber(), 1);
        assertEquals(flight2.getFlightNumber(), 2);
    }
}
