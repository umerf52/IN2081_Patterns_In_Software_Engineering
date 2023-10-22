package de.tum.in.ase.pse;

import java.util.List;

public class LinearSearch implements SearchStrategy {

        public int performSearch(List<Chapter> book, String chapterToSearch) {
            for (Chapter chapter : book) {
                if (chapter.getName().equals(chapterToSearch)) {
                    return chapter.getPageNumber();
                }
            }
            return -1;
        }
}
