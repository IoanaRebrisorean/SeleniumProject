import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class testAssertions {

    @Test
            public void assertions() {
        String string1 = new String("ioana");
        String string2 = new String("ioana");
        String string3 = null;
        String string4 = "ioana";
        String string5 = "ioana";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};

        assertEquals(string1, string2);
        assertTrue(val1<val2);
        assertFalse(val1 > val2);
        assertNull(string3);
        assertNotNull(string1);
        assertSame(string4, string5);
        assertNotSame(string1, string4);
        assertArrayEquals(expectedArray, resultArray);

    }



}
