package Game;

import org.jdom2.JDOMException;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Liliia_Klymenko on 15-May-15.
 */
public class Main {
    public static void main(String[] args) throws IOException, JDOMException, SQLException {
        Game game = new Game();
        game.start();
    }
}
