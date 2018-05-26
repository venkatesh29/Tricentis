package com.Tricentis.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Tricentis.qa.base.TestBase;
import com.Tricentis.qa.util.TestUtil;

public class EnterVehicleData extends TestBase {
	
	@FindBy(xpath=".//*[@id='make']")
	WebElement make;

	@FindBy(xpath=".//*[@id='engineperformance']")
	WebElement engineperformance;
	
	@FindBy(xpath=".//*[@id='dateofmanufacture']")
	WebElement dateofmanufacture;
	
	@FindBy(xpath=".//*[@id='numberofseats']")
	WebElement numberofseats;
	
	@FindBy(xpath=".//*[@id='fuel']")
	WebElement fuel;
	
	@FindBy(xpath=".//*[@id='listprice']")
	WebElement listprice;
	
	@FindBy(xpath=".//*[@id='licenseplatenumber']")
	WebElement licenseplatenumber;
	
	@FindBy(xpath=".//*[@id='annualmileage']")
	WebElement annualmileage;
	
	@FindBy(xpath=".//*[@id='opendateofmanufacturecalender']")
	WebElement opendateofmanufacturecalender;
	
	@FindBy(xpath=".//*[@id='nextenterinsurantdata']")
	WebElement nextenterinsurantdata;
	
	    public EnterVehicleData(WebDriver driver) {
	    	 this.driver=driver;
		     PageFactory.initElements(driver, this);
		}

	    public void selectMake(String type) {
		TestUtil.selectbyvisibletext(type, make);
	    }
	
	    public void Enterengineperformance(String value) {
			TestUtil.entervalue(value, engineperformance);
		}
	    
	    public void selectnumberofseats(String type) {
			TestUtil.selectbyvisibletext(type, numberofseats);
		}
	    
	    public void selectfueltype(String type) {
			TestUtil.selectbyvalue(type,fuel);
		}
	    
	    public void Enterlistprice(String type) {
	    	TestUtil.entervalue(type, listprice);
		}
	    
	    public void Enterlicenseplatenumber(String type) {
	    	TestUtil.entervalue(type, licenseplatenumber);
		}
	    
	    public void Enterannualmileage(String type) {
	    	TestUtil.entervalue(type, annualmileage);
		}
	    
	    public void Clickopendateofmanufacturecalender(String Caldate) {
	    	opendateofmanufacturecalender.click();

	        String array1[]= Caldate.split("/");
	         //System.out.println("Month :"+array1[0]);
	         //System.out.println("Date  :"+array1[1]);
	        //System.out.println("Year  :"+array1[2]);
	        
	        int month=Integer.parseInt(array1[0]);
	        String monthString;
	        switch (month) {
	            case 1:  monthString = "January";
	                     break;
	            case 2:  monthString = "February";
	                     break;
	            case 3:  monthString = "March";
	                     break;
	            case 4:  monthString = "April";
	                     break;
	            case 5:  monthString = "May";
	                     break;
	            case 6:  monthString = "June";
	                     break;
	            case 7:  monthString = "July";
	                     break;
	            case 8:  monthString = "August";
	                     break;
	            case 9:  monthString = "September";
	                     break;
	            case 10: monthString = "October";
	                     break;
	            case 11: monthString = "November";
	                     break;
	            case 12: monthString = "December";
	                     break;
	            default: monthString = "Invalid month";
	                     break;
	        }
	       
	        	        
	       String calyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();       
	       while(!calyear.equals(array1[2])) {
	    	   driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[1]")).click();
	    	   calyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
	       }
	       
	       String calmonth=driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();     
           while(!monthString.equals(calmonth)) {    	    
	    	   driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[1]")).click();
	    	   calmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
	       }
           
          List<WebElement>datetable=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
          for(WebElement singledate:datetable) {
        	  if(singledate.getText().equals(array1[1])){
        		  singledate.click();
        	  }
          }
           
	        
		}
	    
	    public EnterInsurantData clicknextenterinsurantdata() {    	
	    	nextenterinsurantdata.click();
	    	return new EnterInsurantData(driver);
	    }
	    
	
}
