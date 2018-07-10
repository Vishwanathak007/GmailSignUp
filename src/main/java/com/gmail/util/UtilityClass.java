package com.gmail.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import com.gmail.base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class UtilityClass extends TestBase{
	
	public static String TESTDATA_FILE_PATH="C:\\Workspace\\GmailSignUp\\src\\main\\java\\com\\gmail\\testdata\\GmailSignup_TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static void implicitWait(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
	
	public static void threadSleep(int sleepTime) throws InterruptedException
	{
		Thread.sleep(sleepTime);
	}
	
	//GetData From Excel
		public static Object[][] getTestData(String sheetName)
		{
			FileInputStream fis=null;
			
			try {
			fis=new FileInputStream(TESTDATA_FILE_PATH);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				book=WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {			
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			sheet=book.getSheet(sheetName);
			Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0; i<sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					System.out.println(data);
				}			
			}
			return data; 		
			
		}

}
