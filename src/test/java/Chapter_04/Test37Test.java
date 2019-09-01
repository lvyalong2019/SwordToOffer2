package Chapter_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test37Test {
    @Test
    public void serialize() throws Exception {

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(Test37.serialize(node1));
        TreeNode pHead = Test37.deserialize(Test37.serialize(node1));
        System.out.println(pHead.val);
    }

}