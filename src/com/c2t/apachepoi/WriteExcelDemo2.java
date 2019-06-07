package com.c2t.apachepoi;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import statements
public class WriteExcelDemo2 {
	public static void main(String[] args) {
		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Employee Data");
		
		String data [][] = {
				{"P",""},
				{"R",""},
				{"T",""}
		};
		
		
		for(int rowCount=0;rowCount<3;rowCount++){
			Row row = sheet.createRow(rowCount);
			for(int colCount=0;colCount < 2;colCount++){
				Cell cell = row.createCell(colCount);
				cell.setCellValue(data[rowCount][colCount]);
			}
		}
		
		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(
					"howtodoinjava_write.xlsx"));
			workbook.write(out);
			out.close();
			System.out
					.println("howtodoinjava_demo.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//XSSFWorkbook workbook = new XSSFWorkbook();
	//XSSFSheet sheet = workbook.createSheet("Employee Data");
	//Row row = sheet.createRow(rowCount);
	//Cell cell = row.createCell(colCount);
	//cell.setCellValue(data[rowCount][colCount]);
	//FileOutputStream out = new FileOutputStream(new File("howtodoinjava_out.xlsx"));
	//workbook.write(out);
	//out.close();
}