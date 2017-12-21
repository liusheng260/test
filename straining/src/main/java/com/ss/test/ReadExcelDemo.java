package com.ss.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {

	public static void main(String[] args) throws Exception {
		Workbook wb = new XSSFWorkbook(new FileInputStream(new File("/Users/liusheng/eclipse-workspace/straining/src/test/resources/loginTestData.xlsx")));
		Sheet sheet = wb.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(lastRowNum).getLastCellNum();
		//System.out.println(sheet.getRow(lastRowNum).getCell(lastCellNum-1).getStringCellValue());
		for(int i=0;i<=lastRowNum;i++) {
			for(int j=0;j<lastCellNum;j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"\t");
			}
			System.out.println();
		}
		wb.close();
	}

}
