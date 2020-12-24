package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckPermutationTest {

    @Test
    public void arePermutationOfEachOther() {
        assertTrue(CheckPermutation.arePermutationOfEachOther("asd", "das"));
        assertFalse(CheckPermutation.arePermutationOfEachOther("asdd", "asd"));
    }

    @Test
    public void arePermutationOfEachOtherBetterPerformance() {
        assertTrue(CheckPermutation.arePermutationOfEachOtherBetterPerformance("asd", "das"));
        assertFalse(CheckPermutation.arePermutationOfEachOtherBetterPerformance("asdd", "asd"));
    }
}