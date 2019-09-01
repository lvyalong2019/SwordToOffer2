package Chapter_04;

/**
 * 二叉搜索树和双向链表
 */

public class Test36 {

    TreeNode tempLastNode = null;
    TreeNode fisrtListNode;

    public TreeNode convert(TreeNode pHead) {
        if (pHead == null)
            return pHead;

        convertCore(pHead);

        fisrtListNode = pHead;
        while (fisrtListNode.left != null)
            fisrtListNode = fisrtListNode.left;
        return fisrtListNode;
    }

    public void convertCore(TreeNode pHead) {
        if (pHead == null)
            return;

        convertCore(pHead.left);

        if (tempLastNode != null)
            tempLastNode.right = pHead;
        pHead.left = tempLastNode;
        tempLastNode = pHead;

        convertCore(pHead.right);

    }

}
