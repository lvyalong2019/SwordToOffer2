package Chapter_04;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Test32Q2Test {
    @Test
    public void print() throws Exception {
        //空值同样能保存进队列
        TreeNode pNode = null;
        TreeNode pNode1 = new TreeNode(1);
        TreeNode pNode2 = new TreeNode(2);
        TreeNode pNode3 = new TreeNode(3);
        //int不能为空，默认为0；Integer可以为空
//        TreeNode pNode1 = new TreeNode(null);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList);
        //反转List
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }
}