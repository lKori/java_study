import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("./datasheet/220801.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(1);
			int rows = sheet.getPhysicalNumberOfRows();

			for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				if(row != null) {
					int cells = row.getPhysicalNumberOfCells();
					for (int columnIndex = 0; columnIndex <= cells - 1; columnIndex++) {
						XSSFCell cell = row.getCell(columnIndex);
						String value = "";
						if(cell == null) {
							continue;
						} else {
							switch(cell.getCellType()) {
							case NUMERIC:
								value = cell.getNumericCellValue() + "";
								break;
							case STRING:
								value = cell.getStringCellValue() + "";
								break;
							case BLANK:
								value = cell.getBooleanCellValue() + "";
								break;
							case ERROR:
								value = cell.getErrorCellValue() + "";
								break;
							}
						}
						System.out.print("|" + String.format("%-16s", value));
					}
					System.out.println();
				} else {
					System.out.println("------------------------------------------------------------------------------------------");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

