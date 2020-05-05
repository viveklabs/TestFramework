package test.utils;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class getDataFromExcel {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getExcelData() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
		reader = new Xls_Reader("/home/vivek/eclipse-workspace/TestFramework/src/test/java/TestData/TestData.xlsx");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		for (int rownum =2; rownum<=reader.getRowCount("Sheet1");rownum++){
			
			String url =reader.getCellData("Sheet1", "url", rownum);
			String emailId = reader.getCellData("Sheet1", "emailId", rownum);
			

			
			Object ob[] = {url,emailId};
			myData.add(ob);
	
		}
		
		return myData;
		
	}
	

}
