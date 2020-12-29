package algorithms.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of unique characters arr and a String str,
 * return the smallest substring of str which will contain all the characters in arr.
 * Return "" (empty string) if such a substring doesn't exist
 */
public class SmallestSubstring {
    private static final String EMPTY_STRING = "";

    public static String getShortestUniqueSubstring(char[] arr, String str) {
        if (str.length() == 0) return EMPTY_STRING;

        HashMap<Character, Integer> repetitions = initializeCharsRepetition(arr);
        int init = 0;
        int end = 0;
        String solution = "";
        while (end < str.length()) {
            //iterate counting every usage of accepted characters
            //find first possible end.
            //move init position 'til find the minimum for that end found.
            //mark as solution -> solution = str.substring(init, end) if it's possible
            // init = end
            // repeat
            if (repetitions.keySet().contains(str.charAt(end))) {
                repetitions.put(str.charAt(end), repetitions.get(str.charAt(end)) + 1);
            }

            end++;

            while (allUsed(repetitions)) { //if entry here it means a possible solution was found
                //now is needed to reduce the window to its minimum.
                char charAtInit = str.charAt(init);
                if (repetitions.keySet().contains(charAtInit)) {
                    if (repetitions.get(charAtInit) > 1) {
                        repetitions.put(charAtInit, repetitions.get(charAtInit) - 1);
                    } else if (repetitions.get(charAtInit) == 1) { //here the minimal of the possible solution is found
                        if (solution.length() == 0 || end - init < solution.length()) {
                            solution = str.substring(init, end);
                            repetitions.put(charAtInit, repetitions.get(charAtInit) - 1);
                            System.out.println(String.format("one possible solution was found: %s", solution));
                        }
                    }
                }
                init++;
            }


        }

        return solution;
    }


    private static boolean allUsed(HashMap<Character, Integer> map) {
        return map.values().stream()
                .allMatch(integer -> integer > 0);
    }

    private static boolean isPresent(Map<Character, Integer> map, char c) {
        return map.keySet().contains(c);
    }

    private static boolean isPresent(char[] arr, char i) {
        for (char c : arr) {
            if (c == i) return true;
        }
        return false;
    }

    private static HashMap<Character, Integer> initializeCharsRepetition(char[] arr) {
        HashMap<Character, Integer> toReturn = new HashMap<>();
        for (char c : arr) {
            toReturn.put(c, 0);
        }
        return toReturn;
    }
}
