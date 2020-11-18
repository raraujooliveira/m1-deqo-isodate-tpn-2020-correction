package deqo.isodate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsoDaysTest {

    @Test
    public void toString_AvecConstructeur1() throws IsoDateException {
        final String s1 = "2019-365"; //note aux correcteurs: ici ça peut etre d'autres dates
        assertEquals(s1, new IsoDays(2019, 365).toString());
    }

    @Test
    public void toString_AvecConstructeur2() throws IsoDateException{
        final String s1 = "2019-001"; //note aux correcteurs: ici ça peut etre d'autres dates
        assertEquals(s1, new IsoDays(s1).toString());
    }

    @Test(expected = IsoDateException.class)
    public void testKO() throws IsoDateException {
        new IsoDays("2019-1"); //note aux correcteurs: ici ça peut etre d'autres dates
    }

    //Question 7
    @Test(expected = IsoDateException.class)
    public void testDayBug1() throws IsoDateException {
        new IsoDays(2019, 400);
    }
    @Test(expected = IsoDateException.class)
    public void testDayBug2() throws IsoDateException {
        new IsoDays("2019-400");
    }
}