/**
 * 
 */
package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

/**
 * @author Sushma Akki
 *
 */
public class TestDataFileUtility 
{
	/**
	 * This Method will read data from excel sheet 	
	 * @param sheet
	 * @param row
	 * @param colum
	 * @return
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheet,int row,int colum) throws IOException
	{
		FileInputStream fise = new FileInputStream(IContactUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fise);
		String value = wb.getSheet(sheet).getRow(row).getCell(colum).getStringCellValue();
		
		return value;
	}
	
	public Object[][] readDataFromExcelSheetForDataProvider(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fise = new FileInputStream(IContactUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fise);
		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}		
		return data;
	}
	
	
	public void writeDatatoExcel(String sheet,int rowno,int cellno,String value) throws IOException
	{
		FileInputStream fisec = new FileInputStream(IContactUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fisec);
		wb.getSheet(sheet).createRow(rowno).createCell(cellno).setCellValue(value);
		
		FileOutputStream fosec = new FileOutputStream(IContactUtility.excelfilepath);
		wb.write(fosec);
		wb.close();
		
	}
}
