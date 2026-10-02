package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader {

    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    DataFormatter format;

    public Reader(String excelPath, String excelSheet) {

        try {
            file = new File(excelPath);
            fis = new FileInputStream(file);

            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(excelSheet);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read one specific Excel value
    public String getSingleValue(int rownum, int cellnum) {

        row = sheet.getRow(rownum);
        cell = row.getCell(cellnum);

        format = new DataFormatter();

        String value = format.formatCellValue(cell);

        return value;
    }

    // Number of rows
    public int getRowSize() {

        return sheet.getLastRowNum() + 1;
    }

    // Number of columns
    public int getCellSize() {

        return sheet.getRow(0).getLastCellNum();
    }

    // Read all Excel data
    public String[][] allValues(int rowSize, int cellSize) {

        String[][] array = new String[rowSize][cellSize];

        for (int i = 0; i < rowSize; i++) {

            row = sheet.getRow(i);

            for (int j = 0; j < cellSize; j++) {

                cell = row.getCell(j);

                format = new DataFormatter();

                array[i][j] = format.formatCellValue(cell);
            }
        }

        return array;
    }

    // These methods are used by our DataProvider test

    public int getRowCount() {

        return sheet.getLastRowNum();
    }

    public int getCellCount() {

        return getCellSize();
    }

    public String[][] getAllData(int rowSize, int cellSize) {

        String[][] array = new String[rowSize][cellSize];

        for (int i = 1; i <= rowSize; i++) {

            row = sheet.getRow(i);

            for (int j = 0; j < cellSize; j++) {

                cell = row.getCell(j);

                format = new DataFormatter();

                array[i - 1][j] = format.formatCellValue(cell);
            }
        }

        return array;
    }}