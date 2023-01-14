package selenium_intro.ExelDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {
    public static void main(String[] args)  {


    }
    public ArrayList<String> getData(String testCaseName) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        // fileInputStream argument
        FileInputStream fIS = new FileInputStream("C:\\Users\\fkara\\Desktop\\demoData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fIS);

        int sheetCount = workbook.getNumberOfSheets();

        for (int i = 0; i < sheetCount; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
                // Get access to the sheet we want
                XSSFSheet sheet = workbook.getSheetAt(i);

                // Get access to all rows of sheet
                Iterator<Row> rows = sheet.iterator();

                // Access to specific row (1st) from all rows
                Row firstRow = rows.next();
                Iterator<Cell> cells = firstRow.cellIterator();

                // idendify which column we search
                int column = 0;
                while (cells.hasNext()) {
                    Cell value = cells.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        break;
                    }
                    column++;
                }
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {

                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                list.add(c.getStringCellValue());
                            }
                            else {
                                String num = NumberToTextConverter.toText(c.getNumericCellValue());
                                list.add(num);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}
