package com.gmail.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SikuliSignIn {
    
	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	Screen screen;
	Pattern home_signIn;
	Pattern email;
	Pattern password;
	Pattern btn_Next;
	Pattern arrow_logout;
	Pattern btn_logout;
	
		@BeforeMethod
		public void setUp() throws IOException
		{
		//Sikuli Classes and Objects
	     screen=new Screen();
		 home_signIn=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\home_signin.png");
		 email=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\email.png");
		 password=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\password.png");
		 btn_Next=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\btn_Next.png");
		 arrow_logout=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\arrow_logout.png");
		 btn_logout=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\btn_logout.png");
		
		 prop=new Properties();
		 fis=new FileInputStream("C:\\Workspace\\GmailSignUp\\src\\main\\java\\com\\gmail\\testdata\\config.properties");
		 prop.load(fis);
		
	 	 System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		 driver=new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("urllink"));
		}
		
		@Test
		public void login_logout_test() throws InterruptedException, FindFailed
		{
		screen.wait(home_signIn,10);
		screen.click(home_signIn);
		Thread.sleep(3000);
		screen.type(email,prop.getProperty("email"));
		Thread.sleep(3000);
		screen.click(btn_Next);	
		Thread.sleep(4000);
		screen.type(password,prop.getProperty("password"));
		Thread.sleep(3000);
		screen.click(btn_Next);
		Thread.sleep(5000);
		screen.click(arrow_logout);
		Thread.sleep(3000);
		//driver.switchTo().alert();
		screen.click(btn_logout);
		Thread.sleep(3000);
		}
		
		@AfterMethod
		public void closeBrowser()
		{
		driver.quit();	
		}
		
	

}
