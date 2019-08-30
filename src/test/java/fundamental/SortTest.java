package fundamental;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void quickSort() throws Exception {

        int[] a = {3,2,1};
        int[] c = {1,2,3};
        int[] b = Sort.quickSort(a,0,2);
        assertEquals(Arrays.toString(c),Arrays.toString(b));

    }
    @Test
    public void add1() throws Exception {
        assertEquals(2,Sort.add1());
    }

}