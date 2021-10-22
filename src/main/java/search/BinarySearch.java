package search;

import java.util.*;

public class BinarySearch {

    public int search(List<Integer> sorted, int value) {
        int indx = sorted.size() / 2;
        if (value < sorted.get(indx))
            return search(sorted.subList(0, indx), value);
        if (value > sorted.get(indx))
            return indx + search(sorted.subList(indx, sorted.size()), value);
        return indx;
    }
}
