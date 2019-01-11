import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    private Passenger passenger1;

    @Before
    public void before(){
        passenger1 = new Passenger("Striker", 10);
    }

    @Test
    public void hasName(){
        assertEquals("Striker", passenger1.getName());
    }

    @Test
    public void hasMoney(){
        assertEquals(10, passenger1.getMoney());
    }

    @Test
    public void canBuyTicket(){
        assertEquals(10, passenger1.getMoney());
        passenger1.buyTicket();
        assertEquals(5, passenger1.getMoney());
    }


}
