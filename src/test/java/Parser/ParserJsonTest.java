package Parser;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Liliia_Klymenko on 18-May-15.
 */
public class ParserJsonTest {

    ParserJson parserJson;
    static final String FILE_NAME = "cities/cities.json";
    static final String FIRST_ELEMENT = "Guangzhou";

    @BeforeTest
    public void setUp() throws Exception {
        parserJson = new ParserJson();
    }

    @Test
    public void testParse() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource(FILE_NAME).getFile();
        List<String> listOfSities;
        listOfSities = parserJson.parse(path);
        Assert.assertEquals(listOfSities.get(0), FIRST_ELEMENT);
    }
}