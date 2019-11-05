package Chapter_02;

import java.util.Scanner;

/**
 * 二维数组中的查找：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/**
 * 测试用例：
 * 1.整数为空
 * 2.正常查找
 * 3.查找不到
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 */

/**
 * 解题思路：
 * 从左下角或者右上角开始，每一次比较都可以排除一行或者一列
 */

/**
 * 之后做剑指offer题，应该以算法为主，输入输出为辅，先写出正确的算法
 * 再根据主函数修改使算法能够运行
 */

public class Test04 {
    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入二维数组大小");
        int n = in.nextInt();

        int [][]a = new int[n][n];
        System.out.println("请输入数组");
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                a[i][j] = in.nextInt();
            }
        }

        System.out.println("请输入一个常数");
        int number = in.nextInt();

        boolean found1 = Find(number,a,n);
        if (found1)
            System.out.println("yes!!!");
        else
            System.out.println("no!!!");

    }

    public static boolean Find(int number,int [] [] a,int n){

        if (a == null || a.length == 0 || a[0].length == 0 )
            return false;

        int row = 0;
        int col = n-1;
        while (row <= n-1 && col >= 0){
            if (number == a[row][col])
                return true;
            else if (number < a[row][col])
                col--;
            else
                row++;
        }
        return false;
    }

}
