package ma;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static void main(String[] args) throws IOException {

		File f = new File("I:\\automation\\changeLogStatus.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter writer = new BufferedWriter(fw);
		FileInputStream fs = new FileInputStream("I://suffin//change.xlsx");
		workbook = new XSSFWorkbook(fs);
		workbook.close();
		int sheets = workbook.getNumberOfSheets();
		Cell value;

		 sheet = workbook.getSheetAt(0); // identify testcases
													// column by
													// scanning the
													// entire 1st row
		Iterator<Row> rows = sheet.iterator(); // sheet is collection of

		int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
		List<String> headersList = new ArrayList<String>();

		for (int i = 0; i < colNum; i++) {

			String cell = sheet.getRow(0).getCell(i).getStringCellValue();

			headersList.add(cell);

		}
		
		List<ChangeLogFormat> rowsList = new ArrayList<>();
		
		 
		System.out.println(headersList);

		int rowNum = sheet.getLastRowNum();

		System.out.println(rowNum);

		System.out.println(colNum);
		
		Object[][] data = new Object[rowNum-1][colNum];

		for (int i = 1; i < rowNum; i++) {
            ChangeLogFormat   cl = new ChangeLogFormat();
            
            
			for (int j = 0; j < colNum; j++) {
               
                
				String dat = getTestData(i,j);
				cl.setStatus(dat);
				data[i-1][j] = dat;
				rowsList.add(cl);
			}

		}
		
		 
		
		
		
		

	}

	public static String getTestData(int row, int column) {

		String data = sheet.getRow(row).getCell(column).getStringCellValue();

		return data;

	}

}
