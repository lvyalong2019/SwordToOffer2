package Chapter_04;

import com.sun.org.apache.xalan.internal.xsltc.dom.ClonedNodeListIterator;

class RandomListNode{
    int val;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int val) {
        this.val = val;
    }

}

public class Test35 {

    private static void cloneNodes(RandomListNode pHead) {
        RandomListNode pCurNode = pHead;
        while (pCurNode != null) {
            RandomListNode pCloned = new RandomListNode(pCurNode.val);
            pCloned.next = pCurNode.next;
            pCurNode.next = pCloned;
            pCurNode = pCloned.next;
        }
    }

    private static void connectRandomNodes(RandomListNode pHead) {
        RandomListNode pCurNode = pHead;
        RandomListNode pNextNode;
        while (pCurNode != null) {
            pNextNode = pCurNode.next;
            if (pCurNode.random != null)
                pNextNode.random = pCurNode.random.next;
            pCurNode = pNextNode.next;
        }
    }

    private static RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode pCurNode = pHead;
        RandomListNode pNextNode;
        RandomListNode pClonehead = pHead.next;
        while (pCurNode != null) {
            pNextNode = pCurNode.next;
            pCurNode.next = pNextNode.next;
            pCurNode = pCurNode.next;
            if (pCurNode != null)
                pNextNode.next = pCurNode.next;
        }
        return pClonehead;
    }

    public static RandomListNode clone1 (RandomListNode pHead) {
        if (pHead == null)
            return null;

        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }

}
