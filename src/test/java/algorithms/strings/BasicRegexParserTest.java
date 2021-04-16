package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicRegexParserTest {

    @Test
    public void isMatchShortPatternReturnFalse() {
        assert !BasicRegexParser.isMatch("aa", "a");
    }

    @Test
    public void isMatchLongPattern(){
        assert !BasicRegexParser.isMatch("a", "aa");
    }

    @Test
    public void isMatchEqualTextAndPattern() {
        assert BasicRegexParser.isMatch("aa", "aa");
    }

    @Test
    public void isMatchUsingDot() {
        assert BasicRegexParser.isMatch("abc", "a.c");
    }

    @Test
    public void isMatchUsingAsterisk() {
        assert BasicRegexParser.isMatch("abbbb", "ab*");
    }

    @Test
    public void isMatchUsingAsteriskNegative() {
        assert !BasicRegexParser.isMatch("abbbbcbbb", "ab*c");
    }

    @Test
    public void isMatchUsingAsteriskForZeroRepititions() {
        assert BasicRegexParser.isMatch("acd", "ab*c.");
    }

    @Test
    public void isMatchEmptyInputs(){
        assert BasicRegexParser.isMatch("", "");
    }

    @Test
    public void isMatchEmptyInputTextShouldAlwaysMatch(){
        assert BasicRegexParser.isMatch("", "a*");
    }

    @Test
    public void isMatchInterestingCase(){
        assert BasicRegexParser.isMatch("abaa", "a.*a*");
    }

}