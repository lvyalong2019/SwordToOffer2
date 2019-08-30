package Chapter_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**二叉树的下一个节点：
 * 寻找二叉树中序遍历的下一个节点，该树的节点能指向父节点。
 * 核心算法：
 * 中序遍历的下一个节点有三种情况
 * 1、在右子树的最左节点
 * 2、在父节点
 *  2.1、该节点是父节点的左子树，下一个节点为父节点
 *  2.2、该节点是父节点的右子树，找到第一个是左子节点的父节点，下一个节点为该节点的父节点
 * （若三种情况都没有，则该节点没有下一个节点）
 */

/*添加功能，实现了三指针二叉树的初始化*/

//class TreeNode1 extends TreeNode {
//    int val;
//    TreeNode1 left;
//    TreeNode1 right;
//    TreeNode1 parent;
//    TreeNode1 (int val) {
//        this.val = val;
//    }
//}

public class Test08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str1 = in.nextLine().split(" ");
        int length1 = str1.length;
        int[] a = new int[length1];
        for (int i = 0; i < length1; i++){
            a[i] = Integer.valueOf(str1[i]);
        }
        String[] str2 = in.nextLine().split(" ");
        int length2 = str1.length;
        int[] b = new int[length2];
        for (int i = 0; i < length2; i++){
            b[i] = Integer.valueOf(str2[i]);
        }


        TreeNode root = construct(a, b);
//        preOutputTree(root);
//        System.out.println();
//        inOutputTree(root);
//        System.out.println();
        lastOutputTree(root);
        System.out.println();

//        root = root.left;
//        System.out.println(root.val);
        TreeNode temp = root.right.right.left;
//        temp.parent = root;
        TreeNode nextNode = findNextNode(temp);
        System.out.println(nextNode.val);
    }

    public static TreeNode findNextNode(TreeNode pNode) {
        TreeNode pNext = pNode;
        TreeNode pTemp = new TreeNode(0);
        if (pNext.right != null) {
            pNext = pNext.right;
            while (pNext.left != null) {
                pNext = pNext.left;
            }
            return pNext;
        }else {
            while (pNext.parent != null) {
                pTemp = pNext;
                pNext = pNext.parent;
                if (pNext.left == pTemp) {
                    return pNext;
                }
            }
            return null;
        }
    }

    private static Map<Integer,Integer> indexForInOrder = new HashMap<>();

    public static TreeNode construct (int[] pre,int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrder.put(in[i], i);
        }
        return constructCore(pre, 0, pre.length - 1, 0, null);
    }

    public static TreeNode constructCore(int[] pre, int preL, int preR, int inL, TreeNode pParent ) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrder.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.parent = pParent;
        root.left = constructCore(pre, preL + 1, preL + leftTreeSize, inL, root);
        root.right = constructCore(pre, preL + leftTreeSize + 1, preR, inIndex + 1, root);
        return root;
    }

    //后序遍历
    public static void lastOutputTree(TreeNode root) {
        if (root == null)
            return;
        lastOutputTree(root.left);
        lastOutputTree(root.right);
        System.out.print(root.val + " ");

    }

}
