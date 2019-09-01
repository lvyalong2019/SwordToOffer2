package Chapter_05;


import java.util.Random;
import fundamental.Sort;

/**
 * 数组中出现次数超过一半的数字
 */

public class Test39 {

    public static int moreThanHaalfNum (int[] numbers) throws Exception {
        if (numbers == null || numbers.length <= 0)
            return 0;

        int length = numbers.length;
        int index;
        int middle = length>>1;
        int start = 0;
        int end = length - 1;
        index = partition(numbers,start,end);

        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(numbers,start,end);
            }
            if (index < middle) {
                start = index + 1;
                index = partition(numbers,start,end);
            }
        }

        int result = numbers[middle];
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (numbers[i] == result)
                count++;
        }
        if (count <= length/2)
            return  0;

        return result;
    }

    private static int partition(int[] numbers, int start, int end) throws Exception {
        if (numbers == null || numbers.length <= 0 || start < 0 || end > numbers.length)
            throw new Exception("Invalid Parameters");

        int index = (int)(start + Math.random()*(end - start + 1));
        int temp = numbers[index];
        numbers[index] = numbers[end];
        numbers[end] = temp;
        int flagOfFisrtBig = start;

        for (int i = start; i < end;i++) {
            if (numbers[i] < numbers[end]) {
                if (flagOfFisrtBig < i) {
                    temp = numbers[flagOfFisrtBig];
                    numbers[flagOfFisrtBig] = numbers[i];
                    numbers[i] = temp;
                }
                flagOfFisrtBig++;
            }
        }

        temp = numbers[flagOfFisrtBig];
        numbers[flagOfFisrtBig] = numbers[end];
        numbers[end] = temp;

        return flagOfFisrtBig;
    }

    public static int moreThanHaalfNum2 (int[] numbers){
        if (numbers == null || numbers.length <= 0)
            return 0;

        int length = numbers.length;
        int result = numbers[0];
        int times = 1;

        for (int i = 1; i < length; i++) {
            if (times == 0) {
                result = numbers[i];
                times++;
            }else if (result == numbers[i]) {
                times++;
            }else {
                times--;
            }
        }

        int count = 0;

        for (int i = 0; i < length; i++) {
            if (numbers[i] == result)
                count++;
        }

        if (count <= length/2)
            return  0;

        return result;
    }

}
