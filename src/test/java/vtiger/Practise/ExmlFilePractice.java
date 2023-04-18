package vtiger.Practise;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExmlFilePractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//step1:Load The Excel file readable format 
		FileInputStream ex_File = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//Step2:Create a workbook 
		Workbook wb = WorkbookFactory.create(ex_File);
			
		//Step3:get control over sheet
		Sheet st = wb.getSheet("Organization");
	
		//step4:get control over row
		Row rw = st.getRow(1);
		//step5:get control over cell 
		Cell cl = rw.getCell(2);
		//step6:read the data inside the cell 
		String value = cl.getStringCellValue();
		System.out.println(value);
	}

}
