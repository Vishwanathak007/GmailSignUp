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

public class SikuliFB {

	public static void main(String[] args) throws IOException, FindFailed, InterruptedException {
		//Sikuli Objects
		Screen screen=new Screen();
		Pattern email=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\email.png");
		Pattern password=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\password.png");
		Pattern btn_login=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\btn_login.png");
		Pattern arrow_logout=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\arrow_logout.png");
		Pattern btn_logout=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\btn_logout.png");
		Pattern btn_allow=new Pattern("C:\\Workspace\\GmailSignUp\\sikuli_images\\fb\\btn_allow.png");
		
		//Property file code
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Workspace\\GmailSignUp\\src\\main\\java\\com\\gmail\\testdata\\config.properties");
		prop.load(fis);
		
		//Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("fblink"));
		
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
		driver.quit();
		

	}

}
