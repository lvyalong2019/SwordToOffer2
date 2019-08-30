package Chapter_03;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Test20Test {
    @Test
    public void isNumeric() throws Exception {
        String str1 = "+500";
        char[] str = str1.toCharArray();
        assertEquals(true,Test20.isNumeric(str));
    }

}