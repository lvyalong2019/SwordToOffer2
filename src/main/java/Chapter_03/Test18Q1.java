package Chapter_03;

/**
 * 在O（1）时间内删除链表节点
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode (int val) {
        this.val = val;
    }
}

public class Test18Q1 {

    public static void deleteNode(ListNode pHead, ListNode pToBeDeleted) {
        if (pHead == null || pToBeDeleted == null) {
//            System.out.println("无效的输入");
            return;
        }

        if (pToBeDeleted.next != null) {
            ListNode next = pToBeDeleted.next;
            pToBeDeleted.next = next.next;
            pToBeDeleted.val = next.val;
        } else if (pToBeDeleted == pHead) {
            pHead = null;
        } else {
            ListNode node = pHead;
            while (node.next != pToBeDeleted)
                node = node.next;
            node.next = null;
        }
    }

}
