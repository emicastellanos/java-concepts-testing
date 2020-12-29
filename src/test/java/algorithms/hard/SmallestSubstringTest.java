package algorithms.hard;

import algorithms.hard.SmallestSubstring;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestSubstringTest {

    @Test
    public void getShortestUniqueSubstring() {
        char[] characters = new char[3];
        characters[0]='x';
        characters[1]='y';
        characters[2]='z';

        String str =  "xyyzyzyx";
        String expected = "zyx";

        assertEquals(expected, SmallestSubstring.getShortestUniqueSubstring(characters,str));

        char[] characters2 = new char[3];
        characters2[0]='e';
        characters2[1]='m';
        characters2[2]='i';

        String str2 =  "abkasdkiywollemtime";
        String expected2 = "ime";
        assertEquals(expected2, SmallestSubstring.getShortestUniqueSubstring(characters2,str2));
    }

    @Test
    public void testSubstring(){
        int init = 0;
        int end = 3;
        String example = "palabra";
        System.out.println(example.substring(init,end));
    }
}