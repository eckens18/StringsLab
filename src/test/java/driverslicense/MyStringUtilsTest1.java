package driverslicense;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyStringUtilsTest1 {

    @Test
    public void arrayToString() throws Exception {
        String [] array = {"name","address","eye"};
        String expected = "name,address,eye";
        String actual = MyStringUtils.arrayToString(array);
        assertEquals(expected,actual);
    }

    @Test
    public void stringToArrayOfStrings() throws Exception {
        String linesString = "hello\n" +
                "my name\n" +
                "is Derek";
        String [] expected = {"hello","my name","is Derek"};
        String [] actual = MyStringUtils.stringToArrayOfStrings(linesString);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void reverseCapitalizeString() throws Exception {
        String dummyString = "This is the dummy sentence";
        String expected = "tHIS iS tHE dUMMY sENTENCE";
        String actual = MyStringUtils.reverseCapitalizeString(dummyString);
        assertEquals(expected,actual);
    }

    @Test
    public void reverseSpellingOfString() throws Exception {
        String dummyString = "the sentence";
        String expected = "eht ecnetnes";
        String actual = MyStringUtils.reverseSpellingOfString(dummyString);
        assertEquals(expected,actual);
    }

    @Test
    public void separateEachWordOnNewLine() throws Exception {
        String dummyString = "The dummy sentence";
        String expected = "The\ndummy\nsentence";
        String actual = MyStringUtils.separateEachWordOnNewLine(dummyString);
        assertEquals(expected,actual);
    }

    @Test
    public void getArrayOfAllSubstrings() throws Exception {
        String dummyString = "the";
        String [] expected = {"t","th","the","h","he","e"};
        ArrayList actual = MyStringUtils.getArrayOfAllSubstrings(dummyString);
        assertArrayEquals(expected,actual.toArray());
    }

}