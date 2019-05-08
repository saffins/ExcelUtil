package ExcelReaderUtility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderTask {
	

	public static void main(String... args) throws IOException {

		Properties p = new Properties();

		File f = new File("I:\\automation\\changeLogStatus.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter writer = new BufferedWriter(fw);
		FileInputStream fs = new FileInputStream("I://suffin//change.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		workbook.close();
		int sheets = workbook.getNumberOfSheets();
		Cell value;

		for (int i = 0; i < sheets; i++) {
			System.out.println("sheet = " + (i + 1));
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // identify testcases
															// column by
															// scanning the
															// entire 1st row
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of

				while (rows.hasNext()) {

					Row first = rows.next();

					Iterator<Cell> c = first.cellIterator();

					value = c.next();

					if (value.getStringCellValue().equalsIgnoreCase("pass")) {

						Cell repName = c.next();
						Cell jiraID = c.next();
						Cell verFixed = c.next();
						Cell resolution = c.next();

						System.out.println("JIRA ID: " + verFixed + " reported by: " + repName + " fixed in version :"
								+ jiraID + " resolution :" + resolution + " " + value + " in changelog");
						String saveData = "JIRA ID: " + verFixed + " reported by: " + repName + " fixed in version :"
								+ jiraID + " " + value + " in changelog";
						writer.write(saveData + "\r\n");

					}

				}

			}

			writer.close();
		}
		
		
		
		
	}

	public void Task() throws IOException {

		Properties p = new Properties();

		File f = new File("I:\\automation\\changeLogStatus.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter writer = new BufferedWriter(fw);
		FileInputStream fs = new FileInputStream("I://suffin//change.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		workbook.close();
		int sheets = workbook.getNumberOfSheets();
		Cell value;

		for (int i = 0; i < sheets; i++) {
			System.out.println("sheet = " + (i + 1));
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // identify testcases
															// column by
															// scanning the
															// entire 1st row
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of

				while (rows.hasNext()) {

					Row first = rows.next();

					Iterator<Cell> c = first.cellIterator();

					value = c.next();

					if (value.getStringCellValue().equalsIgnoreCase("pass")) {

						Cell repName = c.next();
						Cell jiraID = c.next();
						Cell verFixed = c.next();
						Cell resolution = c.next();

						System.out.println("JIRA ID: " + verFixed + " reported by: " + repName + " fixed in version :"
								+ jiraID + " resolution :" + resolution + " " + value + " in changelog");
						String saveData = "JIRA ID: " + verFixed + " reported by: " + repName + " fixed in version :"
								+ jiraID + " " + value + " in changelog";
						writer.write(saveData + "\r\n");

					}

				}

			}

			writer.close();
		}
		
		
		
		
	}
}
