package Parser;

import junit.framework.TestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Liliia_Klymenko on 18-May-15.
 */
public class ParserExcelTest extends TestCase {


    ParserExcel parserExcel;
    static final String FILE_NAME = "cities/cities.xls";
    static final String FIRST_ELEMENT = "Aguilar";

    @BeforeTest
    public void setUp() throws Exception {
       parserExcel = new ParserExcel();

    }


    @Test
    public void testParse() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource(FILE_NAME).getFile();
        List<String> listOfSities;
        listOfSities = parserExcel.parse(path);
        Assert.assertEquals(listOfSities.get(0), FIRST_ELEMENT);
    }
}