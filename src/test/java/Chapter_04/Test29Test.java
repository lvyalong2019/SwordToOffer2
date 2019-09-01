package Chapter_04;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test29Test {
    @Test
    public void printMatrix() throws Exception {
        int[][] matrix = {{1}};
        ArrayList<Integer> str = Test29.printMatrix(matrix);
        System.out.println(str.size());

    }

}