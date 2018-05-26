package com.Tricentis.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Tricentis.qa.ExcelUtility.Xlreader;
import com.Tricentis.qa.util.TestUtil;

public class TestBase {
	
	public WebDriver driver	;
	public Properties prop;
	
	public TestBase() {
		try {
			prop=new Properties();
			
			FileInputStream fis=new FileInputStream("E:\\SeleniumLab\\TricentisFramework\\src\\main\\java\\com\\"
				+ "Tricentis\\qa\\config\\config.properties");
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//
//	
	public void Initialization() {
		String browsername=prop.getProperty("browsername");
		
		if(browsername.equals("Firefox"))	
			driver=new FirefoxDriver();		
		else {
			System.setProperty("webdriver.chrome.exe",System.getProperty("user.dir")+"\\main\\java\\com\\"
					+ "Tricentis\\qa\\drivers\\chrome.exe");
			driver=new ChromeDriver();		
		     }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));	
	}
	
	    public void getrunmode() throws IOException {
		Xlreader xlreader = new Xlreader(prop.getProperty("FilePath"));
		int Runmoderowcount=xlreader.getRowCount("Runmode");
		    for(int i=0;i<Runmoderowcount;i++) {
			String testcaserunmode=xlreader.getCellData("Runmode",i,1);
			String testcasenumber=xlreader.getCellData("Runmode",i,0);
			    if(testcaserunmode.equalsIgnoreCase("Y")) 
				xlreader.testCaseRow("Runmode", testcasenumber);				
		}
		
		
	}
	
}
