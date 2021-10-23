package search;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class QuickSelectTest {

    @Test
    public void getKthLargestNumber() throws Exception {
        QuickSelect<Integer> select = new QuickSelect<>(Arrays.asList(1, -2, 5, 8, 7, 6));
        //Get 2nd largest number
        Assert.assertTrue(select.select(2) == 7);
        //Get 3rd largest number
        Assert.assertTrue(select.select(3) == 6);

    }

}