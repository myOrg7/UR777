package com.urqa.TrailBlazers.Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilies {
	
		public static String filepath=".\\testdata\testData.xlsx";
		public static String value="";
		/**
		 * 
		 * @param sheetname
		 * @param rownum
		 * @param cellnum
		 * @return String
		 * @desc  read the vale from Excel sheet
		 */
		public static String readData(String sheetname,int rownum,int cellnum){
		Workbook wb;
		
			try 
			{
				wb=WorkbookFactory.create(new FileInputStream(new File(filepath)));
				value=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
			} 
			catch (EncryptedDocumentException e) 
			{
				e.printStackTrace();
			} 
			catch (InvalidFormatException e) 
			{
				e.printStackTrace();
			} 
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			return value;
}
}