package Players;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import java.io.IOException;

@RunWith(JMock.class)
public class PlayerTest {


    final static String PREVIOUS_WORD = "A";


    @Test
    public void testPrintWord() throws IOException {
        Mockery context = new JUnit4Mockery();
        final Players fake_player = context.mock(Players.class);
        context.checking(new Expectations() {{ oneOf(fake_player).printWord(PREVIOUS_WORD); }});
        String word = fake_player.printWord(PREVIOUS_WORD);
        context.assertIsSatisfied();
    }


}