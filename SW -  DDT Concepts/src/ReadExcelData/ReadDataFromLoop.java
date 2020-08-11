package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromLoop {

	public static void main(String[] args) throws Exception {
		File src = new File("D:\\LTI Selenium Samples\\Apache TestData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rowcount = sheet1.getLastRowNum();
		 System.out.println("Total Rows in ExcelSheet ++++++....  " + rowcount);
		 
		 for(int i = 0; i<=rowcount; i++)
		 {
			 String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
			 System.out.println("Data from Row ******.. " + i + "  is  " +  data0);
		 }
		 wb.close();
	}
	
   
}
