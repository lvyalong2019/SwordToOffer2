package Chapter_04;

import java.util.ArrayList;

/**
 * 序列化二叉树
 */

public class Test37 {

    //序列化
    public static String serialize(TreeNode pHead) {
        if (pHead == null)
            return "#" + " ";

        String str = String.valueOf(pHead.val) + " ";
        str = str + serialize(pHead.left);
        str = str + serialize(pHead.right);
        return str;
    }

    //反序列化
    private static String strTemp;
    private static TreeNode pHeadSave;
    public static TreeNode deserialize(String str) {
        TreeNode pHead = null;
        if (str.isEmpty())
            return null;
        strTemp = str;
        deserializeCore(pHead);
        //由于下面每次pHead都new了，多以需要用一个节点保存跟节点的位置
        return pHeadSave;
    }

    private static void deserializeCore(TreeNode pHead) {
        int index = strTemp.indexOf(" ");
        String node;
        if (index != -1) {
            node = strTemp.substring(0, index);
            strTemp = strTemp.substring(index+1);
        }else return;

        //字符串使用equal
        if (!node.equals("#")) {
            pHead = new TreeNode(Integer.valueOf(node));
            if (pHeadSave == null)
                pHeadSave = pHead;
            pHead.left = null;
            pHead.right = null;
        }else return;

        deserializeCore(pHead.left);
        deserializeCore(pHead.right);
    }

}
