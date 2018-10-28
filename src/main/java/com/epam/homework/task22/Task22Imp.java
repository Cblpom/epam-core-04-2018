package com.epam.homework.task22;

import java.util.*;

public class Task22Imp implements Task22 {
    @Override
    public List<String> sortPoems(Set<IPoem> poems, String author) {

        List<String> linesOfPoems = new ArrayList<>();

        for (IPoem poem: poems) {
            if (poem.getAuthor().equals(author)) {
                linesOfPoems.addAll(poem.getLines());
            }
        }

        Collections.sort(linesOfPoems);

        return linesOfPoems;
    }



}
