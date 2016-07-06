package interviewproblems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by aignat on 23-Jun-16.
 */
public class QueueTest {

    Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new Queue<Integer>();
    }

    @Test
    public void testEnqueue() throws Exception {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals("dequeue <-- | 1 2 3 | <-- enqueue", queue.toString());
    }

    @Test
    public void testDequeue() throws Exception {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(new Integer(1), new Integer(3));
        assertEquals(new Integer(2), queue.dequeue().value);
        assertEquals("dequeue <-- | 3 | <-- enqueue", queue.toString());
    }

}