package concepts.functionalProgramming;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.UnaryOperator;

public class OperatorExampleTest {

    OperatorExample operatorExample = new OperatorExample();

    @Test
    public void getLongestWord() {

        String expected = "Emiliano";
        List<String> words = Arrays.asList("asd", "Juan", "Mabel", "Emiliano", "Pepe", "a");

        Assert.assertEquals(expected, operatorExample.getLongestWord(words));
        Assert.assertEquals("", operatorExample.getLongestWord(Collections.EMPTY_LIST));
    }

    @Test
    public void getLongestWord2() {
        String expected = "Emiliano";
        List<String> words = Arrays.asList("asd", "Juan", "Mabel", "Emiliano", "Pepe", "a");

        Assert.assertEquals(expected, operatorExample.getLongestWord2(words));
    }

    @Test
    public void getModifiedElements() {
        List<String> elements = Arrays.asList("emi", "dos", "tres", "cuatro");
        List<String> expected = Arrays.asList("EMI", "DOS", "TRES", "CUATRO");

        List<String> result = operatorExample.getModifiedElements(elements, String::toUpperCase);

        Assert.assertArrayEquals(expected.toArray(), result.toArray());

        List<String> result2 = operatorExample.getModifiedElements(elements, x -> x + "2");
        List<String> expected2 = Arrays.asList("emi2", "dos2", "tres2", "cuatro2");

        Assert.assertArrayEquals(expected2.toArray(), result2.toArray());
    }

    @Test
    public void reduceToOne() {
        List<Number> elements = Arrays.asList(2, 4, 6, 4, 8, 12, 4, 2);
        Assert.assertEquals(new Long(12), operatorExample.reduceToOne(elements, (i, i2) -> Math.max(i.longValue(), i2.longValue())));
    }

    @Test
    public void reduceToOneBigDecimal() {
        List<BigDecimal> elements = Arrays.asList(
                new BigDecimal(2),
                new BigDecimal(4),
                new BigDecimal(5),
                new BigDecimal(12),
                new BigDecimal(-5));

        BigDecimal minExpected = new BigDecimal(-5);
        Assert.assertEquals(minExpected, operatorExample.reduceToOneBigDecimal(elements, BigDecimal::min));

        BigDecimal maxExpected = new BigDecimal(12);
        Assert.assertEquals(maxExpected, operatorExample.reduceToOneBigDecimal(elements, BigDecimal::max));

        BigDecimal sumExpected = new BigDecimal(18);
        Assert.assertEquals(sumExpected, operatorExample.reduceToOneBigDecimal(elements, BigDecimal::add));
    }
}