package algorithms.strings;

import org.junit.Test;

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
}