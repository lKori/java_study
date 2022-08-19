package AutoMacro;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReadFile {
	
	public static final String BASE_PATH = new File("").getAbsolutePath();
	public static String RESOURCE_PATH = "\\datasheet";
	public static String FILE_NAME = "\\price.xlsx";
	public static String FILE_PATH;
	public static FileInputStream FIS = null;
	public static XSSFWorkbook WORKBOOK = null;
	public static XSSFSheet SHEET = null;
	public static Integer SHEET_NUM = 1;	// sheet 1: NVME, sheet 2: Enterprise
	public static Integer PRODUCT_COUNT = 0;

	public String[] ReadPrice(int count) {
		String[] product = new String[2];
		
		try {
			XSSFRow row = SHEET.getRow(count);
			if(row != null) {
				for(int columnIndex = 1; columnIndex < 3; columnIndex++) {
					XSSFCell cell = row.getCell(columnIndex);	// 상품 이름 및 가격 읽어오기
					
					switch(cell.getCellType()) {
					case NUMERIC:
						int price = (int) cell.getNumericCellValue();	// 상품 가격
						product[1] = String.valueOf(price);
						System.out.println(product[1]);
						break;
					case STRING:
						product[0] = cell.getStringCellValue() + "";	// 상품 이름
						System.out.println(product[0]);
						break;
					case BLANK:
						System.out.println(count + "Data Blank");
						break;
					case ERROR:
						System.out.println(count + "Data Error");
						break;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public void ProductCheck() {
		// 가격표 엑셀 파일 초기화
		try {
//			FIS = new FileInputStream(DATASHEET_PATH);
			FILE_PATH = BASE_PATH + RESOURCE_PATH + FILE_NAME;
			System.out.println(FILE_PATH);
			FIS = new FileInputStream(FILE_PATH);
			WORKBOOK = new XSSFWorkbook(FIS);
			SHEET = WORKBOOK.getSheetAt(SHEET_NUM);
			PRODUCT_COUNT = SHEET.getPhysicalNumberOfRows();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
