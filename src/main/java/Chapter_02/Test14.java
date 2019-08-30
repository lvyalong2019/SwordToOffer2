package Chapter_02;

/**剪绳子
 * 解法：
 * 1、动态规划
 * 2、贪婪算法
 */

public class Test14 {

    public static int maxProductAfterCutting(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int[] product = new int[length+1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (max < product[j]*product[i-j])
                    max = product[j]*product[i-j];
            }
            product[i] = max;
        }

        return product[length];
    }

    public static int maxProductAfterCutting2(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int timeOf3 = length / 3;
        if (length % 3 == 1)
            timeOf3--;
        int timeOf2 = (length - 3*timeOf3) / 2;


        return (int)Math.pow(3,timeOf3) * (int)Math.pow(2,timeOf2);
    }

}
