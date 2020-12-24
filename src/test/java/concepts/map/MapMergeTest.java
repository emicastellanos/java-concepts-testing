package concepts.map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMergeTest {

    private static List<String> words = Arrays.asList("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");
    private static Map<String, Integer> mapWords;

    @BeforeClass
    public static void init() {
        mapWords = new HashMap<String, Integer>();
        words.forEach(word -> {
            Integer prev = mapWords.get(word);
            if (prev == null) {
                mapWords.put(word, 1);
            } else {
                mapWords.put(word, prev + 1);
            }
        });
        words.forEach(w -> System.out.printf("%s - %s%n", w, mapWords.get(w)));
    }

    @Test
    public void putIfAbsentTest() {
        Map<String, Integer> mapFirstRefactoring = new HashMap<String, Integer>();
        words.forEach(word -> {
            mapFirstRefactoring.putIfAbsent(word, 0);
            mapFirstRefactoring.put(word, mapFirstRefactoring.get(word) + 1);
        });

        Assert.assertTrue("distinct size of map", mapWords.size() == mapFirstRefactoring.size());
        mapWords.keySet().stream().forEach(k -> Assert.assertEquals(k + " have different count (mapFirstRefactoring)"
                , mapWords.get(k), mapFirstRefactoring.get(k)));
    }

    @Test
    public void mapMergeTest() {
        Map<String, Integer> mapMerge = new HashMap<String, Integer>();
        words.forEach(word -> mapMerge.merge(word, 1, (prev, one) -> prev + one));

        Assert.assertTrue(mapWords.size() == mapMerge.size());
        mapWords.keySet().stream().forEach(k -> Assert.assertEquals(k + " have different count (mapMerge)"
                , mapWords.get(k), mapMerge.get(k)));
    }

    @Test
    public void mapMergeRefactoredTest() {
        Map<String, Integer> mapMergeRefactored = new HashMap<String, Integer>();

        words.forEach(word -> mapMergeRefactored.merge(word, 1, Integer::sum));

        Assert.assertTrue(mapWords.size() == mapMergeRefactored.size());
        mapWords.keySet().stream().forEach(k -> Assert.assertEquals(k + " have different count (mapMergeRefactored)",
                mapWords.get(k), mapMergeRefactored.get(k)));
    }
}
