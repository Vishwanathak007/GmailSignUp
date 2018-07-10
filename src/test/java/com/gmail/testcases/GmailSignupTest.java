package com.gmail.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.gmail.base.TestBase;
import com.gmail.pages.GmailSignup;
import com.gmail.util.UtilityClass;

public class GmailSignupTest extends TestBase {
	
	public GmailSignup gmailsignup;
	String sheetName1="signup1";
	String sheetName2="signup2";
	
	public GmailSignupTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
	}
	
	@Test(priority=1,dataProvider="getTestData1")
	public void gmailSignupTest1(String FN,String LN,String UN,String PWD,String CNFPWD) throws InterruptedException
	{
		gmailsignup=new GmailSignup();
		gmailsignup.signUp1(FN, LN, UN, PWD, CNFPWD);
	}
	
	/*@Test(priority=2,dataProvider="getTestData2")
	public void gmailSignupTest2(String PHNNUM,String RECEMAIL,String MONTH,String DAY,String YEAR,String GEN) throws InterruptedException
	{
		gmailsignup=new GmailSignup();
		gmailsignup.signUp2(PHNNUM, RECEMAIL, MONTH, DAY, YEAR, GEN);
	}*/
	
	@DataProvider
	public Object[][] getTestData1()
	{
		Object[][] signupData=UtilityClass.getTestData(sheetName1);
		System.out.println("Data pulled"+"\n "+signupData);
		return signupData;
	}
	
	@DataProvider
	public Object[][] getTestData2()
	{
		Object[][] signupData=UtilityClass.getTestData(sheetName2);
		return signupData;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
