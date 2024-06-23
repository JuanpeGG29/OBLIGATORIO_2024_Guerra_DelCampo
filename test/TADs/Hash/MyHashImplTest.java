package TADs.Hash;

import TADs.LinkedList.MyList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashImplTest {

    private MyHashImpl<String, Integer> hash;

    @Before
    public void setUp() {
        hash = new MyHashImpl<>();
    }

    @Test
    public void testPutAndGet() {
        hash.put("one", 1);
        hash.put("two", 2);
        hash.put("three", 3);

        assertEquals(Integer.valueOf(1), hash.get("one"));
        assertEquals(Integer.valueOf(2), hash.get("two"));
        assertEquals(Integer.valueOf(3), hash.get("three"));
    }

    @Test
    public void testContains() {
        hash.put("one", 1);
        hash.put("two", 2);

        assertTrue(hash.contains("one"));
        assertTrue(hash.contains("two"));
        assertFalse(hash.contains("three"));
    }

    @Test
    public void testRemove() {
        hash.put("one", 1);
        hash.put("two", 2);

        assertTrue(hash.contains("one"));
        hash.remove("one");
        assertFalse(hash.contains("one"));
    }

    @Test
    public void testKeys() {
        hash.put("one", 1);
        hash.put("two", 2);
        hash.put("three", 3);

        MyList<String> keys = hash.keys();
        assertTrue(keys.contains("one"));
        assertTrue(keys.contains("two"));
        assertTrue(keys.contains("three"));
    }

    @Test
    public void testValues() {
        hash.put("one", 1);
        hash.put("two", 2);
        hash.put("three", 3);

        MyList<Integer> values = hash.values();
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
        assertTrue(values.contains(3));
    }

    @Test
    public void testSize() {
        assertEquals(0, hash.size());
        hash.put("one", 1);
        assertEquals(1, hash.size());
        hash.put("two", 2);
        assertEquals(2, hash.size());
        hash.remove("one");
        assertEquals(1, hash.size());
    }
}
