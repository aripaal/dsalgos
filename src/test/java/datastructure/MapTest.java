package datastructure;

import org.junit.*;

import static org.junit.Assert.*;

public class MapTest {
    @Test
    public void testMap() {
        Map<Integer, String> map = new Map<>();
        map.put(1, "apple");
        map.put(2, "orange");
        map.put(7, "mahogany");
        map.put(4, "strawberry");
        Assert.assertTrue(map.put(2, "banana").equals("orange"));

        Assert.assertTrue(map.get(7).equals("mahogany"));

    }

}