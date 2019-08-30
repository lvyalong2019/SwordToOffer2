package Chapter_03;



public class Test22 {

    public static ListNode findKthFromTail(ListNode pHead, int k) {
        if (pHead == null || k == 0)
            return null;

        ListNode pPreNode = pHead;
        ListNode pNode = pHead;
        for (int i = 0; i< k -1; i++) {
            if (pNode.next != null)
                pNode = pNode.next;
            else
                return null;
        }

        while (pNode.next != null) {
            pPreNode = pPreNode.next;
            pNode = pNode.next;
        }
        return pPreNode;
    }

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

}
