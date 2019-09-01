package Chapter_05;

/**
 * 寻找数据流的中位数
 * 需要实现数据流的添加与查询
 * 综合插入与查询，使用合适的数据结构与算法实现最优解
 */

import java.util.PriorityQueue;

public class Test41 {

    //大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    //数据流数据个数
    int N = 0;

    public void insert(int val) {
        if ((N & 1) == 0)
        {
            right.add(val);
            left.add(right.poll());
        }
        else {
            left.add(val);
            right.add(left.poll());
        }
        N++;
    }

    public double getMedian() throws Exception {
        if (N == 0)
            throw new Exception("Data is Null");

        if ((N & 1) == 0)
            return  (left.peek() + right.peek())/2.0;
        else
            return left.peek();
    }

}
