package com.qtpselenium.march2020.suitea;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.march2020.bASE.BaseTest;
import com.qtpselenium.march2020.reports.ExtentManager;
import com.qtpselenium.march2020.util.DataUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class loginTest extends BaseTest {
	String testName="LoginTest";
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data)
	
	{
		
		ExtentReports rep=ExtentManager.getInstance();
		ExtentTest test=rep.startTest("LoginTest");
		test.log(LogStatus.INFO, "starting the test");
		test.log(LogStatus.INFO, data.toString());
		rep.flush();
		
	
		if(data.get("RunMode").equals("N"))
			throw new SkipException("skipping as runMode is N");
			
		
		
		
		
		
		System.out.println("test");
		
		ds.executescript(testName, xls, data);
	}
	
	@DataProvider
	public 	Object[][] getData()
	{
		
		
		return DataUtil.getTestData(testName,xls);
		

	}
	
}
