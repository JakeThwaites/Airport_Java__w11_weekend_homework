import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    private Passenger passenger1;

    @Before
    public void before(){
        passenger1 = new Passenger("Striker");
    }

    @Test
    public void hasName(){
        assertEquals("Striker", passenger1.getName());
    }


}
