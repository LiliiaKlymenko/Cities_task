package Game;

import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RulesTest {

    Rules rules;


    @BeforeMethod
    public void setUp() throws Exception {
    rules = new Rules();
    }


    @Test
    public void testSetNewWord() throws Exception {
        String testCity = Rules.listOfCities.get((int)Math.random()+10);
        rules.setNewWord(testCity);
        Assert.assertFalse("Still contains such city", Rules.listOfCities.contains(testCity));
    }

    @Test
    public void testCrossOut() throws Exception {
        Assert.assertNotNull(Rules.listOfCities);
        String testCity = Rules.listOfCities.get(0);
        rules.crossOut(testCity);
        Assert.assertFalse("Still contains such city", Rules.listOfCities.contains(testCity));
    }

    @Test
    public void testExist() throws Exception {
        Assert.assertNotNull(Rules.listOfCities);
        String testCity = Rules.listOfCities.get(0);
        Assert.assertTrue("Doesn`t exist such city", rules.exist(testCity));
    }
}