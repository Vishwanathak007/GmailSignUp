package com.gmail.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SikuliFB {
	
	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	Screen screen;
	Pattern email;
	Pattern password;
	Pattern btn_login;
	Pattern arrow_logout;
	Pattern btn_logout;
	Pattern btn_allow;

	@BeforeMethod
	public void setUp() throws IOException
	{
		//Sikuli Objects
		 screen=new Screen();
		 email=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\email.png");
		 password=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\password.png");
		 btn_login=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\btn_login.png");
		 arrow_logout=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\arrow_logout.png");
		 btn_logout=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\btn_logout.png");
		 btn_allow=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\btn_allow.png");
		
		//Property file code
		 prop=new Properties();
		 fis=new FileInputStream("C:\\Workspace\\GmailSignUp\\src\\main\\java\\com\\gmail\\testdata\\config.properties");
		prop.load(fis);
		
		//Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("fblink"));
	}
	
	@Test
	public void login_logout_test() throws InterruptedException, FindFailed
	{
		//Login
		screen.wait(email,10);
		screen.type(email,prop.getProperty("fbEmail"));
		Thread.sleep(3000);
		screen.type(password,prop.getProperty("fbPwd"));
		Thread.sleep(3000);
		screen.click(btn_login);
		Thread.sleep(3000);
		
		//Logout		
		//Alert alert = driver.switchTo().alert();
		//alert.accept();	
		screen.click(btn_allow);
		Thread.sleep(3000);
		screen.click(arrow_logout);
		Thread.sleep(3000);
		screen.click(btn_logout);
		Thread.sleep(3000);
	}
		
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}	

}
