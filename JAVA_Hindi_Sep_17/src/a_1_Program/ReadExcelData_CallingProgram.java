package a_1_Program;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Xls_Reader;

public class ReadExcelData_CallingProgram {
	public Xls_Reader xl;
	public String testCaseName ="Login";
	public String testdata="data";
	@Test(dataProvider="getDataText")
	public void readTestCase(Hashtable<String,String> da){
		System.out.println(da.get("Browser")+" "+da.get("UserName"));
	}
	
	@DataProvider
	public Object[][]  getDataText(){
		xl=new Xls_Reader("D://report//TestData.xlsx");
		return ReadExcelData_ForTesting.getdata(xl, testCaseName, testdata);
	}
}
