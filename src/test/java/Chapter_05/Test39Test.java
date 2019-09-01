package Chapter_05;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test39Test {
    @Test
    public void moreThanHaalfNum() throws Exception {

        int[] test1 = {1,2,4,3,3,3,3};
        int[] test2 = {1,2,3,2,4,2,5,2,3};
        int[] test3 = {1,2,3,2,2,2,5,4,2};
        int result = Test39.moreThanHaalfNum2(test1);
        System.out.println(result);

    }

}