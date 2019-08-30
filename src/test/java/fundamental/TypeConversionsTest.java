package fundamental;

import org.junit.Test;

import static org.junit.Assert.*;

public class TypeConversionsTest {
    @Test
    public void stringToInt() throws Exception {
    }

    @Test
    public void intToString() throws Exception {
        assertEquals(123,TypeConversions.intToString());
    }

}