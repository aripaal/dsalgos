package search;

import java.util.*;

/**
 * Create two list and add them based on comparison of a pivot
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> {

    public List<T> sort(List<T> unsorted) {
        if (unsorted.size() < 2)
            return unsorted;
        T pivot = unsorted.get(0);

        List<T> lessThanPivot = new LinkedList<>();
        List<T> greaterThanPivot = new LinkedList<>();

        for (int i = 1; i < unsorted.size(); i++) {
            T value = unsorted.get(i);
            if (value.compareTo(pivot) < 0)
                lessThanPivot.add(value);
            else
                greaterThanPivot.add(value);
        }
        List<T> sorted = new LinkedList<>();
        sorted.addAll(sort(lessThanPivot));
        sorted.add(pivot);
        sorted.addAll(sort(greaterThanPivot));
        return sorted;
    }
}
