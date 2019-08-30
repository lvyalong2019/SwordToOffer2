package Chapter_03;

import java.util.function.Predicate;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 1、前后指针向中间走，前指针的值为偶停，后指针的值为奇停
 * 2、都停下后若前<后，交换值
 *   当前<后持续循环1与2
 *
 */

public class Test21 {

    public static void reorder(int[] array) {
        int length = array.length;
        if (array == null || length == 0)
            return;

        int pBegin = 0;
        int pEnd = length - 1;

        while (pBegin < pEnd) {
            while (pBegin < pEnd && (array[pBegin] & 1) != 0)
                pBegin++;
            while (pBegin < pEnd && (array[pEnd] & 1) == 0)
                pEnd--;

            if (pBegin < pEnd) {
                int temp = array[pBegin];
                array[pBegin] = array[pEnd];
                array[pEnd] = temp;
            }
        }
    }

    private boolean isEven(int n){
        return (n & 1) == 0;
    }

}
