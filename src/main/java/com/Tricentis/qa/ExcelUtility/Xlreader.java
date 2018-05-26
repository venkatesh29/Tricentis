package com.Tricentis.qa.ExcelUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Tricentis.qa.util.TestUtil;

public class Xlreader {
	public String filePath;
	String fileExtension;
	FileInputStream fis;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	
	public Xlreader(String filePath) throws IOException {
		
		 this.filePath=filePath;
		 fileExtension=filePath.substring(filePath.indexOf(".x"));
		 
		 try {
			 fis=new FileInputStream(filePath);
		 if(fileExtension.equalsIgnoreCase(".xlsx")) {
			 workbook=new XSSFWorkbook(fis);
		 }else if(fileExtension.equalsIgnoreCase(".xls")){
			 workbook=new HSSFWorkbook(fis);
			 
		 }}catch(Exception e) {
			 e.printStackTrace();
		 }finally{
			 fis.close();
		 }
	}
	
	// returns the row count in a sheet
	public int getRowCount(String sheetname){
		sheet=workbook.getSheet(sheetname);
		int rowsCount=sheet.getLastRowNum();
		return rowsCount;
	}
	
	public String getCellData(String sheetname,int rowNum,int colNum) {	
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA) {
			//return String.valueOf((int)cell.getNumericCellValue());
			return String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_BLANK) {
			return " ";
		}
		else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN) {
		return String.valueOf(cell.getBooleanCellValue());}
		else 
			return String.valueOf(cell.getDateCellValue());
	}
	
	
	public int testCaseRow(String sheetname,String TestCase) {	
		sheet=workbook.getSheet(sheetname);	
		int rowsCount=sheet.getLastRowNum();
		int ActualRowNumber=-1;	
		for(int i=1;i<=rowsCount;i++) {
			row=sheet.getRow(i);
		    cell=row.getCell(0);
			if(cell.getStringCellValue().equalsIgnoreCase(TestCase)) {
				ActualRowNumber=i;
				break;
			}
		}		
		return ActualRowNumber;
 }
	
	public HashMap<String,String> gettestdata(String sheetname,int testCaseRowNumber) {
		
		 HashMap<String,String> testdata=new HashMap<String,String>();	 
		 sheet=workbook.getSheet(sheetname);		 
		 int ColCount=sheet.getRow(0).getLastCellNum();		
		
		 String headerrowdata=null;
		 String actualrowdata=null;
		 for(int i=0;i<ColCount;i++) {				 
			  headerrowdata=getCellData(sheetname, 0, i);
			  actualrowdata=getCellData(sheetname, testCaseRowNumber, i);	
			 // System.out.println(headerrowdata+"  "+actualrowdata);
			  testdata.put(headerrowdata, actualrowdata);	
			  
		 }
		 return testdata;
		 	
	}
	
	
	
}
