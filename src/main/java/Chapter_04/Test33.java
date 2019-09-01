package Chapter_04;

/**
 * 二叉搜索树的后序遍历
 */

import java.util.Stack;

public class Test33 {


    //递归
    public boolean verifySquenceOfBST(int[] array) {
        if (array == null || array.length == 0)
            return false;

        int last = array.length - 1;
        int start = 0;
        return verify(array,start,last);
    }

    private boolean verify(int[] array, int start, int last) {
        if (last - start < 2 )
            return true;

        int index = last - 1;

        while (index >= start && array[index] > array[last])
            index--;

        int flag = index;

        while (index >= start && array[index] < array[last])
            index--;

        if (index >= start)
            return false;

        return verify(array,start,flag) && verify(array,flag+1,last-1);
    }

    //栈
    public boolean verifySquenceOfBST2(int[] array) {
        if (array == null || array.length == 0)
            return false;
        int length = array.length;
        int start = 0;
        int last = length - 1;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackStart = new Stack<>();

        stack.push(last);
        stackStart.push(start);
        while (!stack.isEmpty()) {
            last = stack.pop();
            start = stackStart.pop();
            if (last - start < 2)
                continue;
            int index = last - 1;

            while (index >= start && array[index] > array[last])
                index--;

            int flag = index;

            while (index >= start && array[index] < array[last])
                index--;

            if (index >= start)
                return false;

            if (flag >= start) {
                stack.push(flag);
                stackStart.push(start);
            }

            if (flag < last - 1) {
                stack.push(last-1);
                stackStart.push(flag+1);
            }

        }

        return true;

    }

}
