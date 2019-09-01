package Chapter_05;

public class Test42 {

    public int findMaxSum (int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return 0;

        //max初定义为最小的整型，防止数组第一个值为负时，max不保存其值
        int max = Integer.MIN_VALUE;
        int tempsum = 0;
        for (int val : numbers) {
            tempsum = tempsum <= 0 ? val : tempsum + val;
            if (max < tempsum)
                max = tempsum;
        }

        return max;
    }

}
