package com.Tricentis.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Tricentis.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath=".//*[@id='nav_automobile']")
	WebElement Automobile;
	
	@FindBy(xpath=".//*[@id='nav_truck']")
	WebElement Truck;
	
	@FindBy(xpath=".//*[@id='nav_motorcycle']")
	WebElement Motorcycle;
	
	@FindBy(xpath=".//*[@id='nav_camper']")
	WebElement Camper;
	
	
	public HomePage(WebDriver driver) {	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public EnterVehicleData clickAutomobile() throws InterruptedException {

		
       WebDriverWait wait = new WebDriverWait(driver, 50);
 
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Automobile));
		Automobile.click();
		return new EnterVehicleData(this.driver);
		
	}
	public void clickTruck() {
		Truck.click();
	}
	public void clickMotorcycle() {
		Motorcycle.click();
	}
	public void clickCamper() {
		Camper.click();
	}
	

}
