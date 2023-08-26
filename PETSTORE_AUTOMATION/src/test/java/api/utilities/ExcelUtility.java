package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtility {

	@Test
	public String getDataFromExcel(int row,int cell) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/Petstore.xlsx");
		
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		String value = null;
		DataFormatter format=new DataFormatter();

		value=format.formatCellValue(sh.getRow(row).getCell(cell));
		return value;
		
	}
	
	
}
