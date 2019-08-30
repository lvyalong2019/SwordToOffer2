package Chapter_03;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test19Test {
    @Test
    public void match() throws Exception {
        String str1 = "";
        String str2 = "*";
        char[] str = str1.toCharArray();
        char[] pattern = str2.toCharArray();
        assertEquals(true,Test19.match(str,pattern));
    }

}