package Chapter_03;

/**
 * 树的子结构
 */

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right =null;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Test26 {

    public static boolean lookForTree2(TreeNode pRoot1, TreeNode pRoot2) {
        boolean result = false;

        if (pRoot1 != null && pRoot2 != null) {
            if (pRoot1.val == pRoot2.val)
                result = judge(pRoot1,pRoot2);
            if (!result)
                result = lookForTree2(pRoot1.left,pRoot2);
            if (!result)
                result = lookForTree2(pRoot1.right,pRoot2);
        }
        return result;
    }

    public static boolean judge(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot2 == null)
            return true;
        if (pRoot1 == null)
            return false;

        boolean result = false;

        if (pRoot1.val == pRoot2.val) {
            result = judge(pRoot1.left, pRoot2.left);
            if (result)
                result = judge(pRoot1.right, pRoot2.right);
        }
        return result;
    }

}
