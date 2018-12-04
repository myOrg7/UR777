package ur.team.Report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

		
public class ResultUtils {
	
	public static int counter  =	1;
	
/*	public static void main(String[] arg) throws InterruptedException{
		ResultUtils.RU_setValueToCell(counter, 0, "TC_1");
		Thread.sleep(5000);
		ResultUtils.RU_setValueToCell(counter, 8, "34.56"); // col 9
		Thread.sleep(5000);
		ResultUtils.RU_setValueToCell(counter, 1, "Tata"); // col 2
		Thread.sleep(5000);
		ResultUtils.RU_setValueToCell(counter, 7, "PASS");// Coal 7 Status
		Thread.sleep(5000);
		ResultUtils.RU_setValueToCell(counter, 4, "Done"); // col 5 Message
		Thread.sleep(5000);
		ResultUtils.RU_setValueToCell(counter, 5, "debug-info"); // col 6
		Thread.sleep(5000);
		ResultUtils.RU_setValueToCell(counter, 2, "True");
		Thread.sleep(5000);
		ResultUtils.RU_setValueToCell(counter, 3, "Titile");
		Thread.sleep(5000);
		ResultUtils.RU_setValueToCell(counter, 6, "TEEW");
		
		getRowCount();
		
		ResultUtils r =  new ResultUtils();
		r.ValueToCell(counter, "TC_1261", "Alpha Test 1", "GiveMe", "Gee", "Getting you 1", "Well Done 1", "snap", "PASS", "5.57");
		r.ValueToCell(counter, "TC_1262", "Alpha Test 2", "A Chance", "GT", "Getting you 2", "Well Done 2", "No snap","FAIL", "2.56");
		r.ValueToCell(counter, "TC_1263", "Alpha Test 3", "To up", "GTV", "Getting you 3", "Well Done 3", "Sorry snap", "PASS", "3.01");
	}*/
	
	
	
	final static String filepath = "C:\\Users\\Utkarsh\\Desktop\\testData.xlsx";//".\\resultData\\resultData.xlsx";
	//static int rowNumber = 1;

	
	 /**
	  * Need to  improve performance of reading and writing the value into cell.
	  *  
	  * @param rowNumber : provide the row number of sheet
	  * @param columNumber : provide the column number of sheet
	  * @param valueToSet : provide value to set at above provided cell
	  */
	//@SuppressWarnings({ "deprecation", "static-access" })
	public static void RU_setValueToCell(int rowNumber, int columnNumber, String valueToSet){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = null;
		
		if(workbook.getSheetName(1).equals("resultStats") |workbook.getSheetName(0).equals("resultStats") )
		{
			//System.out.println("@@@@### Reading sheet");
			sheet = workbook.getSheet("resultStats");
		}
		else
		{	
			sheet = workbook.createSheet("resultStats");
		}
	
		Row row = sheet.createRow(rowNumber);
		//System.out.println("Creating Row :" +rowNumber);
		Cell cell = row.createCell(columnNumber);
		//System.out.println("### creating cell" +columnNumber);
		cell.setCellType(cell.CELL_TYPE_STRING);
		//System.err.println("Setting value: "+valueToSet);
		cell.setCellValue(valueToSet);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filepath);
			workbook.write(fos);
			//System.out.println("writing value to cell");
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find provided file");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to write value into provide sheet");
			e.printStackTrace();
		}
		
		try {
			fos.flush();
			fis.close();
			fos.close();
		} catch (IOException e) {
			System.err.println("Closing/Flushing file(s) get error.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Need to  improve performance of reading and writing the value into cell.
	  *  
	  * @param rowNumber : provide the row number of sheet
	  * @param columNumber : provide the column number of sheet
	  */
	public static String RU_getValueFromCell(int rowNumber, int columnNumber){
		String sheetName= "resultStats";
		String cellValue;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			System.err.println("## Getting Error in reading file");
			e.printStackTrace(); 
		}
		XSSFWorkbook wrkbk = null;
		try {
			wrkbk = new XSSFWorkbook(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		XSSFSheet sheet  = wrkbk.getSheet(sheetName);
		cellValue = sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
		System.out.println("cellValue : "+cellValue);
			
		return cellValue;
	}
	
	
	public static int getRowCount()
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet  = workbook.getSheet("resultStats");
		int totalNumRow = sheet.getLastRowNum();
		
		//System.out.println(totalNumRow);
		
		return totalNumRow;
	}
	
	/**
	 * @param tc_name_or_expectedValue : It is use to evaluate, what message is it going to display. 
	 * @return : it is returns the message to  set in result sheet.
	 */
	public static String RU_setMessage(String tc_name_or_expectedValue){
		String message = "Done";

		if(tc_name_or_expectedValue.toUpperCase().contains("VERIFY")){
			message = "Verified Successfully";
			return message;
		}
		else if(tc_name_or_expectedValue.toUpperCase().contains("VERIFIED")){
			message = "Verified Successfully";
			return message;
		}
		else if(tc_name_or_expectedValue.toUpperCase().contains("VALIDATE")){
			message = "Verified Successfully";
			return message;
		}
		
		return message;	
	}
	
	/**
	 * @param tc_id    : Test Case I'd  
	 * @param tc_name  : 
	 * @param actual   :
	 * @param expected :
	 * @param message  :
	 * @param debugInfo:
	 * @param snap     :
	 * @param status   :
	 * @param time     :
	 */
	/*public static void RU_updatingCellValue(String tc_id, String tc_name, String actual, String expected, String message, String debugInfo, String snap, String status, String time){
		String[] values = {tc_id, tc_name, actual, expected, message, debugInfo, snap, status, time};
		
		for(int col = 0; col<=8;col++){
			RU_setValueToCell(rowNumber,col, values[col]);
		}
		rowNumber+=1;
	}*/
	
	public static void RU_generateReport(String... getCellValue){
		
	}
	
	public void ValueToCell(int rowNumber, String tc_id, String tc_name, String actual, String expt, String message, String debug, String snap, String status, String time){
		FileInputStream fis = null;
		String[] value ={tc_id, tc_name, actual, expt, message, debug, snap, status, time};
	
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = null;
		
		if(workbook.getSheetName(1).equals("resultStats") |workbook.getSheetName(0).equals("resultStats") )
		{
			//System.out.println("@@@@### Reading sheet");
			sheet = workbook.getSheet("resultStats");
		}
		else
		{	
			sheet = workbook.createSheet("resultStats");
		}
		
		Row row = sheet.createRow(rowNumber);
		//System.out.println("Creating Row :" +rowNumber);
		for (int i = 0; i < value.length; i++) {
			Cell cell = row.createCell(i);
			//System.out.println("### creating cell" +cell);
			cell.setCellType(cell.CELL_TYPE_STRING);
			//System.out.println("Setting value: "+value[i]);
			cell.setCellValue(value[i]);
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filepath);
			workbook.write(fos);
			//System.out.println("writing value to cell");
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find provided file");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to write value into provide sheet");
			e.printStackTrace();
		}
		
		try {
			fos.flush();
			fis.close();
			fos.close();
		} catch (IOException e) {
			System.err.println("Closing/Flushing file error.");
			e.printStackTrace();
		}
		
		counter += 1;
	}
}
