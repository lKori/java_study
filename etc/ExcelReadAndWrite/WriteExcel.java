import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) {
		try {
//			FileInputStream fis = new FileInputStream("./datasheet/220802.xlsx");	// 수정할 엑셀 파일 불러오기
//			XSSFWorkbook workbook = new XSSFWorkbook(fis);	// 엑셀 파일의 워크시트 불러오기
			XSSFWorkbook workbook = new XSSFWorkbook();		// XsSFWorkbook 객체 생성
			XSSFSheet sheet = workbook.createSheet("test");	// 워크 시트 이름 설정
			
			for(int rowIndex = 0; rowIndex < 10; rowIndex++) {
				XSSFRow row = sheet.createRow(rowIndex);	// 행 객체 추가
				
				for(int columnIndex = 0; columnIndex < 10; columnIndex++) {
					XSSFCell cell = row.createCell(columnIndex);	// 셀 객체 추가
					cell.setCellValue(rowIndex + ", " + columnIndex);	// 셀에 데이터 입력
				}
			}
			FileOutputStream fos = new FileOutputStream("./datasheet/220802.xlsx");	// 데이터를 내보낼 엑셀 파일 선택
			workbook.write(fos);	// 엑셀 파일에 데이터 출력
			fos.close();
			System.out.println("Success");
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("fail");
		}

	}

}
