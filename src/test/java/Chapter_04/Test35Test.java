package Chapter_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test35Test {
    @Test
    public void clone1() throws Exception {

        RandomListNode pRoot = new RandomListNode(1);
        RandomListNode pNode = Test35.clone1(pRoot);
        System.out.println(pNode.val);

    }

}