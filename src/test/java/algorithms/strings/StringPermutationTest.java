package algorithms.strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringPermutationTest {
    private StringPermutation stringPermutation;

    @Before
    public void init() {
        stringPermutation = new StringPermutation();
    }

    @Test
    public void getAllPermutationsOneCharacter() {

        Assert.assertEquals(Collections.singletonList("a"), stringPermutation.getAllPermutations("a"));
    }

    @Test
    public void getAllPermutationsTwoCharacters() {
        List<String> expected = Arrays.asList("ab", "ba");
        Assert.assertEquals(getSortedList(expected), getSortedList(stringPermutation.getAllPermutations("ab")));
    }

    @Test
    public void getAllPermutationsThreeCharacters() {
        List<String> expected = Arrays.asList("abc", "acb",  "bac", "bca", "cab", "cba");
        Assert.assertEquals(getSortedList(expected), getSortedList(stringPermutation.getAllPermutations("abc")));
    }

    private List<String> getSortedList(List<String> target){
        return target.stream().sorted().collect(Collectors.toList());
    }
}