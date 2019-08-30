package Chapter_03;

public class Test24 {

    //直接反转
    public ListNode reverseList(ListNode pHead) {
        ListNode pNode = pHead;
        ListNode pPre = null;

        while (pNode != null) {
            ListNode pNext = pNode.next;
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }

        ListNode pReversedHead = pPre;
        return pReversedHead;
    }

    //头插法
    public ListNode reverseList2(ListNode pHead) {
        ListNode newList = new ListNode(-1);
        ListNode pNode = pHead;

        while (pNode != null) {
            ListNode pNext = pNode.next;
            pNode.next = newList.next;
            newList.next = pNode;
            pNode = pNext;
        }

        return newList.next;
    }

    //递归
    public ListNode reverseList3(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode pNext = pHead.next;
        ListNode newHead = reverseList3(pNext);
        pHead.next = null;
        pNext.next = pHead;
        return newHead;

    }

}
