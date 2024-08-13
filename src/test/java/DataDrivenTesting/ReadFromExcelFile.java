package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step 1: convert the file into object
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//step 2: create a workbook from workbookfactory
		Workbook workbook = WorkbookFactory.create(fis);
		
		//step 3:fetch the sheet from the workbook
		Sheet sheet = workbook.getSheet("Sheet1");
		
		//step 4:fetch the row from the sheet
		Row row = sheet.getRow(0);
		
		System.out.println(sheet.getLastRowNum());
		
		//step 5:fetch the cell from the row
		Cell cell = row.getCell(0);
		
		System.out.println(row.getLastCellNum());
		
		//step 6:get value from the cell as a string
		String result = cell.getStringCellValue();
		
		System.out.println(result);
		
		
		String Url_value = workbook.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		System.out.println(Url_value);
	}

}
