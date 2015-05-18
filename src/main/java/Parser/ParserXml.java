package Parser;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Liliia_Klymenko on 14-May-15.
 */
public class ParserXml implements Parser {


    public List<String> parse(String fileName) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(fileName);
        List<String> result = new ArrayList<String>();
        Document document = builder.build(xmlFile);
        Element root = document.getRootElement();
        List<Element> list = root.getChildren();
        for(Element i : list)
        result.add(i.getText());
        return result;
    }
}
