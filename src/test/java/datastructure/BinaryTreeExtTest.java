package datastructure;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class BinaryTreeExtTest {
    BinaryTreeExt<Integer> tree;
    Integer[] inputValues, arr2, balanced, expectedInOrder, expectedPreOrder, expectedLevelOrder;

    @Before
    public void setUp() {
        tree = new BinaryTreeExt<>();
        inputValues = new Integer[]{1, 4, 5, 2, 1};
        arr2 = new Integer[]{13, 9, 20, 15, 7};
        balanced = new Integer[]{4, 1, 5};
        expectedInOrder = new Integer[]{1, 1, 2, 4, 5};
        expectedPreOrder = new Integer[]{1, 4, 2, 1, 5};
        expectedLevelOrder = new Integer[]{1, 4, 2, 5, 1};

        for (Integer v : inputValues) {
            tree.add(v);
        }
    }

    @Test
    public void testPreorder() {
        java.util.List<Integer> output = new java.util.LinkedList<>();
        tree.preOrder(output);
        assertArrayEquals(output.toArray(), expectedPreOrder);
        System.out.println(output);
    }
    @Test
    public void testInorder() {
        java.util.List<Integer> output = new java.util.LinkedList<>();
        tree.inOrder(output);
        assertArrayEquals(output.toArray(), expectedInOrder);
        System.out.println(output);
    }
    @Test
    public void testLevelorder() {
        java.util.List<Integer> output = new java.util.LinkedList<>();
        tree.levelOrder(output);
        assertArrayEquals(output.toArray(), expectedLevelOrder);
        System.out.println(output);
    }

}