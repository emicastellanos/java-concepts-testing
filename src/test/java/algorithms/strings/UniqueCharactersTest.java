package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniqueCharactersTest {
    private static final String UNREPEATED_CHARS = "abcdeE";
    private static final String REPEATED_CHARS = "aa";

    @Test
    public void hasUniqueCharacters() {
        assertTrue(UniqueCharacters.hasUniqueCharacters(UNREPEATED_CHARS));
        assertFalse(UniqueCharacters.hasUniqueCharacters(REPEATED_CHARS));
    }

    @Test
    public void hasUniqueCharactersNoAuxiliaryStructure() {
        assertTrue(UniqueCharacters.hasUniqueCharactersNoAuxiliaryStructure(UNREPEATED_CHARS));
        assertFalse(UniqueCharacters.hasUniqueCharactersNoAuxiliaryStructure(REPEATED_CHARS));
    }

    @Test
    public void hasUniqueCharactersBestPerformance() {
        assertTrue(UniqueCharacters.hasUniqueCharactersBestPerformance(UNREPEATED_CHARS));
        assertFalse(UniqueCharacters.hasUniqueCharactersBestPerformance(REPEATED_CHARS));
    }
}
