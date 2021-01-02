package concepts.functionalProgramming;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class OperatorExample {

    public OperatorExample() {
    }

    public String getLongestWord(List<String> list) {

        if (list.size() == 0) return "";

        String longest = list.get(0);
        for (String s : list) {
            longest = BinaryOperator
                    .maxBy(Comparator.comparing(String::length))
                    .apply(longest, s);
        }
        return longest;
    }

    public String getLongestWord2(List<String> list) {
        String longest = "";
        Comparator<String> comparator =  new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        };

        return list.stream().sorted(Comparator.naturalOrder()).findFirst().get();
    }

    public <T> List<T> getModifiedElements(List<T> elements, UnaryOperator<T> op){
        return elements.stream()
                .map(op)
                .collect(Collectors.toList());
    }

    public Number reduceToOne(List<Number> elements, BinaryOperator<Number> operator){
        Number accumulator = 0;
        return elements.stream().reduce(accumulator, operator);
    }

    public BigDecimal reduceToOneBigDecimal(List<BigDecimal> elements, BinaryOperator<BigDecimal> operator){
        BigDecimal accumulator = BigDecimal.ZERO;
        return elements.stream().reduce(accumulator, operator);
    }
}
