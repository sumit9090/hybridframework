package com.qtpselenium.march2020.util;

import java.util.Hashtable;





public class DataUtil {
	
	
	public static Object[][] getTestData(String testName, Xls_Reader xls){
		// find the row Number of the testcase
		int testStartRowNum=1;
		System.out.println(xls.getCellData(Constants.SheetName_Data, 0, testStartRowNum));
		while(!xls.getCellData(Constants.SheetName_Data, 0, testStartRowNum).equals(testName)){
			testStartRowNum++;
		}
		System.out.println("Row Number of test is "+testStartRowNum );
		// find total cols in testcase
		int colStartRowNum = testStartRowNum+1;
		int totalCols=0;
		while(!xls.getCellData(Constants.SheetName_Data, totalCols, colStartRowNum).equals("")){
			totalCols++;
		}
		System.out.println("Total Cols - "+totalCols );
		// find total rows in testcase
		int dataStartRowNumber=testStartRowNum+2;
		int totalRows=0;
		while(!xls.getCellData(Constants.SheetName_Data, 0, dataStartRowNumber).equals("")){
			totalRows++;
			dataStartRowNumber++;
		}
		System.out.println("Total Rows "+ totalRows);
		
		// read the data
		dataStartRowNumber=testStartRowNum+2;
		Hashtable<String,String> table=null;
		int finalRows = dataStartRowNumber+totalRows;
		Object[][] myData = new Object[totalRows][1];
		int i=0;
		for(int rNum=dataStartRowNumber;rNum<finalRows;rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<totalCols;cNum++){// put data in hashtable
				String data = xls.getCellData(Constants.SheetName_Data, cNum, rNum);
				String key = xls.getCellData(Constants.SheetName_Data, cNum, colStartRowNum);
				//System.out.println(key+" --- "+data);
				table.put(key, data);
			}
			System.out.println(table);
			myData[i][0]=table;
			i++;
			System.out.println("----------------");
		}
		
	return myData;
	
	}
	
	
	
	
	public static boolean isskip(Xls_Reader xls,String testName)
	{
		int rows=xls.getRowCount("TestCases");
		for(int rnum=2;rnum<=rows;rnum++)
		{
			String tcid=xls.getCellData("TestCases", "TCID", rnum);
			
			if(tcid.equals(testName))
			{
				String runmode=xls.getCellData("TestCases", "RunMode", rnum);
				if(runmode.equals("N"))
					return false;
				else return true;
			}
			
			
			
			
			
					
					
		}
		return true;
	}
	
	}


