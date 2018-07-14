package com.gmail.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class SikuliSignIn {

	public static void main(String[] args) throws FindFailed, InterruptedException, IOException {
		
		//Sikuli Classes and Objects
		Screen screen=new Screen();
		Pattern home_signIn=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\home_signin.png");
		Pattern email=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\email.png");
		Pattern password=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\password.png");
		Pattern btn_Next=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\btn_Next.png");
		Pattern arrow_logout=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\arrow_logout.png");
		Pattern btn_logout=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\btn_logout.png");
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Workspace\\GmailSignUp\\src\\main\\java\\com\\gmail\\testdata\\config.properties");
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("urllink"));
		
		screen.wait(home_signIn,10);
		screen.click(home_signIn);
		Thread.sleep(3000);
		screen.type(email,"ERP@vrkp.in");
		Thread.sleep(3000);
		screen.click(btn_Next);	
		Thread.sleep(4000);
		screen.type(password,"ERP@12345");
		Thread.sleep(3000);
		screen.click(btn_Next);
		Thread.sleep(5000);
		screen.click(arrow_logout);
		Thread.sleep(3000);
		//driver.switchTo().alert();
		screen.click(btn_logout);
		Thread.sleep(3000);
		driver.quit();	
		
		
	}

}
