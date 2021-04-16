package ExcelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class getExcelData {

	File file = new File(System.getProperty("user.dir") + "\\TestData\\TestData.xlsx");

	@DataProvider(name = "TestData")
	public Object[][] getData(Method m) throws EncryptedDocumentException, IOException {
		ArrayList<Integer> NoofRowsexe = new ArrayList<Integer>();
		FileInputStream fs = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheet(m.getName().split("_")[0].trim());

		for (int i = 1; i <= sheet.getPhysicalNumberOfRows() - 1; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equals(m.getName())) {
				NoofRowsexe.add(sheet.getRow(i).getRowNum());
			}
		}

		Object[][] data = new Object[NoofRowsexe.size()][1];
		int rc = 0;

		while (rc < NoofRowsexe.size()) {
			int i = NoofRowsexe.get(rc);
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < sheet.getRow(0).getPhysicalNumberOfCells() - 1; j++) {
				datamap.put(sheet.getRow(0).getCell(j + 1).getStringCellValue(),
						sheet.getRow(i).getCell(j + 1).getStringCellValue());
			}
			data[rc][0] = datamap;
			rc++;
		}
		return data;

	}

	public HashMap<String, String> getData(Map<Object, Object> obdata) {

		HashMap<String, String> data = new HashMap<String, String>();
		for (Map.Entry<Object, Object> entry : obdata.entrySet()) {
			if (entry.getValue() instanceof String) {
				data.put((String) entry.getKey(), (String) entry.getValue());
			}
		}

		return data;
	}

	public HashMap<String, String> getLoginInfo(String User) throws EncryptedDocumentException, IOException {

		HashMap<String, String> UserNameandPass = new HashMap<String, String>();
		FileInputStream fs = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheet("Login");
		for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
			for (int j = 0; j < sheet.getRow(0).getPhysicalNumberOfCells(); j++) {
				if (sheet.getRow(j).getCell(0).getStringCellValue().equals(User)) {
					System.out.println(sheet.getRow(j).getCell(0).getStringCellValue());
					UserNameandPass.put(sheet.getRow(0).getCell(1).getStringCellValue(),
							sheet.getRow(j).getCell(1).getStringCellValue());
					UserNameandPass.put(sheet.getRow(0).getCell(2).getStringCellValue(),
							sheet.getRow(j).getCell(2).getStringCellValue());
					return UserNameandPass;
				}
			}
		}
		return null;
	}
	
	/***
	 * @description returns URL
	 * @param URL
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getURL(String URL) throws EncryptedDocumentException, IOException {
		
		FileInputStream fs = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheet("URL");
		for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
			for (int j = 0; j <= sheet.getRow(0).getPhysicalNumberOfCells(); j++) {
				if (sheet.getRow(j).getCell(0).getStringCellValue().equals(URL)) {
					return sheet.getRow(j).getCell(1).getStringCellValue();
				}
			}
		}
		return null;
	}

	/***
	 * @description Returns configuration data from excel
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getConfiguration(String key) throws Exception{

		FileInputStream fs = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fs);
		Sheet sheet = wb.getSheet("Configuration");
		for (org.apache.poi.ss.usermodel.Row row : sheet) {
			for (org.apache.poi.ss.usermodel.Cell cell : row) {

				if (cell.getRichStringCellValue().getString().trim().equals(key)) {
					int rownum =  row.getRowNum();
					int colnum = cell.getColumnIndex();
					return sheet.getRow(rownum).getCell(colnum+1).getStringCellValue();
				}
			}
		}

		return null;
	}

}
