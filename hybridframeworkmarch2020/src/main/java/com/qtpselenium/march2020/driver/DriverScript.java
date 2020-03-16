package com.qtpselenium.march2020.driver;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;



import com.qtpselenium.march2020.keywords.Appkeywords;
import com.qtpselenium.march2020.util.Xls_Reader;

public class DriverScript {
	public Properties envprop;
	public Properties prop;//env.properties
	public Appkeywords app;

	public void executescript(String testName,Xls_Reader xls,Hashtable<String,String> testdata) 
	{
		int rows=xls.getRowCount("keywords");
		app=new Appkeywords();//initialize appkeywords class
		app.setEnvprop(envprop);
		app.setProp(prop);
		app.setData(testdata);
		
		for(int rnum=2;rnum<=rows;rnum++ )
		{
			
				String tcid=xls.getCellData("keywords", "TCID", rnum);
				if(tcid.equals(testName))
				{
					String keywords=xls.getCellData("keywords", "Keyword", rnum);
					String objectkey=xls.getCellData("keywords", "Object", rnum);
					String datakey=xls.getCellData("keywords", "Data", rnum);
					String data=testdata.get(datakey);
					
					app.setObjectkey(objectkey);
					app.setDatakey(datakey);
					
					
					
					
					//System.out.println(tcid+"---"+keywords+"----"+objectkey+"---"+data);
					
					System.out.println(tcid+"---"+keywords+"----"+prop.getProperty(objectkey)+"---"+data);
					
					
					/*
					if(keywords.equals("openBrowser"))
						app.openBrowser();
					else if (keywords.equals("navigate"))
						app.navigate();
					else if (keywords.equals("click"))
						app.click();
					else if (keywords.equals("type"))
						app.type();
					
					*/
					
					
					Method method;
					try
					{
						method = app.getClass().getMethod(keywords);
						method.invoke(app);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				}
		
		}
}

	public Properties getEnvprop() {
		return envprop;
	}

	public void setEnvprop(Properties envprop) {
		this.envprop = envprop;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void quit() {
		
		app.quit();
	}

	
	
	
	
	
}
