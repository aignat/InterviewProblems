package interviewproblems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aignat on 05-Jul-16.
 */
public class StacksAndQueuesTest {

    StacksAndQueues<Integer> stacksAndQueues;

    @Before
    public void setUp() {
        stacksAndQueues = new StacksAndQueues<Integer>(Integer.class, 99);
    }

    @Test
    public void testPush1() throws Exception {
        stacksAndQueues.push1(3);
        stacksAndQueues.push1(4);
        stacksAndQueues.push1(5);

        assertTrue(stacksAndQueues.toString().contains("3 4 5 null"));
    }

    @Test
    public void testPop1() throws Exception {
        stacksAndQueues.push1(3);
        stacksAndQueues.push1(4);
        stacksAndQueues.push1(5);
        assertEquals(5, (int) stacksAndQueues.pop1());
        assertEquals(4, (int) stacksAndQueues.pop1());
        assertEquals(3, (int) stacksAndQueues.pop1());
        assertEquals(null, stacksAndQueues.pop1());
    }

    @Test
    public void testPop2() throws Exception {
        stacksAndQueues.push2(3);
        stacksAndQueues.push2(4);
        stacksAndQueues.push2(5);
        System.out.println(stacksAndQueues.toString());
        assertEquals(5, (int) stacksAndQueues.pop2());
        assertEquals(4, (int) stacksAndQueues.pop2());
        assertEquals(3, (int) stacksAndQueues.pop2());
        assertEquals(null, stacksAndQueues.pop2());
    }

}