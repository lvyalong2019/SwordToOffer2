package fundamental;

class ListNode {
    int val;
    ListNode next = null;
    ListNode (int val) {
        this.val = val;
    }
}

public class Linklist {

    public static ListNode buildLinklist(int[] array) {
        int length = array.length;
        if (array == null || length == 0)
            return null;

        ListNode pHead = new ListNode(0);
        ListNode pNode = new ListNode(0);
        for (int i = length - 1; i >= 0; i--) {
            pNode = new ListNode(array[i]);
            pNode.next = pHead.next;
            pHead.next = pNode;
        }
//        pHead = pHead.next;

        pHead = pHead.next;
//        while (temp != null){
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
        return pHead;
    }

    public static ListNode buildLinklist2(int[] array) {
        int length = array.length;
        if (array == null || length == 0)
            return null;

        ListNode pHead = null;
        for (int i = length - 1; i >= 0; i--) {
            ListNode pNode = new ListNode(array[i]);
            pNode.next = pHead;
            pHead = pNode;
        }

        return pHead;

    }

}
