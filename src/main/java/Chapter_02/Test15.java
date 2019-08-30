package Chapter_02;

public class Test15 {

    public static int numberOf1_solution1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag&n) != 0)
                count++;
            flag = flag<<1;
        }
        return count;
    }

    public static int numberOf1_solution2(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
