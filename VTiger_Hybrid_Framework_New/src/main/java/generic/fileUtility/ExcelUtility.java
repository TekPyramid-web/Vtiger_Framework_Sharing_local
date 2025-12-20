package generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFRomExcel(String sheetName, int rowNum, int celNum) throws Throwable {

		FileInputStream fis2 = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int getRowcount(String sheetName) throws Throwable {
		FileInputStream fis2 = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}

	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {

		FileInputStream fis2 = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);

		FileOutputStream fos = new FileOutputStream("./TestData/TestScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
