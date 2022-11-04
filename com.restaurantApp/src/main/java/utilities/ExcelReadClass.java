package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReadClass {
	
	public static FileInputStream f;
	public static XSSFWorkbook b;
	public static XSSFSheet s;
	
	public static String readStringData(int i,int j) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelSheet.xlsx");
		b = new XSSFWorkbook(f);
		s = b.getSheet("Sheet1");
		Row r = s.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}	
		public static String readIntegerData(int i,int j) throws IOException {
			f = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelSheet.xlsx");
			b = new XSSFWorkbook(f);
			s = b.getSheet("Sheet1");
			Row r = s.getRow(i);
			Cell c = r.getCell(j);
			int a = (int) c.getNumericCellValue();
			return String.valueOf(a);		
		
	}

}
