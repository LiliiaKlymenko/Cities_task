package Parser;

import org.jdom2.JDOMException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lili on 16.05.2015.
 */
public class ParserSql implements Parser {

    public static final String SQL_GET_CITY_NAME = "SELECT  `name` FROM `city`";
    private final Connection connection;

    public ParserSql(Connection  connection) {
        this.connection = connection;
    }

    @Override
    public List<String> parse(String fileName) throws JDOMException, IOException, SQLException, ClassNotFoundException {
        ConnectorDB connectorDB = new ConnectorDB();
        connectorDB.getConnection();
        List<String> result = new ArrayList<String>();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(SQL_GET_CITY_NAME);
        rs.next();
        while(rs.next()){
            String city = rs.getString("name");
            result.add(city);
        }
        return result;
    }

}
