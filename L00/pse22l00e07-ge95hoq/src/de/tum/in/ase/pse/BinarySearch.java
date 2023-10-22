package de.tum.in.ase.pse;

import java.util.List;

public class BinarySearch implements SearchStrategy {

    public int performSearch(List<Chapter> book, String chapterToSearch) {
        int left = 0;
        int right = book.size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int compare = book.get(middle).getName().compareTo(chapterToSearch);
            if (compare == 0) {
                return book.get(middle).getPageNumber();
            } else if (compare < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
