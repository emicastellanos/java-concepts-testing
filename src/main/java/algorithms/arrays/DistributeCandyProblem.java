package algorithms.arrays;

import java.util.*;

/**
 * There are N children standing in a line with some rating value.
 * You want to distribute a minimum number of candies to these children such that:
 * - Each child must have at least one candy.
 * - The children with higher ratings will have more candies than their neighbours.
 * <p>
 * You need to write a program to calculate the minimum candies you must give.
 * <p>
 * good to ask: what is a definition of neighbour ?
 */
public class DistributeCandyProblem {

    public static int[] getMinimumCandies(int[] children) {
        int[] result = new int[children.length];

        for (int i = 0; i < children.length; i++) {
            result[i] = 1;
        }

        SortedMap<Integer, List<Integer>> prioritization = getMapPrioritized(children);
        int iteration = 0;
        for(Integer rating : prioritization.keySet()){
            if (iteration != 0){
                for (Integer i : prioritization.get(rating)) {
                    if(i != 0 && i != children.length-1){
                        if (children[i] > children[i + 1] && children[i] > children[i - 1]) {
                            result[i] = Math.max(result[i + 1], result[i - 1]) + 1;
                        } else if (children[i] > children[i - 1]) {
                            result[i] = result[i - 1] + 1;
                        } else {
                            result[i] = result[i + 1] + 1;
                        }
                    }
                }
            }
            iteration++;
        }

        if (children.length > 1) {
            if (children[children.length - 1] > children[children.length - 2]) {
                result[children.length - 1] = result[children.length - 2] + 1;
            }
            if (children[0] > children[1]) {
                result[0] = result[1] + 1;
            }
        }

        return result;
    }

    private static SortedMap<Integer, List<Integer>> getMapPrioritized(int[] children) {
        SortedMap<Integer, List<Integer>> prioritization = new TreeMap<>();
        for (int i = 0; i < children.length; i++) {
            if (!prioritization.containsKey(children[i])){
                prioritization.put(children[i], new LinkedList<>());
            }
            prioritization.get(children[i]).add(i);
        }
        System.out.println(prioritization);
        return prioritization;
    }
}
