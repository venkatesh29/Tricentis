package com.Tricentis.qa.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Tricentis.qa.ExtentReports.ExtentManager;
import com.Tricentis.qa.base.TestBase;
import com.Tricentis.qa.pages.EnterVehicleData;
import com.Tricentis.qa.pages.HomePage;
import com.Tricentis.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class extenterinsurantdata extends TestBase {
	EnterVehicleData ed;
	ExtentReports ereport;
	ExtentTest eTest;
	String FilePath="E:\\SeleniumLab\\TricentisFramework\\src\\main\\java\\com\\Tricentis\\qa\\testdata\\ExcelXLS.xls";
	String SheetName="EnterVehicleData";
	String TestCase="TC_ID_5";
	
	
	public extenterinsurantdata() {
		super();	
	}
	
	@BeforeMethod
	public void Setup() {
		Initialization();	
	}
	
	@DataProvider(name="Data")    
    public  Object[][] dData() throws IOException{	
//		String FilePath="E:\\SeleniumLab\\TestProject\\src\\TestPackage\\ExcelXLS.xls";
//		String SheetName="EnterVehicleData";
//		String TestCase="TC_ID_5";
        Object[][] testdata=TestUtil.DataUtil(FilePath, SheetName, TestCase);
		return testdata;      		
	}
		
		@Test(dataProvider="Data")
        public void EnterForm(HashMap<String,String> ddata) throws InterruptedException {		
			HomePage hp=new HomePage(driver);
			 ereport= ExtentManager.getInstance(TestCase);
			 eTest=ereport.startTest("TC_ID_5 Test");
			 
			ed=hp.clickAutomobile();
			eTest.log(LogStatus.INFO, "Clicked Automobile link in HomePage");
			
			ed.selectMake(ddata.get("Make"));	
			eTest.log(LogStatus.INFO, "Selected a value in Make Select List");
			
			ed.selectfueltype(ddata.get("FuelType"));
			eTest.log(LogStatus.INFO, "Selected a value in FuelType Select List");
			
			ed.Enterengineperformance(ddata.get("EnginePerformance"));
			eTest.log(LogStatus.INFO, "Entered a value in Engine Performance Input Field");
			
			ed.selectnumberofseats(ddata.get("NumberOfSeats"));
			eTest.log(LogStatus.INFO, "Selected a value in Numberofseats Select List");
			
			ed.Enterlistprice(ddata.get("ListPrice"));
			eTest.log(LogStatus.INFO, "Entered a value in Listprice Input Field");
			
			ed.Enterlicenseplatenumber(ddata.get("LicensePlateNumber"));
			eTest.log(LogStatus.INFO, "Entered a value in LicensePlateNumber Input Field");
			
			ed.Enterannualmileage(ddata.get("AnnualMileage"));
			eTest.log(LogStatus.INFO, "Entered a value in AnnualMileage Input Field");
			
			String caldate=ddata.get("DateOfManufacture");
			
			ed.Clickopendateofmanufacturecalender(ddata.get("DateOfManufacture"));
			eTest.log(LogStatus.INFO, "Clicked DateOfManufacture link");
			
			ed.clicknextenterinsurantdata();
			eTest.log(LogStatus.INFO, "Clicked Next Button");
//        	String x=ddata.get("Order Date");
//        	String y=ddata.get("Ship Date");       	
//        	double aDouble1 = Double.parseDouble(x);
//        	double aDouble2 = Double.parseDouble(y);
//        	System.out.println("Double value is : "+(aDouble1+aDouble2));    	
        }  
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
        ereport.endTest(eTest);
    	ereport.flush();
	}
}
