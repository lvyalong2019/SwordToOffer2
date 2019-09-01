package fundamental;

import java.util.Arrays;

/**排序算法：
 *
 */

public class Sort {

    public static void main(String[] args) throws Exception {
        int[] a = {14,7,5,2,1,1,3,4,5};
        quickSort(a,0,a.length-1);
//        System.out.println(Arrays.toString(a));
        System.out.println("排序后数组为" + Arrays.toString(a));
    }

//    快速排序
    public static int[] quickSort(int[] data, int start, int end) throws Exception {

        int flag = partition(data, start, end);

        if (flag-1 > start)
            quickSort(data, start, flag - 1);
        if (flag+1 < end)
            quickSort(data, flag + 1, end);

        return data;

    }

    public static int partition(int[] data, int start, int end) throws Exception {

        if (data == null || data.length <= 0 || start < 0 || end > data.length - 1) {
            throw new Exception("Invalid Parameters");
        }

        int index = (int)(start+Math.random()*(end-start+1));
//        int index = start;

        //交换数组标记数字与最后数字的位置
        int temp = data[end];
        data[end] = data[index];
        data[index] = temp;

        //标记左子数组最后一位的位置
        int small = start;

        //遍历数组，分组
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                if (i > small) {//如果该数字小于标记数字，并且其位置与small标记的位置不一样，将其与small标记的数字交换
                    temp = data[small];
                    data[small] = data[i];
                    data[i] = temp;
                }
                small++;
            }
        }
        //将标记数字放到左右数字中间
        temp = data[end];
        data[end] = data[small];
        data[small] = temp;

        return small;

    }
    public static int add1(){
        return 2;
    }
}
