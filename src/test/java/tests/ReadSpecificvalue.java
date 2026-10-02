package tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadSpecificvalue {

    public static void main(String[] args) throws IOException {

        // Open Excel file
        FileInputStream fis = new FileInputStream(
                "C:\\Users\\Anith\\OneDrive\\Desktop\\Data1.xlsx"
        );

        // Open workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // Get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Get second row
        XSSFRow row = sheet.getRow(1);

        // Create DataFormatter
        DataFormatter format = new DataFormatter();

        // Get Name from Column A
        XSSFCell nameCell = row.getCell(0);
        String name = format.formatCellValue(nameCell);

        // Get Number from Column B
        XSSFCell numberCell = row.getCell(1);
        String number = format.formatCellValue(numberCell);

        // Print values
        System.out.println("Name = " + name);
        System.out.println("Number = " + number);

        // Close workbook
        workbook.close();

        // Close file
        fis.close();
    }
}