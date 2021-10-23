package datastructure;

import org.junit.*;

import static org.junit.Assert.*;

public class StackTest {

    Stack stack = new Stack();

    @Test
    public void testStack() {
        Assert.assertTrue(stack.pop() == null);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        Assert.assertTrue(stack.size() == 3);
        Assert.assertTrue(stack.pop() == 4);
        Assert.assertTrue(stack.size() == 2);
    }
}