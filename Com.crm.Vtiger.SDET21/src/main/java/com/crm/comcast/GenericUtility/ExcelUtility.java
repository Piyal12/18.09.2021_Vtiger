package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains generic method to read and write data from excel sheet
 * 
 * @author PIYAL
 *
 */
public class ExcelUtility {
	/**
	 * this will read the data from excel sheet wrt num and cell num
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable {

		// convert excel file to java representation object
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);

		// connect the file
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter format = new DataFormatter();
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = format.formatCellValue(cell);
		return value;
	}

	/**
	 * This method return the data full in sheet
	 * 
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] getExcelData(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(SheetName);
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		DataFormatter formatter = new DataFormatter();

		Object[][] data = new Object[lastRowNum][lastCellNum];

		for (int i = 0; i < lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				data[i][j] = formatter.formatCellValue(sheet.getRow(i + 1).getCell(j));
				// data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
