package Parser;

import org.jdom2.JDOMException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lili on 17.05.2015.
 */
public class ParserJson implements Parser{

    @Override
    public List<String> parse(String fileName) throws JDOMException, IOException, SQLException, ParseException {

        List<String> result = new ArrayList<String>();
        FileReader reader = new FileReader(fileName);

        JSONParser jsonParser = new JSONParser();

        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray citiesList = (JSONArray) jsonObject.get("City");
        for (int i = 0; i < citiesList.size(); i++) {
            String city = (String) citiesList.get(i);
            result.add(city);
        }        return result;
    }

}
