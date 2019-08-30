package Chapter_03;

/**
 * 数值的整数次方
 * 解题关键：
 * 1、考虑指数为负数的情况，指数为负时，底数为0的情况需要特殊处理
 * 2、优化正常情况的算法
 */

public class Test16 {

    public static void main(String[] args) throws Exception {
        double result = 0.0;
        double temp = 1.0;
        result = power(0,-2);

        System.out.println(result);
    }

    public static double power(double base, int exponent) throws Exception {
        try {
            if (base == 0.0 && exponent < 0)
                throw new Exception("分母不能为0");
        }catch (Exception e) {
            System.out.println(e);
            return 0.0;
        }

        double result = 1.0;
        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }

        result = powerWithUnsigndExponent(base,absExponent);

        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    public static double powerWithUnsigndExponent(double base, int absExponent) {
        if (absExponent == 0)
            return 1;
        if (absExponent == 1)
            return base;

        double result = 1.0;
        result = powerWithUnsigndExponent(base,absExponent/2);
        result = result * result;
        if (absExponent%2 == 1)
            result = result * base;

        return result;
    }

    public static double power2(double base, int exponent) throws Exception {
        try {
            if (base == 0.0 && exponent < 0)
                throw new Exception("分母不能为0");
        }catch (Exception e){
            System.out.println(e);
            return 0.0;
        }

        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }

        double pow = power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;

        return isNegative ? 1 / pow : pow;
    }

}