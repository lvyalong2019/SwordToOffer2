package Chapter_04;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test38Test {
    @Test
    public void permutation() throws Exception {

//        String str = null;
//        String str1 = "";
//        System.out.println(str);
//        System.out.println(str1);
//        System.out.println(str1.length());

        String str1 = "aba";
        ArrayList<String> ret = Test38.Permutation(str1);
        System.out.println(ret);

    }

}