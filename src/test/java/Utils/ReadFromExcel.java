package Utils;

import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromExcel {


    private static String testDataDir = System.getProperty("user.dir") + "/src/test/java/TestData/sauceDemo.xlsx";

    // Load the Excel file
    static FileInputStream fis;

    static {
        try {
            fis = new FileInputStream(testDataDir);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Create a workbook instance
    static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Access the specific sheet by name
    public ReadFromExcel() throws IOException {
    }

    // Access the "Login Details" sheet
    static XSSFSheet sheet = workbook.getSheet("Login Details");

    // Read the username from the first row and first cell
    public static String username = sheet.getRow(1).getCell(0).getStringCellValue();
    public static String password = sheet.getRow(1).getCell(1).getStringCellValue();


}
