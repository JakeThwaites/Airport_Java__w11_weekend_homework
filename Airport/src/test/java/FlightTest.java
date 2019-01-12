import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Passenger passenger1;
    private Plane plane;
    private Flight flight;

    @Before
    public void before(){
        passenger1 = new Passenger("Striker", 10);
        plane = new Plane(PlaneType.SPITFIRE, AirlineType.EMIRATES, 2);
        plane.addPassenger(passenger1);
        flight = new Flight(DestinationType.NEWYORK, 2);
    }

    @Test
    public void hasFlightNumber(){
        assertEquals(0, flight.getFlightNumber());
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

    @Test
    public void hasRequiredPassengersNumber(){
        assertEquals(2, flight.getRequiredPassengers());
    }

    @Test
    public void canSetFlightNumber(){
        flight.setFlightNumber(1);
        assertEquals(1, flight.getFlightNumber());
    }

}
