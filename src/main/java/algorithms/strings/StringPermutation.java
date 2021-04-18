package algorithms.strings;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Write a method to compute all the permutations of a string of unique characters
 */
public class StringPermutation {

    public List<String> getAllPermutations(String word) {
        if (word == null) return null;
        return getAllPermutationsRecursively(word, word.length() - 1);
    }

    private List<String> getAllPermutationsRecursively(String word, int last) {
        if (last == 0) {
            return Collections.singletonList(word.substring(0, 1));
        }

        List<String> before = getAllPermutationsRecursively(word, last - 1);
        List<String> newOne = new LinkedList<>(); //TODO maybe it'd be better a LinkedList

        for (String s : before) {
            for (int i = 0; i <= s.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder(s);
                stringBuilder.insert(i, word.charAt(last));
                newOne.add(stringBuilder.toString());
            }
        }

        return newOne;
    }
}
