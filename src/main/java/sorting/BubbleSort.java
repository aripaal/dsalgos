package sorting;

import java.util.*;
/*
Compare values till all are sorted in a while loop
* */
public class BubbleSort<T extends Comparable<T>> {

    public List<T> sort(List<T> unsorted) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < unsorted.size() - 1; i++) {
                if (unsorted.get(i).compareTo(unsorted.get(i + 1)) > 0) {
                    T temp = unsorted.get(i);
                    unsorted.set(i, unsorted.get(i + 1));
                    unsorted.set(i + 1, temp);
                    isSorted = false;
                }
            }
        }
        return unsorted;
    }

}
