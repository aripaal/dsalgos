package search;

import java.util.*;

/**
 * Algorithm to find the Kth largest number or the Kth Smallest number
 * in an unsorted list
 */

public class QuickSelect<T extends Comparable<T>> {
    private List<T> unsortedList;

    public QuickSelect(List<T> unsortedList) {
        this.unsortedList = unsortedList;
    }

    private void swap(int indx1, int indx2) {
        T temp = unsortedList.get(indx1);
        unsortedList.set(indx1, unsortedList.get(indx2));
        unsortedList.set(indx2, temp);
    }

    private int getPivot(int first, int end) {
        int pivot = (first + end) / 2;
        //move actual pivot to end of the list
        swap(pivot, end);

        // compare with the pivot value
        for (int i = first; i < end; i++) {
            if (unsortedList.get(i).compareTo(unsortedList.get(end)) > 0) {
                swap(i, first);
                first++;
            }
        }
        //swap with the pivot value
        swap(first, end);
        return first;
    }

    private T select(int k, int start, int end) {
        int pivot = getPivot(start, end);
        if (k < pivot) {
            select(k, 0, pivot - 1);
        } else if (k > pivot) {
            select(k, pivot + 1, unsortedList.size() - 1);
        }

        return unsortedList.get(k);
    }

    public T select(int k) {
        return select(k - 1, 0, unsortedList.size() - 1);
    }
}
