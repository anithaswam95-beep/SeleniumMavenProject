package tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static void main(String[] args) throws IOException {

        // Step 1: Open the Excel file
        FileInputStream fis = new FileInputStream(
                "C:\\Users\\Anith\\OneDrive\\Desktop\\Data1.xlsx"
        );

        // Step 2: Open the Excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // Step 3: Get the first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Step 4: Get the total number of rows
        int rowSize = sheet.getLastRowNum() + 1;

        // Step 5: Get the header row
        XSSFRow headerRow = sheet.getRow(0);

        // Step 6: Get the total number of cells/columns
        int cellSize = (headerRow != null) ? headerRow.getLastCellNum() : 0;

        // Step 7: Create DataFormatter
        DataFormatter format = new DataFormatter();

        // Step 8: Loop through all rows
        for (int i = 0; i < rowSize; i++) {

            // Get current row
            XSSFRow row = sheet.getRow(i);

            if (row != null) {

                // Step 9: Loop through all cells
                for (int j = 0; j < cellSize; j++) {

                    // Get current cell
                    XSSFCell cell = row.getCell(j);

                    // Convert cell value to String
                    String value = (cell != null)
                            ? format.formatCellValue(cell)
                            : "";

                    // Print the value
                    System.out.print(value + "\t");
                }
            }

            // Move to the next line
            System.out.println();
        }

        // Step 10: Close workbook
        workbook.close();

        // Step 11: Close file
        fis.close();
    }
}