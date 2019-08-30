package fundamental;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinklistTest {
    @Test
    public void buildLinklist() throws Exception {

        int[] array = {1,2,3,4};
        ListNode pHead = Linklist.buildLinklist2(array);

        while (pHead != null){
            System.out.print(pHead.val + " ");
            pHead = pHead.next;
        }

    }

}