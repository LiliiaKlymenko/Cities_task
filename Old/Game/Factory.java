package Game;

import ParserFactory.ParserExcel;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Liliia_Klymenko on 14-May-15.
 */
public class Factory {

    static final String XLS_REGEX = "(?=.*(?:\\.xls)";
    static final String XML_REGEX = "(?=.*(?:\\.xml)";

    public List<String> listOfCities;

    List<String> getListOfCities(String fileName) throws JDOMException, IOException {

     //  if (XLS_REGEX.matches(fileName)) {
           listOfCities = new ParserExcel().parse(fileName);
   //     }

        return listOfCities;
    }


}
