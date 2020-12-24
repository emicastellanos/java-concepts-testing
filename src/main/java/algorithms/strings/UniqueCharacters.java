package algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacters {

    public static boolean hasUniqueCharacters(String word) {
        Set<Character> receiptOfCharacters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (receiptOfCharacters.contains(word.charAt(i))) {
                return false;
            }
            receiptOfCharacters.add(word.charAt(i));
        }
        return true;
    }

    public static boolean hasUniqueCharactersNoAuxiliaryStructure(String word) {
        for (int i = 0; i < word.length(); i++) {
            char targetChar = word.charAt(i);
            if (charExists(word.substring(i + 1, word.length()), targetChar)) {
                return false;
            }
        }
        return true;
    }

    private static boolean charExists(String subWord, char character) {
        for (int i = 0; i < subWord.length(); i++)
            if (subWord.charAt(i) == character) return true;
        return false;
    }

    public static boolean hasUniqueCharactersBestPerformance(String word) {
        if (word.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int value = word.charAt(i);

            if (char_set[value]) return false;
            char_set[value] = true;
        }
        return true;
    }
}
