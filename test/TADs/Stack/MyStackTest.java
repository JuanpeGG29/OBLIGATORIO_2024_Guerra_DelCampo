package TADs.Stack;

import TADs.Stack.exceptions.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

    private MyStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new MyStackImpl<>();
    }

    @Test
    public void testPushAndPop() throws EmptyStackException {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopEmptyStack() throws EmptyStackException {
        stack.pop();
    }

    @Test
    public void testPeek() throws EmptyStackException {
        stack.push(1);
        stack.push(2);

        assertEquals(Integer.valueOf(2), stack.peek());
        stack.pop();
        assertEquals(Integer.valueOf(1), stack.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekEmptyStack() throws EmptyStackException {
        stack.peek();
    }

    @Test
    public void testSize() throws EmptyStackException {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void testIsEmpty() throws EmptyStackException {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}
