import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    private Passenger passenger1;
    private Passenger passenger2;
    private Plane plane;
    private Flight flight1;
    private Flight flight2;

    @Before
    public void before(){
        passenger1 = new Passenger("Striker", 10);
        passenger2 = new Passenger("Jake", 10);
        plane = new Plane(PlaneType.SPITFIRE, AirlineType.EMIRATES, 2);
        flight1 = new Flight(1, DestinationType.NEWYORK, 1);
        flight2 = new Flight(2, DestinationType.NEWYORK, 4);
    }

    @Test
    public void hasType(){
        assertEquals(PlaneType.SPITFIRE, plane.getType());
    }

    @Test
    public void hasAirline(){
        assertEquals(AirlineType.EMIRATES, plane.getAirline());
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, plane.getPassengers().size());
    }

    @Test
    public void canAddPassengers(){
        assertEquals(0, plane.getPassengers().size());
        plane.addPassenger(passenger1);
        assertEquals(1, plane.getPassengers().size());
    }

    @Test
    public void hasMaxPassengers(){
        assertEquals(2, plane.getMaxPassengers());
    }

    @Test
    public void canCheckIFEmptySeatsTrue(){
        assertEquals(true, plane.hasEmptySeats());
    }

    @Test
    public void canCheckIFEmptySeatsFalse(){
        plane.addPassenger(passenger1);
        plane.addPassenger(passenger2);
        assertEquals(false, plane.hasEmptySeats());
    }

    @Test
    public void canShowDifferenceFromRequiredPassengers(){
        assertEquals(1, plane.differenceFromRequiredPassengers(flight1));
        assertEquals(2, plane.differenceFromRequiredPassengers(flight2));
    }
}
