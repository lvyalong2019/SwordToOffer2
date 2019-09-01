package Chapter_04;

import java.util.Stack;

public class Test30 {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int num) {
//        对于数据使用之前要判断是否为空，if语句中判断是否为空的语句要放在其他语句前面
        if (minStack.isEmpty() || num < minStack.peek())
            minStack.push(num);
        else
            minStack.push(minStack.peek());
        dataStack.push(num);
    }

    public void pop() {
        assert(!minStack.isEmpty() && !dataStack.isEmpty());
        minStack.pop();
        dataStack.pop();
    }

    public int min() {
//        assert(!minStack.isEmpty() && !dataStack.isEmpty());
//        return minStack.peek();
        try {
            return minStack.peek();
        }catch (Exception e) {
            System.out.println(e);
        }
        finally {
            return 0;
        }
    }

}
