package ParserFactory;

import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Lili on 14.05.2015.
 */
public interface Parser {

    public List<String> parse(String fileName) throws JDOMException, IOException;

}
