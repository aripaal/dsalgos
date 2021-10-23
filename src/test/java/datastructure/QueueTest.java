package datastructure;

import org.junit.*;

import static org.junit.Assert.*;

public class QueueTest {
    Queue<Integer> queue = new Queue<>();

    @Test
    public void testQueue() {
        queue.offer(1);
        queue.offer(5);
        queue.offer(7);
        queue.offer(9);
        queue.offer(10);

        Assert.assertTrue(queue.size() == 5);
        Assert.assertTrue(queue.poll() == 1);
        Assert.assertTrue(queue.size() == 4);

    }
}