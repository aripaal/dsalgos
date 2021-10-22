package sorting;

import java.util.*;

/**
 * insert smaller values at the beginning via comparison or at the very end
 */
public class InsertionSort<T extends Comparable<T>> {

    public List<T> sort(List<T> unsorted) {
        List<T> sorted = new LinkedList<>();
        loop:
        for (int i = 0; i < unsorted.size(); i++) {
            for (int j = 0; j < sorted.size(); j++) {
                if (unsorted.get(i).compareTo(sorted.get(j)) < 0) {
                    sorted.add(j, unsorted.get(i));
                    continue loop;
                }
            }
            sorted.add(sorted.size(), unsorted.get(i));
        }
        return sorted;
    }
}
