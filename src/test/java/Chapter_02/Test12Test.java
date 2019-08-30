package Chapter_02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * "ABCESFCSADEE",3,4,"SEE""ABCCED"
 * "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SGGFIECVAASABCEHJIGQEM"
 */

public class Test12Test {
    @Test
    public void hasPath() throws Exception {
//        char[][] matrix = {{'a','b'},{'c','d'}};
//        char[] matrix = {'a','b','c','d'};
//        char[] str = {'a','b','d','c'};

//        char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
//        char[] str = {'S','E','E'};
//        char[] str2={'A','B','C','C','E','D'};

        String str1 = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        String str2 = "SGGFIECVAASABCEHJIGQEM";

        char[] matrix = str1.toCharArray();
        char[] str= str2.toCharArray();

        assertEquals(true,Test12.hasPath(matrix,5,8,str));
    }

}