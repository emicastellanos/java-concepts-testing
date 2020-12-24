package algorithms.strings;

import java.util.Arrays;

public class CheckPermutation {
    private static final int ASCII_SIZE = 128;

    //given two strings, decide if one is a permutation of the other
    public static boolean arePermutationOfEachOther(String source, String target) {
        if (source.length() != target.length()) return false;

        String sortedSource = getSortedString(source);
        String sortedTarget = getSortedString(target);

        return sortedSource.equals(sortedTarget);
    }

    private static String getSortedString(String source) {
        char[] sourceArray = source.toCharArray();
        Arrays.sort(sourceArray);
        return new String(sourceArray);
    }

    //This one checks if two string have identical character counts
    public static boolean arePermutationOfEachOtherBetterPerformance(String source, String target) {
        if (source == null || target == null || source.length() != target.length()) return false;

        //assumption: strings are ASCII
        int[] charsCounting = new int[ASCII_SIZE];
        for(int c : source.toCharArray()){
            charsCounting[c]++;
        }

        for(int c: target.toCharArray()){
            charsCounting[c]--;
            if(charsCounting[c] < 0) return false;
        }

        return true;
        //return allZero(charsCounting);
        //we don't need to walk trough all the array bc when any turns less than zero it means it is not present
        //in the compared string.
    }

    private static boolean allZero(int[] array){
        for (int i: array){
            if (array[i] != 0) return false;
        }
        return true;
    }
}
