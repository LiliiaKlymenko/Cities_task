package Parser;

import org.jdom2.JDOMException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lili on 14.05.2015.
 */
public interface Parser {
    List<String> result = new ArrayList<String>();;
    public List<String> parse(String fileName) throws JDOMException, IOException, SQLException, ParseException, ClassNotFoundException;

}
