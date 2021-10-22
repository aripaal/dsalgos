package search;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class BinarySearchTest {
    Integer[] sorted = {1, 2, 3, 5, 7, 10, 14, 34, 40};

    @Test
    public void findIndexOf() throws Exception {
        BinarySearch search = new BinarySearch();
        assertTrue(search.search(Arrays.asList(sorted), 5) == 3);
        assertTrue(search.search(Arrays.asList(sorted), 1) == 0);
        assertTrue(search.search(Arrays.asList(sorted), 3) == 2);
        assertTrue(search.search(Arrays.asList(sorted), 34) == 7);


    }
}