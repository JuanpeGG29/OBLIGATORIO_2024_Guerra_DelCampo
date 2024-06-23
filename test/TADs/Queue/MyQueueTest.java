package TADs.Queue;

import TADs.Queue.exceptions.EmptyQueueException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    private MyQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new MyQueueImpl<>();
    }

    @Test
    public void testEnqueueAndDequeue() throws EmptyQueueException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
    }

    @Test(expected = EmptyQueueException.class)
    public void testDequeueEmptyQueue() throws EmptyQueueException {
        queue.dequeue();
    }

    @Test
    public void testContains() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertTrue(queue.contains(1));
        assertTrue(queue.contains(2));
        assertFalse(queue.contains(3));
    }

    @Test
    public void testGet() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.get(0));
        assertEquals(Integer.valueOf(2), queue.get(1));
        assertEquals(Integer.valueOf(3), queue.get(2));
    }

    @Test
    public void testSize() throws EmptyQueueException {
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        queue.enqueue(2);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    public void testIsEmpty() throws EmptyQueueException {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}
