package Players;

import Game.Rules;
import org.junit.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComputerTest {


    Computer computer;
    final static String PREVIOUS_WORD = "A";     /* always exist */

    @BeforeGroups(groups = "positive")
    public void setUp() throws Exception {
        computer = new Computer();
        Rules rules = new Rules();
    }

    @BeforeGroups(groups = "negative")
    public void setUp_negative() throws Exception {
        computer = new Computer();
    }


    @Test(groups = "positive", dependsOnGroups = "negative")
    public void testPrintWord() throws Exception {
        String word = computer.printWord(PREVIOUS_WORD);
        char firstLetter = word.charAt(0);
        char lastLetter = PREVIOUS_WORD.charAt(PREVIOUS_WORD.length()-1);
        Assert.assertEquals(firstLetter, lastLetter);
    }


    @Test(description = "try to print a word when listOfCities is already empty", groups = "negative", expectedExceptions = NullPointerException.class)
        public  void testPrintWord_wordsEnded() throws Exception {
        String word = computer.printWord(PREVIOUS_WORD);
        char firstLetter = word.charAt(0);
        char lastLetter = PREVIOUS_WORD.charAt(PREVIOUS_WORD.length()-1);
        Assert.assertEquals(firstLetter, lastLetter);
    }


    @Test(description = "try to print a word when listOfCities doesn`t consist any proper words", groups = "negative")
    public  void testPrintWord_NoProperWords() throws Exception {
        List<String> list = new ArrayList<String>(Arrays.asList("City1", "Citi2"));
        Rules rules = new Rules();
        Rules.listOfCities = list;
        String word = computer.printWord(PREVIOUS_WORD);
        Assert.assertNull(word);

    }

}