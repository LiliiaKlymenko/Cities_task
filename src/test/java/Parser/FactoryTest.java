package Parser;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.testng.annotations.Test;

import java.util.List;

public class FactoryTest {

    static final String FILE_NAME = "cities/cities.xls";
    public List<String> listOfCities;

    @Test
    public void testGetListOfCities() throws Exception {
        Mockery context = new JUnit4Mockery();
        final Parser fake_parser = context.mock(Parser.class);
        context.checking(new Expectations() {{ oneOf(fake_parser).parse(FILE_NAME); }});
       listOfCities = fake_parser.parse(FILE_NAME);
        context.assertIsSatisfied();
    }
}