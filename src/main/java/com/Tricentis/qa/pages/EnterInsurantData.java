package com.Tricentis.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Tricentis.qa.base.TestBase;
import com.Tricentis.qa.util.TestUtil;

public class EnterInsurantData extends TestBase {
	
	@FindBy(xpath=".//*[@id='firstname']")
	WebElement firstname;
	
	@FindBy(xpath=".//*[@id='lastname']")
	WebElement lastname;
	
	@FindBy(xpath=".//*[@id='birthdate']")
	WebElement birthdate;
	
	@FindBy(xpath=".//input[@type='radio'][@value='Male']")
	WebElement Male;
	
	@FindBy(xpath=".//input[@type='radio'][@value='Female']")
	WebElement Female;
	
	@FindBy(xpath=".//*[@id='streetaddress']")
	WebElement streetaddress;
	
	@FindBy(xpath=".//*[@id='country']")
	WebElement country;
	
	@FindBy(xpath=".//*[@id='zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath=".//*[@id='occupation']")
	WebElement occupation;
	
	@FindBy(xpath=".//*[@id='city']")
	WebElement city;
	
	@FindBy(xpath="(//p[@class='group'])[2]")
	WebElement hobbies;
	
	@FindBy(xpath=".//*[@id='website']")
	WebElement website;
	
//	@FindBy(xpath=".//*[@id='picture']")
//	WebElement picture;
	
	@FindBy(xpath=".//*[@id='preventervehicledata']")
	WebElement preventervehicledata;
	
	@FindBy(xpath=".//*[@id='nextenterproductdata']")
	WebElement nextenterproductdata;
	
	public EnterInsurantData(WebDriver driver) {
		 this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	 public void Enterfirstname(String value) {
		TestUtil.entervalue(value, firstname);
	 }
	
	 public void Enterlastname(String value) {
		TestUtil.entervalue(value, lastname);
	 }
	 public void Enterbirthdate(String value) {
			TestUtil.entervalue(value, birthdate);
	 }
	 public void ClickGenderMale() {
			TestUtil.clickRadioButton(Male);
	 }
	 public void ClickGenderFemale() {
			TestUtil.clickRadioButton(Female);
	 }
	 public void EnterAddress(String value) {
			TestUtil.entervalue(value, streetaddress);
	 }
	 public void selectCountry(String type) {
		 TestUtil.selectbyvisibletext(type, country);
	 }
	 public void EnterZipCode(String value) {
			TestUtil.entervalue(value, zipcode);
	 }
	 public void EnterCity(String value) {
			TestUtil.entervalue(value, city);
	 }
	 public void selectoccupation(String type) {
		 TestUtil.selectbyvisibletext(type, occupation);
	 }
	 public void setCheckbox(String type) {
		 TestUtil.clickCheckBox(occupation);
	 }
	
	
}
