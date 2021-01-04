package algorithms.arrays;

import java.util.HashSet;
import java.util.Set;

public class CandiesDistributor {

    public int getMaxNumberOfDiffTypesOfCandies(int[] candyType, int maxCandiesAllowed) {
        if (candyType.length == 0) return 0;

        Set<Integer> diffTypes = new HashSet<>();
        for (int i : candyType) {
            diffTypes.add(i);
            if (maxCandiesAllowed < diffTypes.size()) {
                return maxCandiesAllowed;
            }
        }

        return maxCandiesAllowed < diffTypes.size() ?
                maxCandiesAllowed
                : diffTypes.size();
    }
}
