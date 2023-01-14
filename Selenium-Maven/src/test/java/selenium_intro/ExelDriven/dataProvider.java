package selenium_intro.ExelDriven;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class dataProvider {

    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "driveTest")
    public void testCaseData(String number, String school, String city) {
        System.out.println(number + " : " + school + " : " + city);
    }

    @DataProvider(name = "driveTest")
    public Object[][] getData() throws IOException {

        FileInputStream fIS = new FileInputStream("C:\\Users\\fkara\\Desktop\\exelDriven.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fIS);
        XSSFSheet sheet = wb.getSheetAt(1);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getPhysicalNumberOfCells();
        //int colCount = row.getLastCellNum();
        
        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 0; i < data.length; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < data[0].length; j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        return data;
    }
}
