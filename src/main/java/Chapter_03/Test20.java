package Chapter_03;

public class Test20 {

    static int index = 0;
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;


        boolean numeric = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            numeric = scanUnsignedInteger(str) || numeric;
        }

        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            numeric = scanInteger(str) && numeric;
        }

        return numeric && index == str.length;
    }

    private static boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);
    }

    private static boolean scanUnsignedInteger(char[] str) {
        int flag = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            ++index;
        }
        return index > flag;
    }

}
