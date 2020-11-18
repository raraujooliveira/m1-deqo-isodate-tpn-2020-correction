package deqo.isodate;

import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {

    @Test
    public void getYear() {
        // Given a new object Year = 2020
        Year y = new Year(2020);

        // When we get the value of this object
        // Then the year = 2020
        assertEquals(2020, y.getYear());
    }

    @Test
    public void isLeapYear() {
        assertFalse(new Year(1900).isLeapYear());
        assertTrue(new Year(2000).isLeapYear());
        assertTrue(new Year(2008).isLeapYear());
        assertFalse(new Year(2019).isLeapYear());
    }
}