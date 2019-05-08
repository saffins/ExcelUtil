package com.ecw.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	static  DataFormatter df = new DataFormatter();
	  
	public static void main(String... args) throws IOException {

		Properties p = new Properties();

		File f = new File("I:\\automation\\statuschange.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter writer = new BufferedWriter(fw);
		FileInputStream fs = new FileInputStream("I://automation//SaffinChangeLogSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		workbook.close();

		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rows = sheet.iterator();

		while (rows.hasNext()) {

			Row row = rows.next();

			Iterator<Cell> cell = row.cellIterator();

			while (cell.hasNext()) {
				
				Cell c = cell.next();
				 String data = df.formatCellValue(c);
				 Cell date = row.getCell(3);
				 String dataCheck = df.formatCellValue(date);
                
				if (data.equalsIgnoreCase("JIRA APPROVED") && dataCheck.equalsIgnoreCase("6 May") ) {

					String jiraId = row.getCell(0).getStringCellValue();

					 String assignedTo = row.getCell(1).getStringCellValue();
					

				/* Cell date = row.getCell(3);
				 
				 String datef = df.formatCellValue(date);
*/
					String saveData = "jira id " + jiraId + " assigned to "  + assignedTo  + " is passed " + dataCheck ;
					System.out.println(saveData);
					writer.write(saveData + "\r\n");
				} else if (data.equalsIgnoreCase("JIRA REJECTED") && dataCheck.equalsIgnoreCase("6 May")   ) {

					String jiraId = row.getCell(0).getStringCellValue();

					
				 String assignedTo = row.getCell(1).getStringCellValue();
				// DataFormatter df = new DataFormatter();

				/* Cell date = row.getCell(3);
				 
				 String datef = df.formatCellValue(date);*/
					// String date = row.getCell(3).getStringCellValue();

					String saveData = "jira id " + jiraId + " assigned to " + assignedTo  + " is rejected " + dataCheck  ;
					System.out.println(saveData);
					writer.write(saveData + "\r\n");
					
					
					
				}
			}

		}

		writer.close();

		// Mailer.sendMail();
	}

}
