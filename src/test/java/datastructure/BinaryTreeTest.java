package datastructure;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class BinaryTreeTest {
    BinaryTree<Integer> tree;
    Integer[] inputValues, arr2, balanced, expectedInOrder, expectedPreOrder, expectedLevelOrder;

    @Before
    public void setUp() {
        tree = new BinaryTree<>();
        inputValues = new Integer[]{1, 4, 5, 2, 1};
        balanced = new Integer[]{4, 1, 5};
        expectedInOrder = new Integer[]{1, 1, 2, 4, 5};
        expectedPreOrder = new Integer[]{1, 4, 2, 1, 5};

        for (Integer v : inputValues) {
            tree.add(v);
        }
    }

    @Test
    public void testInorder() {

        List<Integer> output = new LinkedList<>();
        tree.inOrder(output);
        assertArrayEquals(output.toArray(), expectedInOrder);
        System.out.println(output);
    }

    @Test
    public void testPreorder() {
        List<Integer> output = new LinkedList<>();
        tree.preOrder(output);
        assertArrayEquals(output.toArray(), expectedPreOrder);
        System.out.println(output);
    }

    @Test
    public void calcSize(){
        int size = tree.calcSize();
        Assert.assertTrue(size == 5);
    }

    @Test
    public void calcHeight(){
        int height = tree.height();
        Assert.assertTrue(height == 4);
    }

}