package Chapter_04;

import java.util.Stack;

/**
 * 栈的压入和弹出序列
 */

public class Test31 {

    public boolean compare(int[] pPush, int[] pPop) {
        if (pPush == null || pPop == null || pPush.length != pPop.length)
            return false;

        int length = pPop.length;
        int indexOfPush = 0;
        int indexOfPop = 0;
        Stack<Integer> stack = new Stack<>();
        while (indexOfPop < length) {
            while ((stack.isEmpty() || pPop[indexOfPop] != stack.peek()) && indexOfPush < length) {
                stack.push(pPush[indexOfPush]);
                indexOfPush++;
            }
            if (pPop[indexOfPop] == stack.peek()) {
                indexOfPop++;
                stack.pop();
            }else break;
        }

        return indexOfPop == length ? true : false;
    }

    public boolean compare2(int[] pPush, int[] pPop) {
        if (pPush == null || pPop == null || pPush.length != pPop.length)
            return false;

        int length = pPop.length;
        int indexOfPop = 0;
        Stack<Integer> stack = new Stack<>();

        for (int indexOfPush = 0; indexOfPush < length; indexOfPush++) {
            stack.push(pPush[indexOfPush]);
            while (indexOfPop < length && stack.peek() == pPop[indexOfPop]) {
                stack.pop();
                indexOfPop++;
            }
        }

        return stack.isEmpty();
    }

}
