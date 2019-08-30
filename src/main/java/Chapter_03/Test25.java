package Chapter_03;

/**
 * 合并递增链表
 */

public class Test25 {

    //递归
    public ListNode merge(ListNode pHead1,ListNode pHead2) {
        if (pHead1 == null)
            return pHead2;
        if (pHead2 == null)
            return pHead1;

        ListNode pMerge = null;

        if (pHead1.val < pHead2.val) {
            pMerge = pHead1;
            pMerge.next = merge(pHead1.next,pHead2);
        }else {
            pMerge = pHead2;
            pMerge.next = merge(pHead1,pHead2.next);
        }
        return pMerge;
    }

    //迭代
    public ListNode merge2(ListNode pHead1,ListNode pHead2) {
        if (pHead1 == null)
            return pHead2;
        if (pHead2 == null)
            return pHead1;

        ListNode pHead = new ListNode(-1);
        ListNode pPre = pHead;

        while (pHead1 != null && pHead2 != null) {

            if (pHead1.val <= pHead2.val) {
                pPre.next = pHead1;
                pHead1 = pHead1.next;
            }else {
                pPre.next = pHead2;
                pHead2 = pHead2.next;
            }
            pPre = pPre.next;

        }

        if (pHead1 == null)
            pPre.next = pHead2;
        else
            pPre.next = pHead1;

        return pHead.next;
    }
}
