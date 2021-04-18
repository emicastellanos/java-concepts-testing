package algorithms.numbers;

/**
 * Given an array A[] of size n, you need to find the maximum and minimum element present in the array.
 * Your algorithm should make the minimum number of comparisons.
 */
public class MinMaxFinder {

    public class MinMax {
        int min;
        int max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public MinMax() {
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

    public MinMax getMinAndMax(int[] numbers) {
        if (numbers == null) return null;
        return calculateMinMaxRecursively(numbers, 0, numbers.length - 1);
    }

    //Time complexity = O(n)
    //Space complexity = O(log n) due to recursion.
    private MinMax calculateMinMaxRecursively(int[] numbers, int init, int end) {
        if (end == init) {
            return new MinMax(numbers[init], numbers[end]);
        }
        if (init + 1 == end) {
            int min = Math.min(numbers[init], numbers[end]);
            int max = Math.max(numbers[init], numbers[end]);
            return new MinMax(min, max);
        }
        int half = init + (end - init) / 2;
        MinMax leftHalf = calculateMinMaxRecursively(numbers, init, half);
        MinMax rightHalf = calculateMinMaxRecursively(numbers, half + 1, end);

        int min = Math.min(leftHalf.getMin(), rightHalf.getMin());
        int max = Math.max(leftHalf.getMax(), rightHalf.getMax());

        return new MinMax(min, max);
    }

}
