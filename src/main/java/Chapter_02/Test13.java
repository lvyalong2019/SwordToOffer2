package Chapter_02;

/**机器人的运动范围
 * 给定数组和数字，求机器人能够到达多少个格子
 *
 *
 */


public class Test13 {

    public static int movingCount(int threshold, int m, int n ) {
        if (m <= 0 || n <= 0 || threshold < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        return movingCountCore(m,n,threshold,0,0,visited);
    }

    public static int movingCountCore(int m, int n, int threshold, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(m,n,threshold,row,col,visited)) {
            visited[row][col] = true;
            count = count+1+ movingCountCore(m,n,threshold,row-1,col,visited)
                    + movingCountCore(m,n,threshold,row+1,col,visited)
                    + movingCountCore(m,n,threshold,row,col-1,visited)
                    + movingCountCore(m,n,threshold,row,col+1,visited);
        }
        return count;
    }

    public static boolean check(int m, int n, int threshold, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < m && col >= 0 && col < n &&
                visited[row][col] == false && getDigitSum(row) + getDigitSum(col) <= threshold)
            return true;
        return false;
    }

    public static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0){
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }

}
