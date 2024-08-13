package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteToExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// step 1:convert the file to object
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

		// step 2: create workbook
		Workbook workbook = WorkbookFactory.create(fis);

		// step 3:get sheet from the workbook
		Sheet sheet = workbook.getSheet("Sheet1");

		// step 4:create new row and add the data
		sheet.createRow(6).createCell(0).setCellValue("admin phone");
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getLastRowNum() + 1);

		sheet.getRow(sheet.getLastRowNum()).createCell(1).setCellValue("70362521458");

		// step 5:save the file
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		workbook.write(fos);

		// step 6:close the workbook

		workbook.close();

	}
}
