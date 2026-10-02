package testngPractice;

import org.testng.annotations.DataProvider;

import tests.Reader;

public class DataForTesting {
	
	@DataProvider(name="LoginData")
	public String[][] m1()
	{
		Reader reader = new Reader(
				"C:\\Users\\Anith\\OneDrive\\Desktop\\SauceDemoData.xlsx",
				"Sheet1");
		
		int rowSize = reader.getRowCount();
		int cellSize = reader.getCellCount();
		
		return reader.getAllData(rowSize, cellSize);
	}
}