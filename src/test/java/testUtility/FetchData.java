package testUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchData 
{
	public static String testData(int a, int b) throws EncryptedDocumentException, IOException
	{
		String data = "";
		
		String path= "src\\test\\resources\\TestData\\Book1.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		Sheet value = WorkbookFactory.create(file).getSheet("Sheet1");
		
		Cell c = value.getRow(a).getCell(b);
		
		CellType type = c.getCellType();
		
		if ( type == CellType.STRING)
		{
			data = c.getStringCellValue();
		}
		else if ( type == CellType.NUMERIC)
		{
			double number = c.getNumericCellValue();
			
			data = Double.toString(number);
		}
		else if ( type == CellType.BLANK)
		{
			data = "";
		}
		
		return data;
	}
}
