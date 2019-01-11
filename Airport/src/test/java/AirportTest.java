import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {
    private Passenger passenger1;
    private Plane plane1;
    private Flight flight1;
    private Airport airport;

    @Before
    public void before(){
        passenger1 = new Passenger("Striker");
        plane1 = new Plane(PlaneType.SPITFIRE, AirlineType.EMIRATES);
        plane1.addPassenger(passenger1);
        flight1 = new Flight(1, DestinationType.BARCELONA);
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

}
