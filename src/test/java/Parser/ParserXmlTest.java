package Parser;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Liliia_Klymenko on 18-May-15.
 */
public class ParserXmlTest {

    ParserXml parserXml;
    static final String FILE_NAME = "cities/cities.xml";
    static final String FIRST_ELEMENT = "Guangzhou";
    @BeforeMethod
    public void setUp() throws Exception {
        parserXml = new ParserXml();
    }

    @Test
    public void testParse() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource(FILE_NAME).getFile();
        List<String> listOfSities;
        listOfSities = parserXml.parse(path);
        Assert.assertEquals(listOfSities.get(0), FIRST_ELEMENT);
    }
}