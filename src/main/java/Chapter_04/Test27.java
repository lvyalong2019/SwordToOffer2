package Chapter_04;

/**
 * 二叉树的镜像
 */

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right =null;
    TreeNode(int val) {
        this.val = val;
    }
}


public class Test27 {

    public void MirrorRecursively(TreeNode pRoot) {
        if (pRoot == null)
            return;
        if (pRoot.left == null && pRoot.right == null)
            return;

        TreeNode temp = pRoot.right;
        pRoot.right = pRoot.left;
        pRoot.left = temp;

        MirrorRecursively(pRoot.left);
        MirrorRecursively(pRoot.right);

    }

    

}
