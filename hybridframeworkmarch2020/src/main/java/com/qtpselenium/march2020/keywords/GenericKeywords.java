package com.qtpselenium.march2020.keywords;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class GenericKeywords {
	public Properties envprop;
	public Properties prop;//env.properties
	public String objectkey;
	public String datakey;
	public Hashtable<String,String>data;
	public WebDriver driver;
	
	
	
	
	
	
	
	
	public void setEnvprop(Properties envprop) {
		this.envprop = envprop;
		
	}
	
	
	
	

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void setObjectkey(String objectkey) {
		this.objectkey = objectkey;
	}

	public void setDatakey(String datakey) {
		this.datakey = datakey;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}
	
public WebElement getElement(String object) throws IOException {
		
		WebElement e = null;
		try {
			if (object.endsWith("_xpath")) {
				e = driver.findElement(By.xpath(prop.getProperty(object)));
			}
			
			else if (object.endsWith("_id")) {
				e = driver.findElement(By.id(prop.getProperty(object)));
				
			}
			
			else if(object.endsWith("name"))
			{
				e = driver.findElement(By.name(prop.getProperty(object)));
			}
			
			else if(object.endsWith("class"))
			{
				e = driver.findElement(By.className(prop.getProperty(object)));
			}
			
			
			
			
			
		} catch (Exception ex) {
			
			
			

		}
		return e;

}

	public void openBrowser()
	{
		System.out.println("opening browser--"+data.get(datakey));
		String browser=data.get(datakey);
		if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		
		if(browser.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	
	
	
	public void type() throws IOException
	{
		System.out.println("typing in..."+prop.getProperty(objectkey));
		getElement(objectkey).sendKeys(data.get(datakey));
		
	}
	public void navigate()
	{
		System.out.println("navigating to.."+envprop.getProperty(objectkey));
		driver.get(envprop.getProperty(objectkey));
	}
	
	public void click() throws IOException
	{
		System.out.println("clicking.."+prop.getProperty(objectkey));
		getElement(objectkey).click();
		
	}
	
	public void quit() {
		if(driver!=null)
		driver.quit();
		
	}

	


}
