package Chapter_05;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test40Test {
    @Test
    public void getLeastNum() throws Exception {

        int[] test1 = {1,2,4,3,3,3,3};
        int[] test2 = {1,2,3,2,4,2,5,2,3};
        int[] test3 = {1,2,3,2,2,2,5,4,2};
        int[] test4 = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = Test40.getLeastNum(test4,8);
        System.out.println(result);

    }

}