package concepts.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserGeneric<T> {
    private final List<T> choiceArray;

    public ChooserGeneric(Collection<T> choices) {
        choiceArray = new ArrayList<>(choices);
    }

    public T choose() {
        Random rdm = ThreadLocalRandom.current();
        return choiceArray.get(rdm.nextInt(choiceArray.size()));

    }

    public static void main(String[] args) {
        Collection<String> stringCollection = Arrays.asList("one", "two", "three");
        ChooserGeneric<String> chooser = new ChooserGeneric<>(stringCollection);
        //Its always needed to be casted and it will depend on the collection type.
        String element = chooser.choose();
        System.out.printf("the element: %s, was choosen", element);
    }
}
