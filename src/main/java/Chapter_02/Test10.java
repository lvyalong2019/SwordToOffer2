package Chapter_02;

import java.util.Scanner;

/**斐波拉契数列
 * 解法：
 * 1、递归
 * 2、循环
 *
 */

public class Test10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(Fibonacci(n));
    }

    public static long Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long pre1 = 0, pre2 = 1;
        long fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib;
        }

        return fib;
    }

    public int Fibonacci2(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }

    /*青蛙跳台阶*/
    public int frogJumpStep(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int pre1 = 1, pre2 = 2;
        int fib = 0;
        for (int i = 3; i <= n; i++) {
            fib = pre1 + pre2;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }
}
