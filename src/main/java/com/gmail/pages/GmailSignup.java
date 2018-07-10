package com.gmail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.base.TestBase;
import com.gmail.util.UtilityClass;

public class GmailSignup extends TestBase {

	//Screen 1
	@FindBy(xpath=".//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath=".//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath=".//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath=".//*[@id='passwd']/div[1]/div/div[1]/input")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='confirm-passwd']/div[1]/div/div[1]/input")
	WebElement confirmPassword;
	
	@FindBy(xpath=".//*[@id='accountDetailsNext']")
	WebElement btnNext;
	
	//Screen 2
	@FindBy(xpath=".//*[@id='phoneNumberId']")
	WebElement phnNumber;
	
	@FindBy(xpath=".//*[@id='view_container']/form/div[2]/div/div[2]/div/div[1]/div/div[1]/input")
	WebElement recoveryEmail;
	
	@FindBy(xpath=".//*[@id='month']")
	WebElement month;
	
	@FindBy(xpath=".//*[@id='day']")
	WebElement day;
	
	@FindBy(xpath=".//*[@id='year']")
	WebElement year;
	
	@FindBy(xpath=".//*[@id='gender']")
	WebElement gender;
	
	@FindBy(xpath=".//*[@id='personalDetailsNext']")
	WebElement btnNext2;	
	
	
	public GmailSignup()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signUp1(String FirstName,String LastName,String UserName,String Password,String ConfirmPass ) throws InterruptedException
	{
		firstName.sendKeys(FirstName);
		UtilityClass.threadSleep(3000);
		lastName.sendKeys(LastName);
		UtilityClass.threadSleep(3000);
		userName.clear();
		userName.sendKeys(UserName);
		UtilityClass.threadSleep(3000);
		password.sendKeys(Password);
		UtilityClass.threadSleep(3000);
		confirmPassword.sendKeys(ConfirmPass);
		UtilityClass.threadSleep(3000);
		btnNext.click();
	}
	
	public void signUp2(String PhoneNum,String RecMail,String Month, String Day, String Year,String Gender) throws InterruptedException
	{
		UtilityClass.threadSleep(3000);
		phnNumber.sendKeys(PhoneNum);
		UtilityClass.threadSleep(3000);
		recoveryEmail.sendKeys(RecMail);
		UtilityClass.threadSleep(3000);
		month.sendKeys(Month);
		UtilityClass.threadSleep(3000);
		day.sendKeys(Day);
		UtilityClass.threadSleep(3000);
		year.sendKeys(Year);
		UtilityClass.threadSleep(3000);
		gender.sendKeys(Gender);
		UtilityClass.threadSleep(3000);
		btnNext2.click();		
	}
	
}
