package algorithms.strings;

import org.junit.Test;
import util.Person;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class URLifyTest {

    @Test
    public void getConvertedUrl() {
        String urlExpected = "Mr%20John%20Smith";
        char[] url = "Mr John Smith    ".toCharArray();
        URLify.getConvertedUrl(url,13);
        assertEquals(urlExpected, new String(url));

        String secondUrlExpected = "Mr%20%20J";
        char[] url2 = "Mr  J    ".toCharArray();
        URLify.getConvertedUrl(url2,5);
        assertEquals(secondUrlExpected, new String(url2));
    }

    public void method(Person a, int variable){
        System.out.println(a);

        a = new Person("Juan");
        variable = 2;
        System.out.println(a);
    }
}