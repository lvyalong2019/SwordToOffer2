package Chapter_02;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test11Test {

    @Test
    public void minTest() throws Exception {
        int[] a = {3,4,5,1,2};
        int[] b = {3,3,5,1,2,3};
        int[] c = {1,2,3,4,5};
        int[] d = {1};
        int[] e = {};
        int[] f = null;
        assertEquals(1,Test11.min(d));
    }

}