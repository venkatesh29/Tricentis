package com.Tricentis.qa.util;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Tricentis.qa.ExcelUtility.Xlreader;
import com.Tricentis.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=70;
	public static long IMPLICIT_WAIT=10;
	
	public static void selectbyvisibletext(String value,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(value);		
	}
	
	public static void selectbyvalue(String value,WebElement element) {
		Select s=new Select(element);
		s.selectByValue(value);	
	}
	
	public static void selectbyindex(int index,WebElement element) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
		
	public static void entervalue(String value,WebElement element) {
		element.sendKeys(value);		
	}	
	
	        public static Object[][] DataUtil(String FilePath,String SheetName,String TestCase) throws IOException { 	        	
	    	int testCaseRowNumber;
	    	Object[][] data = new Object[1][1];
		    Xlreader xl = new Xlreader(FilePath);
		    testCaseRowNumber=xl.testCaseRow(SheetName, TestCase);		   
		    HashMap<String,String>tdata=xl.gettestdata(SheetName, testCaseRowNumber);	 
		    data[0][0]=tdata;	    
	        return data;}
	        
	        public static void clickRadioButton(WebElement element) {
	    		element.click();		
	    	}
	        
	        public static void clickCheckBox(WebElement element) {
	        	
	    		element.click();		
	    	}
	
}
