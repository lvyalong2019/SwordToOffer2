package Chapter_02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 输入：5,10,10 输出：21
 * 15,20,20  359
 */

public class Test13Test {
    @Test
    public void movingCount() throws Exception {

        assertEquals(359, Test13.movingCount(15,20,20));

    }

}