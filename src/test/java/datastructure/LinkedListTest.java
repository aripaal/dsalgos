package datastructure;

import org.junit.*;

import static org.junit.Assert.*;

public class LinkedListTest {
    LinkedList<String> fruits = new LinkedList<>();

    @Test
    public void addRemoveTest() {
        fruits.addNode("banana");
        fruits.addNode("apple");
        fruits.addNode("orange");
        fruits.addNode("avocado");
        fruits.addNode("pineapple");
        System.out.println(fruits.print());
        Assert.assertTrue(fruits.size() == 5);

        fruits.remove("banana");
        Assert.assertTrue(fruits.size() == 4);

        fruits.remove("pineapple");
        Assert.assertTrue(fruits.size() == 3);

        fruits.remove("orange");
        Assert.assertTrue(fruits.size() == 2);
    }

}