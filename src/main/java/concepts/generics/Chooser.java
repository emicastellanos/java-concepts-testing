package concepts.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser {
    private final Object[] choiceArray;

    public Chooser(Collection collection) {
        choiceArray = collection.toArray();
    }

    public Object choose() {
        Random rdm = ThreadLocalRandom.current();
        return choiceArray[rdm.nextInt(choiceArray.length)];

    }

    public static void main(String[] args) {
        Collection stringCollection = Arrays.asList("one","two","three");
        Chooser chooser = new Chooser(stringCollection);
        //Its always needed to be casted and it will depend on the collection type.
        String element = (String) chooser.choose();
        System.out.printf("the element: %s, was choosen", element);
    }
}
