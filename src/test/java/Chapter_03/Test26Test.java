package Chapter_03;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test26Test {
    @Test
    public void lookForTree2() throws Exception {
        TreeNode tree1_1 = new TreeNode(8);
        TreeNode tree1_2 = new TreeNode(7);
        TreeNode tree1_3 = new TreeNode(6);
        tree1_1.left = tree1_2;
        tree1_1.right = tree1_3;
        TreeNode tree2_1 = new TreeNode(8);

        assertEquals(true,Test26.lookForTree2(tree1_1,tree2_1));


    }

}