package tests;

import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	
	@Test
	public void m1()
	
    {
       // Sheet1 = "Sheet1";

        Reader reader = new Reader(
                "C:\\Users\\Anith\\OneDrive\\Desktop\\data2.xlsx",
               "Sheet1");

        String name = reader.getSingleValue(1, 0);
      // String number = reader.getSingleValue(1, 1);
        
        System.out.println("Name = " + name);
       // System.out.println("Number = " + number);
}
}	