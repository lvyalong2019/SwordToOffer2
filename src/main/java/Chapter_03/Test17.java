package Chapter_03;

import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 * 难点：
 * 为防止溢出，使用字符串保存数据，用字符串模拟数字加法，数字输出
 * 解法一：正常解法
 * 1、char数组中数字递增，当最高位等于10，结束递增
 * 2、输出数字
 *   递增方法，当最高位
 * 解法二：使用递归
 *
 */

public class Test17 {

    public static void print1ToMaxOfNDigits_recursively(int n) {
        if (n <= 0)
            return;

        char[] number = new char[n];
        Arrays.fill(number,'0');
        int index = 0;
        recursively(number,n,index);

//        for (int i = 0; i < 10; i++) {
//            number[index] = (char)(i + '0');
//            recursively(number,n,index);
//        }
    }

    private static void recursively(char[] number, int n, int index) {
        if (index-1 == n - 1){
            printNumber(number,n);
            return;
        }

        for (int i = 0;i < 10; i++) {
            number[index] = (char)(i + '0');
            recursively(number,n,index+1);
        }

    }

    public static void print1ToMaxOfNDigits(int n) {
        if(n <= 0)
            return;

        char[] number = new char[n];
        Arrays.fill(number,'0');
        boolean flag = true;

        while (increment(number,n)){
            printNumber(number,n);
        }
    }

    private static boolean increment(char[] number, int n) {
        boolean flag = true;
        boolean nTakeOver = false;//标记是否进位

        for (int i = n-1;i >=0; i--) {
            int nSum = number[i] - '0';
            if (i == n - 1)
                nSum++;
            if (nTakeOver)
                nSum++;
//            nTakeOver = false;
            if (nSum >= 10) {
                if (i == 0)
                    flag = false;
                else {
                    nSum -= 10;
                    nTakeOver = true;
                    number[i] = (char)('0' + nSum);
                }
            }
            else {
                number[i] = (char)('0' + nSum);
                break;
            }
        }
        return flag;
    }

    private static void printNumber(char[] number, int n) {
        boolean beginPrint = false;
        for (int i = 0; i < n; i++) {
            if (number[i] != '0')
                beginPrint = true;
            if (beginPrint)
                System.out.print(number[i]);
        }
        if (beginPrint)
            System.out.println();
    }

}
