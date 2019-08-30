package Chapter_03;

/**
 * 删除排序链表中的重复数字
 */

public class Test18Q2 {

    public ListNode deleteDuplication_recursively(ListNode pHead) {
        if (pHead == null || pHead.next ==null)
            return pHead;

        ListNode pNext = pHead.next;
        if (pNext.val == pHead.val) {
//            pNext = pNext.next;
            while (pNext != null && pHead.val == pNext.val){
                pNext = pNext.next;
            }
            return deleteDuplication_recursively(pNext);
        }else {
            pHead.next = deleteDuplication_recursively(pHead.next);
            return pHead;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;

        ListNode pNode = pHead;
        ListNode pPreNode = null;
        while (pNode != null) {
            if (pNode.next != null && pNode.val == pNode.next.val) {
                int val = pNode.val;
                while (pNode != null && pNode.val ==val) {
                    pNode = pNode.next;
                }
                if (pPreNode != null)
                    pPreNode.next = pNode;
                else pHead = pNode;

            }else {
                pPreNode = pNode;
                pNode = pNode.next;
            }
        }
        return pHead;
    }

}