package de.tum.in.ase.pse;

import java.util.List;

public interface SearchStrategy {
    int performSearch(List<Chapter> book, String chapterToSearch);
}
