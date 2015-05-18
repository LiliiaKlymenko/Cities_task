package Parser;

import org.jdom2.JDOMException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lili on 16.05.2015.
 */
public class ParserTxt implements Parser{

    @Override
    public List<String> parse(String fileName) throws JDOMException, IOException {
        List<String> result = new ArrayList<String>();
        String line;
        File file = new File(fileName);
        BufferedReader br = new BufferedReader
                (new InputStreamReader(new FileInputStream(file), "Windows-1251"));
        while ((line = br.readLine()) != null) {
            result.add(line);
        }
        return result;
    }
}
