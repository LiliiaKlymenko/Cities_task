package Parser;


import org.apache.log4j.Logger;
import org.jdom2.JDOMException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Liliia_Klymenko on 14-May-15.
 */
public class Factory {

    static final String XLS_REGEX = ".xls";
    static final String XML_REGEX = ".xml";
    static final String TXT_REGEX = ".txt";
    static final String SQL_REGEX = ".sql";
    static final String JSON_REGEX = ".json";
    private static final Logger factoryLog = Logger.getLogger(Factory.class);

    public List<String> listOfCities;

    public List<String> getListOfCities(String fileName) {
        try {
       if (fileName.endsWith(XLS_REGEX)) {
           listOfCities = new ParserExcel().parse(fileName);
        }
        if (fileName.endsWith(XML_REGEX)) {

                listOfCities = new ParserXml().parse(fileName);
        }
        if (fileName.endsWith(TXT_REGEX)) {
            listOfCities = new ParserTxt().parse(fileName);
        }
        if (fileName.endsWith(SQL_REGEX)) {

            listOfCities = new ParserSql(ConnectorDB.getConnection()).parse(fileName);
        }
            if (fileName.endsWith(JSON_REGEX)) {
                listOfCities = new ParserJson().parse(fileName);
            }
        } catch (JDOMException e) {
            factoryLog.error("Error in XML parser", e);
            e.printStackTrace();
        } catch (IOException e) {
            factoryLog.error("Error in parser", e);
            e.printStackTrace();
        } catch (SQLException e) {
            factoryLog.error("Error in SQL parser", e);
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listOfCities;
    }


}
