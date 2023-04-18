package vtiger.Practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInToXlSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		// TODO Auto-generated method stub
		
		//Step1:Load the file into Java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step2:Create Workbook 
		Workbook wb = WorkbookFactory.create(fis);
		//step3:get inside the sheet 
		Sheet sh = wb.getSheet("Organization");
		//step4:get the used row 
		Row rw = sh.getRow(1);
		//step5:create a cell
		Cell ce = rw.createCell(8);
		//step6:write data into cell
		ce.setCellValue("Test1");
		//step7:load the file into Java Writable format 
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		System.out.println("Data Added");
		//step8:get the saved data 
		String value = ce.getStringCellValue();
		System.out.println(value);
		//step9:close workbook
		wb.close();
	}

}
