package Chapter_05;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 找出数组最小的几个数
 */

public class Test40 {

    public static ArrayList<Integer> getLeastNum(int[] input, int k) throws Exception{
        ArrayList<Integer> output = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length)
            return output;

        int start = 0;
        int end = input.length - 1;
        int index = partition(input,start,end);
        while (index != k - 1) {
            if (index < k - 1) {
                index = partition(input,index + 1,end);
            }
            if (index > k - 1)
                index = partition(input,start,index - 1);

        }

        for (int i = 0; i < k; i++) {
            output.add(input[i]);
        }
        return output;
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

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] nums, int k) {
        if (nums == null || k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            if (maxHeap.size() < k || (maxHeap.peek() > num && maxHeap.size() > k))
                maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

}
