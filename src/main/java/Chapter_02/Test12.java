package Chapter_02;

/**矩阵的路径：判断一个矩阵是否存在一条路径，与某字符串所有字符一一对应
 * 数据结构：一个二维数组保存数据a[rows][cols]，一条字符数组，一个二维数组保存该点是否已经走过
 * 解法：
 * 1、
 *
 *
 *
 */

public class Test12 {

//    public static boolean hashPath(char[] matrix, int rows, int cols, char[] str) {
//
//    }

//    public static boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {
//        boolean flag = false;
//        int length = str.length;
//        int startRows = 0;
//        int startCols = 0;
//        int index = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == str[index]){
//                    startCols = i;
//                    startRows = j;
//                }
//            }
//        }
//        flag = hasPathCore(matrix,rows,cols,str,startRows,startCols,index);
//        return flag;
//    }
//
//    public static boolean hasPathCore(char[][] matrix, int rows, int cols, char[] str, int i, int j,int index) {
//        boolean flag = false;
//
//        if (matrix[i][j] == str[index]) {
//            if (index == str.length - 1)
//                return true;
//
//            if (i > 0 ) {
//                if (matrix[i-1][j] == str[index + 1])
//                    flag = hasPathCore(matrix,rows,cols,str,i-1,j,index+1);
//            }
//            if (i < rows-1 && flag != true ) {
//                if (matrix[i+1][j] == str[index + 1])
//                    flag = hasPathCore(matrix,rows,cols,str,i+1,j,index+1);
//            }
//            if (j > 0 ) {
//                if (matrix[i][j-1] == str[index + 1])
//                    flag = hasPathCore(matrix,rows,cols,str,i,j-1,index+1);
//            }
//            if (j < cols-1 && flag != true ) {
//                if (matrix[i][j+1] == str[index + 1])
//                    flag = hasPathCore(matrix,rows,cols,str,i,j+1,index+1);
//            }
//        }
//        return flag;
//    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;
        boolean flag = false;
        int length = str.length;
        int startRows = 0;
        int startCols = 0;
        int index = 0;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix1 = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix1[r][c] = matrix[index++];
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix1[i][j] == str[index]){
                    startRows = i;
                    startCols = j;
                    flag = hasPathCore(matrix1,rows,cols,str,startRows,startCols,0,marked);
                    if (flag)
                        return flag;
                }
            }
        }
//        flag = hasPathCore(matrix1,rows,cols,str,startRows,startCols,0,marked);
        return flag;
    }

    public static boolean hasPathCore(char[][] matrix, int rows, int cols, char[] str, int i, int j,int index,boolean[][] marked) {
        boolean flag = false;

        if (matrix[i][j] == str[index]) {
            if (index == str.length - 1)
                return true;
            marked[i][j] = true;
            boolean test = marked[1][0];
            if (i > 0 && flag != true && marked[i-1][j]!=true) {
                if (matrix[i-1][j] == str[index + 1])
                    flag = hasPathCore(matrix,rows,cols,str,i-1,j,index+1,marked);
            }
            if (i < rows-1 && flag != true && marked[i+1][j]!=true) {
                if (matrix[i+1][j] == str[index + 1])
                    flag = hasPathCore(matrix,rows,cols,str,i+1,j,index+1,marked);
            }
            if (j > 0 && flag != true && marked[i][j-1]!=true) {
                if (matrix[i][j-1] == str[index + 1])
                    flag = hasPathCore(matrix,rows,cols,str,i,j-1,index+1,marked);
            }
            if (j < cols-1 && flag != true && marked[i][j+1]!=true) {
                if (matrix[i][j+1] == str[index + 1])
                    flag = hasPathCore(matrix,rows,cols,str,i,j+1,index+1,marked);
            }
        }
        marked[i][j] = false;
        return flag;
    }

}
