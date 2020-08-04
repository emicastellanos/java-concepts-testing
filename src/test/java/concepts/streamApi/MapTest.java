package concepts.streamApi;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    private List<String> words = Arrays.asList("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");

    @Test
    public void mapMergeTest() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        words.forEach(word -> {
            Integer prev = map.get(word);
            if (prev == null) {
                map.put(word, 1);
            } else {
                map.put(word, prev + 1);
            }
        });
        words.forEach(w -> System.out.printf("%s - %s%n", w, map.get(w)));

        Map<String, Integer> mapFirstRefactoring = new HashMap<String, Integer>();
        words.forEach(word -> {
            mapFirstRefactoring.putIfAbsent(word, 0);
            mapFirstRefactoring.put(word, mapFirstRefactoring.get(word) + 1);
        });

        Assert.assertTrue("distinct size of map",map.size() == mapFirstRefactoring.size());
        map.keySet().stream().forEach(k -> Assert.assertEquals(k + " have different count (mapFirstRefactoring)"
                ,map.get(k),mapFirstRefactoring.get(k)));


        Map<String, Integer> mapSecondRefactoring = new HashMap<String, Integer>();
        words.forEach(word -> mapSecondRefactoring.merge(word, 1, (prev, one) -> prev + one));

        Assert.assertTrue(map.size() == mapSecondRefactoring.size());
        map.keySet().stream().forEach(k -> Assert.assertEquals(k + " have different count (mapSecondRefactoring)"
                ,map.get(k),mapSecondRefactoring.get(k)));

        Map<String, Integer> mapFinalRefactoring = new HashMap<String, Integer>();
        words.forEach(word -> mapFinalRefactoring.merge(word, 1, Integer::sum));

        Assert.assertTrue(map.size() == mapFinalRefactoring.size());
        map.keySet().stream().forEach(k -> Assert.assertEquals(k + " have different count (mapFinalRefactoring)"
                , map.get(k),mapFinalRefactoring.get(k)));

    }
}
