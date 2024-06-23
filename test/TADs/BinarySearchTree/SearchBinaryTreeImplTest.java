package TADs.BinarySearchTree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchBinaryTreeImplTest {

    private SearchBinaryTreeImpl<Integer> bst;

    @Before
    public void setUp() {
        bst = new SearchBinaryTreeImpl<>();
    }

    @Test
    public void testAddAndContains() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        assertTrue(bst.contains(5));
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(7));
        assertTrue(bst.contains(2));
        assertTrue(bst.contains(4));
        assertTrue(bst.contains(6));
        assertTrue(bst.contains(8));
        assertFalse(bst.contains(1));
        assertFalse(bst.contains(9));
    }

    @Test
    public void testFind() {
        bst.add(10);
        bst.add(5);
        bst.add(15);

        assertEquals(Integer.valueOf(10), bst.find(10));
        assertEquals(Integer.valueOf(5), bst.find(5));
        assertEquals(Integer.valueOf(15), bst.find(15));
        assertNull(bst.find(20));
    }

    @Test
    public void testRemove() {
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);

        bst.remove(5);
        assertFalse(bst.contains(5));
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(15));
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(7));
    }

    @Test
    public void testPreOrder() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        List<Integer> preOrder = bst.preOrder();
        Integer[] expected = {5, 3, 2, 4, 7, 6, 8};
        assertArrayEquals(expected, preOrder.toArray());
    }

    @Test
    public void testPosOrder() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        List<Integer> posOrder = bst.posOrder();
        Integer[] expected = {2, 4, 3, 6, 8, 7, 5};
        assertArrayEquals(expected, posOrder.toArray());
    }

    @Test
    public void testInOrder() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        List<Integer> inOrder = bst.inOrder();
        Integer[] expected = {2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expected, inOrder.toArray());
    }

    @Test
    public void testRangeSearch() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        List<Integer> rangeSearch = bst.rangeSearch(4, 7);
        Integer[] expected = {4, 5, 6, 7};
        assertArrayEquals(expected, rangeSearch.toArray());
    }
}
