package Chapter_04;

/**
 * 从上到下打印树
 * Q3：之字形打印树
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test32Q2 {

    public ArrayList<ArrayList<Integer>> print (TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(pRoot);
        int length;
        while (!queue.isEmpty()) {
            int tempLength = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (tempLength > 0) {
                tempLength--;
                TreeNode pNode = queue.poll();
                if (pNode == null)
                    continue;
                temp.add(pNode.val);
                queue.add(pNode.left);
                queue.add(pNode.right);
            }
            if (temp.size() != 0)
                ret.add(temp);
        }
        return ret;
    }

//    Q3
public ArrayList<ArrayList<Integer>> printZ (TreeNode pRoot) {

    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();

    queue.add(pRoot);
//    boolean reserve = false;
    int length = 1;
    while (!queue.isEmpty()) {
        int tempLength = queue.size();
        ArrayList<Integer> temp = new ArrayList<>();
        while (tempLength > 0) {
            tempLength--;
            TreeNode pNode = queue.poll();
            if (pNode == null)
                continue;

            if ((length & 1) != 1)
                stack.push(pNode.val);
            else
                temp.add(pNode.val);

//            if (reserve)
//                stack.push(pNode.val);
//            else
//                temp.add(pNode.val);

            queue.add(pNode.left);
            queue.add(pNode.right);
        }
//        while (reserve && !stack.isEmpty())
//            temp.add(stack.pop());
//        reserve = !reserve;

        while ((length & 1) != 1 && !stack.isEmpty())
            temp.add(stack.pop());
        length++;

        if (temp.size() != 0)
            ret.add(temp);
    }
    return ret;
}
}
