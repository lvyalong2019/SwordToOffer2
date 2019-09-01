package Chapter_04;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Test33Test {
    @Test
    public void verifySquenceOfBST() throws Exception {

        int[] array = new int[0];
        int[] array1 = null;
        array1 = array;
//        array[0] = null;
//        System.out.println(array1.length);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array1));
    }

}