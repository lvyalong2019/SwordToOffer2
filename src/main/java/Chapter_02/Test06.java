package Chapter_02;

/*从头到尾打印链表*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 解法：
 * 不改变链表：使用栈或者递归
 * 改变链表：使用头插法将链表中链接节点的指针反转过来，改变链表方向
 */

/**
 * 1 2 3
 */

/**
 * 链表构造函数的定义，链表的添加与删除，栈的使用
 * 链表的空指针无法调用，添加链表需要先创建新的非空节点
 * 若创建空节点，再去使用它，则会出现空指针异常
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}

public class Test06 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        if (str1==null){
            System.out.println("输入数据为空");
            System.exit(0);
        }
        String [] str2 = str1.split(" ");
        int length = str2.length;

        ListNode head = new ListNode(0);
        ListNode listNode = new ListNode(0);
        listNode = head;
        for (int i = 0; i < length;i++) {
            listNode.next = new ListNode(Integer.valueOf(str2[i]));
            listNode = listNode.next;
        }

        listNode = head.next;
        ArrayList<Integer> str3 = new ArrayList<>();

//        str3 = PrintListReversingly_Iteratively(listNode);
//        str3 = PrintListReversingly_Recursively(listNode);
//        str3 = PrintListReversingly_Reversal(listNode);

//        System.out.println(str3);

        ListNode p = head.next;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }

    }

    /*使用栈，时间复杂度O（n）,空间复杂度O（n）*/
    public static ArrayList<Integer> PrintListReversingly_Iteratively(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /*使用递归，复杂度同上*/
    public static ArrayList<Integer> PrintListReversingly_Recursively(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            arrayList.addAll(PrintListReversingly_Recursively(listNode.next));
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /*使用头插法将链表反转，时间复杂度O（n），空间复杂度O（1）*/
    public static ArrayList<Integer> PrintListReversingly_Reversal(ListNode listNode) {
//        反转链表
        ListNode head = new ListNode(0);
        ListNode temp = new ListNode(0);
        while (listNode != null) {
            temp = listNode.next;
            listNode.next = head.next;
            head.next =listNode;
            listNode = temp;
        }

//        将链表保存到ArrayList对象中
        ArrayList<Integer> ret = new ArrayList<>();
        temp = head.next;
        while (temp != null){
            ret.add(Integer.valueOf(temp.val));
            temp =temp.next;
        }

        return ret;
    }

}
