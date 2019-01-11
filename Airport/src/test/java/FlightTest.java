import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Passenger passenger1;
    private Plane plane;
    private Flight flight;

    @Before
    public void before(){
        passenger1 = new Passenger("Striker");
        plane = new Plane(PlaneType.SPITFIRE, AirlineType.EMIRATES);
        plane.addPassenger(passenger1);
        flight = new Flight(1, DestinationType.NEWYORK);
    }

    @Test
    public void hasFlightNumber(){
        assertEquals(1, flight.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals(DestinationType.NEWYORK, flight.getDestination());
    }

    @Test
    public void startsWithNoPlane(){
        assertEquals(null, flight.getPlane());
    }

    @Test
    public void canAddPlane(){
        assertEquals(null, flight.getPlane());
        flight.addPlane(plane);
        assertEquals(plane, flight.getPlane());
    }
}
