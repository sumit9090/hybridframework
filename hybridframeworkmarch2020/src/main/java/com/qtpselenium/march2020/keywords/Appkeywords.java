package com.qtpselenium.march2020.keywords;

import java.util.Properties;

public class Appkeywords extends GenericKeywords {
	
	public void validatelogin()
	{
		System.out.println("validating ..."+prop.getProperty(objectkey));
	}

	public void defaultlogin()
	{
	String defaultusername=envprop.getProperty("adminusername");
	String defaultpassword=envprop.getProperty("adminpassword");
	System.out.println("default username is "+defaultusername);
	System.out.println("default password is "+defaultpassword);
	}
	

}
