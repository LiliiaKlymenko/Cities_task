package Parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Lili on 16.05.2015.
 */
public class ConnectorDB {

    static String user = "new_root";
    static String pass = "1234";
    static String url = "jdbc:mysql://localhost/vk_db";
    static String driver = "com.mysql.jdbc.Driver";


    public ConnectorDB() throws ClassNotFoundException {
        Class.forName(driver);
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, pass);
    }

}

       /* ResourceBundle resource = ResourceBundle.getBundle("database");
        String url= resource.getString("db.url");
        String user=resource.getString("db.user");
        String pass=resource.getString("db.password");*/