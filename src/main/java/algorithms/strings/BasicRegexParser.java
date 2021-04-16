package algorithms.strings;

/**
 * Implement a regular expression function isMatch that supports the '.' and '*' symbols.
 * The function receives two strings - text and pattern - and should return true if the text matches the pattern as a regular expression.
 * For simplicity, assume that the actual symbols '.' and '*' do not appear in the text string and are used as special symbols only in the pattern string.
 */
public class BasicRegexParser {
    private static final char WILDCARD = '.';
    private static final char ASTERISK = '*';

    public static boolean isMatch(String text, String pattern) {
        return isMatchRecursiveHelper(text, pattern, 0, 0);
    }

    private static boolean isMatchRecursiveHelper(String text, String pattern, int textIndex, int patIndex) {
        if (textIndex == text.length()) {
            if (patIndex == pattern.length()) {
                return true;
            } else {
                if (pattern.charAt(patIndex) == ASTERISK){
                    return isMatchRecursiveHelper(text, pattern, textIndex, patIndex + 1);
                }
                if ((patIndex + 1 < pattern.length()) && (pattern.charAt(patIndex + 1) == ASTERISK)){
                    return isMatchRecursiveHelper(text, pattern, textIndex, patIndex + 1);
                }
                return false;
            }
        } else {
            if (patIndex == pattern.length()){
                return false;
            }
            //case perfect match or dot
            if (text.charAt(textIndex) == pattern.charAt(patIndex) || pattern.charAt(patIndex) == WILDCARD) {
                return isMatchRecursiveHelper(text, pattern, textIndex + 1, patIndex + 1);
            }
            //asterisk case for multiple matches
            if (pattern.charAt(patIndex) == ASTERISK) {
                if (text.charAt(textIndex) == pattern.charAt(patIndex - 1)) {
                    return isMatchRecursiveHelper(text, pattern, textIndex + 1, patIndex);
                } else {
                    return isMatchRecursiveHelper(text, pattern, textIndex, patIndex + 1);
                }
            }
            //asterisk case for zero matches
            if (patIndex < pattern.length() && pattern.charAt(patIndex + 1) == ASTERISK) {
                return isMatchRecursiveHelper(text, pattern, textIndex, patIndex + 2);
            } else {
                return false;
            }
        }
    }
}
