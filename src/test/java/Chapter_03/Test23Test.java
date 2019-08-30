package Chapter_03;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test23Test {
    @Test
    public void findEntryNode() throws Exception {

        ListNode pHead = new ListNode(0);
        ListNode pNode = new ListNode(1);
        pHead.next = pNode;
        pNode.next = pNode;

        assertEquals(1,Test23.findEntryNode(pHead));

    }

}