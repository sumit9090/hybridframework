package com.qtpselenium.march2020.bASE;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;

import com.qtpselenium.march2020.driver.DriverScript;
import com.qtpselenium.march2020.util.Xls_Reader;

public class BaseTest {
	
	public Properties envprop;
	public Properties prop;//env.properties
	public Xls_Reader xls;
	public String testName;
	public DriverScript ds;
	
	
	
	
	@AfterMethod
	public void initTest()
	{
		ds.quit();
	}
	
	
	
	
	
	
	@BeforeTest
	public void init()
	{
		
		String arr[]=this.getClass().getPackage().getName().split("\\.");
		String suitename=arr[arr.length-1];
		System.out.println(suitename);
		
		
		prop=new Properties();
		envprop=new Properties();
		try {
			FileInputStream fn=new FileInputStream("D:\\mydata\\workspace\\hybridframeworkmarch2020\\src\\test\\resources\\env.properties");
			prop.load(fn);
			
			
			
			
			String enviroment=prop.getProperty("env");
			System.out.println(enviroment);
			
			
			fn=new FileInputStream("D:\\mydata\\workspace\\hybridframeworkmarch2020\\src\\test\\resources\\"+enviroment+".properties");
			envprop.load(fn);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		xls=new Xls_Reader(envprop.getProperty(suitename+"_xls"));
		
		ds=new DriverScript();//initialize DriverScript
		ds.setEnvprop(envprop);
		ds.setProp(prop);
		
	}

}
