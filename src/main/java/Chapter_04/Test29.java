package Chapter_04;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 */

public class Test29 {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        if (matrix == null)
            return null;
        ArrayList<Integer> str = new ArrayList<>();
        int start = 0;

        while (rows + 1 > start * 2 && cols + 1 > start * 2) {

            for (int i = start; i <= cols - start; i++)
                str.add(matrix[start][i]);

            for (int i = start + 1; i <= rows - start; i++)
                str.add(matrix[i][cols - start]);

            if (rows > start * 2) {
                for (int i = cols - start - 1; i >= start; i--)
                    str.add(matrix[rows - start][i]);
            }

            if (cols > start * 2) {
                for (int i = rows - start - 1; i >= start + 1; i--)
                    str.add(matrix[i][start]);
            }

            start++;
        }

        return str;
    }

}
