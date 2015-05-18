package Parser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Liliia_Klymenko on 14-May-15.
 */
public class ParserExcel implements Parser {


    public ParserExcel() {

    }

    public  List<String> parse(String fileName) {
        List<String> result = new ArrayList<String>();
        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream(fileName);
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<org.apache.poi.ss.usermodel.Row> it = sheet.iterator();
        while (it.hasNext()) {
            org.apache.poi.ss.usermodel.Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result.add(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        break;
                }
            }

        }
        return result;
    }
}
