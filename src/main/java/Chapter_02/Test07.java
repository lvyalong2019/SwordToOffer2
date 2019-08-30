package Chapter_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 重建二叉树：
 * 给定二叉树前序遍历和中序遍历，构建二叉树
 * 解法：
 * 1、根据前序遍历确定根节点，找到中序遍历根节点（使用哈希表能快速找到根节点所在位置，消耗内存换取时间（测试感觉没差））
 * 2、中序遍历根节点左边为左子树（长度为leftLength），右边为右子树（长度为rightLength）
 * 3、前序遍历中，根节点之后的leftLength长度为前序遍历左子树，左子树之后为右子树
 * 4、将左右子树分别进行1、2、3步（需要传入参数为两种遍历的子树的起始点，左右子树分别都有四个参数）
 * 测试：
 * 1、正常（1 2 4 7 3 5 6 8）（4 7 2 1 5 3 8 6）
 */

/**
 * 总结：花费将近4个小时学习了二叉树的递归与其基本操作
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(){

    }
}

public class Test07 {

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
//        System.out.println();

//        if (root != null) {
//            System.out.println(root.val);
//            root
//        }

//        System.out.print(root.val+ " " +root.left.val + " " +root.left.left.val + " " + root.left.left.right.val);

//        for (int i :a)
//            System.out.print(i + " ");
//        System.out.println();
//        for (int i :b)
//            System.out.print(i + " ");
    }

//    第一种方法
    private static Map<Integer,Integer> indexForInOrder = new HashMap<>();

    public static TreeNode construct(int[] pre,int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrder.put(in[i], i);
        }
        return constructCore(pre, 0, pre.length - 1, 0);
    }

    public static TreeNode constructCore(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrder.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = constructCore(pre, preL + 1, preL+leftTreeSize, inL);
        root.right = constructCore(pre, preL + leftTreeSize + 1, preR, inIndex + 1);
        return root;
    }

//    第二种方法

    public static TreeNode construct2(int[] pre, int[] in) {
        return constructCore2(pre, in, 0, pre.length - 1, 0);
    }
    public static TreeNode constructCore2(int[] pre, int[] in, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        int inIndex = -1;
        TreeNode root = new TreeNode(pre[preL]);
        for (int i = 0; i < in.length; i++){
            if (in[i] == root.val){
                inIndex = i;
                break;
            }
        }
        int leftTreeSize = inIndex - inL;
        root.left = constructCore2(pre, in, preL + 1, preL+leftTreeSize, inL);
        root.right = constructCore2(pre, in, preL + leftTreeSize + 1, preR, inIndex + 1);
        return root;
    }

    //前序遍历
    public static void preOutputTree(TreeNode root) {
        if (root != null){
            System.out.print(root.val + " ");
            preOutputTree(root.left);
            preOutputTree(root.right);
        }
    }

    //中序遍历
    public static void inOutputTree(TreeNode root) {
        if (root != null){
            inOutputTree(root.left);
            System.out.print(root.val + " ");
            inOutputTree(root.right);
        }
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
