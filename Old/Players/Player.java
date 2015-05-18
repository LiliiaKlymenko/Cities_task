package Players;

import org.jdom2.JDOMException;

import java.io.IOException;

/**
 * Created by Liliia_Klymenko on 14-May-15.
 */
public abstract class Player {

   public abstract String printWord(String previousWord) throws JDOMException, IOException;
}
