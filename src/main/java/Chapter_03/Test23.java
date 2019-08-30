package Chapter_03;

/**
 * 链表中环的入口节点
 * 1、根据环的长度，确定入口
 * 2、找到环中某一点，一步两步，似魔鬼的步伐，确定环的节点数
 * 3、确定是否有环路，可以与第二步前半部一起
 *
 * 测试：
 * 功能测试
 * 边界测试：一个节点
 * 异常测试：无环、链表为空，头节点为空
 */

public class Test23 {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;

        ListNode pMeetingNode = meetingNode(pHead);
        if (pMeetingNode == null)
            return null;

        ListNode pFast = pHead;
        ListNode pSlow = pMeetingNode;
        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }

        return pFast;

    }

    public static ListNode findEntryNode(ListNode pHead) {
        if (pHead == null )
            return null;

        ListNode pMeetingNode = meetingNode(pHead);
        if (pMeetingNode == null)
            return null;

        ListNode pLoopLengthNode = pMeetingNode;
        int length = 1;
        while (pLoopLengthNode.next != pMeetingNode) {
            pLoopLengthNode = pLoopLengthNode.next;
            length++;
        }

        ListNode pFast = pHead;
        ListNode pSlow = pHead;
        for (int i = 0; i < length; i++)
            pFast = pFast.next;

        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }

        return pFast;
    }

    public static ListNode meetingNode(ListNode pHead) {
        if (pHead == null)
            return null;

        ListNode pFast = pHead;
        ListNode pSlow = pHead;

        while (pFast != null) {
            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
            pSlow = pSlow.next;
            if (pFast == pSlow)
                return pFast;
        }
        return null;
    }

}
