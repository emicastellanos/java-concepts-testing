package algorithms.strings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    private StringCompression stringCompressionToBeTested;

    @Test
    public void getCompressed_WhenCompressedIsShorterReturnCompressed() {
        String word = "aaaeerrrraCCC";
        String wordCompressedExpected = "a3e2r4a1C3";

        stringCompressionToBeTested = new StringCompression(word);

        Assert.assertEquals(wordCompressedExpected, stringCompressionToBeTested.getCompressed());
    }

    @Test
    public void getCompressed_WhenCompressedIsLongerReturnSameInput() {
        String word = "aerCC";

        stringCompressionToBeTested = new StringCompression(word);

        Assert.assertEquals(word, stringCompressionToBeTested.getCompressed());
    }

    @Test
    public void getCompressed_WhenCompressedIsEmptyShouldReturnEmpryString() {
        stringCompressionToBeTested = new StringCompression("");
        Assert.assertEquals(StringCompression.EMPTY_STRING, stringCompressionToBeTested.getCompressed());
    }
}