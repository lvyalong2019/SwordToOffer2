package Chapter_04;

/**
 * 对称的二叉树
 */

public class Test28 {

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;

        return isSymmetrical(pRoot.left,pRoot.right);
    }

    public boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null)
            return true;
        if (pRoot1 == null || pRoot2 == null)
            return false;
        if (pRoot1 != pRoot2)
            return false;

        return isSymmetrical(pRoot1.left,pRoot2.right)
                &&isSymmetrical(pRoot1.right,pRoot2.left);
    }

}
