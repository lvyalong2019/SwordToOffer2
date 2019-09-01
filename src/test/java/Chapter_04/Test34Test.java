package Chapter_04;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Test34Test {
    @Test
    public void findPath() throws Exception {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
//
//
//        System.out.println(Test34.findPath(node1,21));
        Test37.serialize(node1);

    }

}