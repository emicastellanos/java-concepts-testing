package algorithms.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may not use the same element index twice. You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

public class SumElementsFinder {

    private final int TOTAL_INDEXES = 2;

    public Optional<Pair> getElements(int[] nums, int target) {
        if (nums.length < TOTAL_INDEXES) return Optional.empty();

        HashMap<Integer, Integer> valuePosition = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer secondValue = valuePosition.get(target - nums[i]);
            //if valuePosition.containsKey()
            if (secondValue == null) {
                valuePosition.put(nums[i], i);
            } else {
                return Optional.of(new Pair(i, secondValue));
            }
        }
        return Optional.empty();
    }
}

final class Pair {
    private final int val1;
    private final int val2;

    public Pair(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public int getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return getVal1() == pair.getVal1() &&
                getVal2() == pair.getVal2() ||
                getVal1() == pair.getVal2() &&
                        getVal2() == pair.getVal1();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal1(), getVal2());
    }
}
