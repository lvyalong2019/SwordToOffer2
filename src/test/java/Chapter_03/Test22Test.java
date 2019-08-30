package Chapter_03;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test22Test {
    @Test
    public void findKthFromTail() throws Exception {
        int[] array = {1,2,3,4,5};
        ListNode pHead = Test22.buildLinklist(array);
        assertEquals(4,Test22.findKthFromTail(pHead,2).val);
    }

}