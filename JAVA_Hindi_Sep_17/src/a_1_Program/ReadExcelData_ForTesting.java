package a_1_Program;

import java.util.Hashtable;
import Base.Xls_Reader;

public class ReadExcelData_ForTesting {
	public static Object[][] getdata(Xls_Reader xls,String TC,String sheetName_File){
		
		String sheetName = sheetName_File;
		int testStart=1;
		while(!xls.getCellData(sheetName, testStart, testStart).equals(TC)){
			testStart++;
		}System.out.println(testStart);
		
		int rowStart=testStart+2;
		int colStart=testStart+1;
		int row=0;
		while(!xls.getCellData(sheetName, 0, rowStart+row).equals("")){
			row++;
		}System.out.println(row);
		
		int col=0;
		while(!xls.getCellData(sheetName, col, colStart).equals("")){
			col++;
		}System.out.println(col);
		
		Object[][] data=new Object[row][1];
		int RD=0;
		Hashtable<String,String> tab=null;
		for(int r=rowStart;r<rowStart+row;r++){
			tab=new Hashtable<String,String>();
			for(int c=0;c<col;c++){
				String key = xls.getCellData(sheetName, c, colStart);
				String value = xls.getCellData(sheetName, c, r);
				tab.put(key, value);
			}
			data[RD][0]=tab;
			RD++;
		}
		return data;
	}
}
