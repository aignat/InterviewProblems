package interviewproblems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aignat on 23-Jun-16.
 */
public class StackTest {

    Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<Integer>();
    }

    @Test
    public void testPop() throws Exception {
        assertEquals(null, stack.pop());
    }

    @Test
    public void testPush() throws Exception {
        stack.push(1);
        stack.push(2);

        assertEquals(1, stack.pop().value);
        assertEquals(2, stack.pop().value);

    }

}