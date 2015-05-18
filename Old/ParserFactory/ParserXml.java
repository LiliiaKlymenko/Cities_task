package ParserFactory;

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


    public ParserXml() {

    }

    public List<String> parse(String fileName) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("plane.xml");
        List<String> result = new ArrayList<String>();
        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        List list = rootNode.getChildren("cities");
        for (int i = 0; i < list.size(); i++) {
            Element node = (Element) list.get(i);
            result.add(node.getChildText("city"));
        }
        return result;
    }
}
