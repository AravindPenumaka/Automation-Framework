package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * Implementing the TestNG listener to customize the console out put and also
 * push the execution results to a excel file with case ID and test methods
 * 
 * 
 * 
 */
public class ExcelExecutionStatusReport {
	
	public int row;
	static String outputReportDir= "d:\\Screen";
	String url = null;
	String browser = null;
	String sheetName = "ExecutionSheet";
	HSSFSheet sheet;
	HSSFWorkbook workbook;
	static File dirPath;
	static String fileName;
	static File directory;
	static File file;
	
	@SuppressWarnings("static-access")
	public void onStartExcelStatusReport(String excelReportPath) throws IOException {

		fileName = "excelExecutionStatus.xls";
		directory = new File(excelReportPath);
		if (!directory.isDirectory()) {
			directory.mkdirs();
		}
		file = new File(directory, fileName);
		workbook = new HSSFWorkbook();
		workbook.createSheet(sheetName);
		try {
			String Header[] = new String[7];
			Header[0] = "ModuleName";
			Header[1] = "TestCase";
			Header[2] = "Browser";
			Header[3] = "ScreenShot";
			Header[4] = "ExecutionStatus";
			Header[5] = "TestData";
			Header[6] = "Comments";

			HSSFCellStyle cell = workbook.createCellStyle();
			cell.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
			cell.setBorderBottom(cell.BORDER_THIN);
			cell.setBorderLeft(cell.BORDER_THIN);
			cell.setBorderRight(cell.BORDER_THIN);
			cell.setBorderTop(cell.BORDER_THIN);

			cell.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			cell.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setAlignment(cell.ALIGN_CENTER);

			Font font = workbook.createFont();
			font.setColor(IndexedColors.BLACK.getIndex());
			font.setBold(true);
			cell.setFont(font);

			HSSFSheet sheet = workbook.getSheet(sheetName);
			sheet.createRow(0);
			for (int i = 0; i < Header.length; i++) {
				sheet.getRow(0).createCell(i).setCellValue(Header[i]);
				sheet.getRow(0).getCell(i).setCellStyle(cell);
			}
			workbook.write(new FileOutputStream(file));
			workbook.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinishExcelStatusReport() {
		try {
			sheet = workbook.getSheet(sheetName);
			int ColumnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			for (int j = 0; j <= ColumnCount; j++) {
				sheet.autoSizeColumn(j);
			}
			workbook.write(new FileOutputStream(file));
			workbook.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void writeInToExcelStatusReport(String scenario, String tc, String browser, String screenshot) {
		try {
			workbook = new HSSFWorkbook(new FileInputStream(file));
			sheet = workbook.getSheet(sheetName);
			row = sheet.getLastRowNum() + 1;
			sheet.createRow(row);
			sheet.getRow(row).createCell(0).setCellValue(scenario);
			sheet.getRow(row).createCell(1).setCellValue(tc);
			sheet.getRow(row).createCell(2).setCellValue(browser);
			sheet.getRow(row).createCell(3).setCellValue(screenshot);
			workbook.write(new FileOutputStream(file));
			workbook.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeExcelTestCaseStatus(String method, String resultStatus) throws FileNotFoundException, IOException {
		workbook = new HSSFWorkbook(new FileInputStream(file));
		sheet = workbook.getSheet(sheetName);
		int intRowNum = sheet.getPhysicalNumberOfRows();
		
		for (int i = 1; i < intRowNum; i++) {
			HSSFRow Exlrow = sheet.getRow(i);
			String testCaseName = Exlrow.getCell(1).getStringCellValue();
			if (testCaseName.equals(method)) {
				int ColumnCount = Exlrow.getPhysicalNumberOfCells();
				
				for (int j = 0; j <= ColumnCount; j++) {
					String sheetHeader = sheet.getRow(0).getCell(j).getStringCellValue();
					
					if (sheetHeader.equalsIgnoreCase("ExecutionStatus")) {
						if (resultStatus.equalsIgnoreCase("Pass")) {
							sheet.getRow(i).createCell(j).setCellValue("Passed");
							HSSFCellStyle cell = workbook.createCellStyle();
							cell.setFillForegroundColor(IndexedColors.GREEN.getIndex());
							cell.setFillPattern(CellStyle.SOLID_FOREGROUND);
							cell.setAlignment(cell.ALIGN_CENTER);
							
							cell.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
							cell.setBorderBottom(cell.BORDER_MEDIUM);
							
							Font font = workbook.createFont();
							font.setColor(IndexedColors.WHITE.getIndex());
							cell.setFont(font);
							sheet.getRow(i).getCell(j).setCellStyle(cell);
						
						} else if(resultStatus.equalsIgnoreCase("Fail")){
							sheet.getRow(i).createCell(j).setCellValue("Failed");
							HSSFCellStyle cell = workbook.createCellStyle();
							cell.setFillForegroundColor(IndexedColors.RED.getIndex());
							cell.setFillPattern(CellStyle.SOLID_FOREGROUND);
							cell.setAlignment(cell.ALIGN_CENTER);
							
							cell.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
							cell.setBorderBottom(cell.BORDER_MEDIUM);
							
							Font font = workbook.createFont();
							font.setColor(IndexedColors.WHITE.getIndex());
							cell.setFont(font);
							sheet.getRow(i).getCell(j).setCellStyle(cell);
							
						} else if(resultStatus.equalsIgnoreCase("Error")){
							sheet.getRow(i).createCell(j).setCellValue("Error");
							HSSFCellStyle cell = workbook.createCellStyle();
							cell.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
							cell.setFillPattern(CellStyle.SOLID_FOREGROUND);
							cell.setAlignment(cell.ALIGN_CENTER);
							
							cell.setFillBackgroundColor(IndexedColors.BLACK.getIndex());
							cell.setBorderBottom(cell.BORDER_MEDIUM);
							
							Font font = workbook.createFont();
							font.setColor(IndexedColors.WHITE.getIndex());
							cell.setFont(font);
							sheet.getRow(i).getCell(j).setCellStyle(cell);
						}

						FileOutputStream fout = new FileOutputStream(file);
						workbook.write(fout);
						break;
					}
				}
				break;
			}
		}
	}
	
	public void writeExcelInputTestData(String method, String testdata) throws FileNotFoundException, IOException {
		workbook = new HSSFWorkbook(new FileInputStream(file));
		sheet = workbook.getSheet(sheetName);
		int intRowNum = sheet.getPhysicalNumberOfRows();
		
		for (int i = 1; i < intRowNum; i++) {
			HSSFRow Exlrow = sheet.getRow(i);
			String testCaseName = Exlrow.getCell(1).getStringCellValue();
			
			HSSFRow exlRowHeader = sheet.getRow(0);
			if (testCaseName.equals(method)) {
				int ColumnCount = exlRowHeader.getPhysicalNumberOfCells();
				
				for (int j = 0; j <= ColumnCount; j++) {
					String sheetHeader = sheet.getRow(0).getCell(j).getStringCellValue();
					if (sheetHeader.equalsIgnoreCase("TestData")) {
						//String getcellValue = sheet.getRow(i).getCell(j).getStringCellValue();
						if(sheet.getRow(i).getCell(j) != null && !sheet.getRow(i).getCell(j).equals("") ){
							String cellInputValue = sheet.getRow(i).getCell(j).getStringCellValue() +"\n"+ testdata;
							sheet.getRow(i).createCell(j).setCellValue(cellInputValue);
							
							CellStyle cs = workbook.createCellStyle();  
				            cs.setWrapText(true);  
				            Exlrow.getCell(j).setCellStyle(cs);  
				            sheet.autoSizeColumn(j);  
							
						}else {
							sheet.getRow(i).createCell(j).setCellValue(testdata);
						}
						FileOutputStream fout = new FileOutputStream(file);
						workbook.write(fout);
						break;
					}
				}
				break;
			}
		}
	}
}
