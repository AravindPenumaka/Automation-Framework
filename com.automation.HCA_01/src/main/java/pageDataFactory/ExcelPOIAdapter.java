package pageDataFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

//import main.java.ExcelFileProcessor;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ExcelPOIAdapter {
			    	
	
	public Cell getCell(Sheet sheet, String searchCellValue) throws InvalidFormatException, IOException{							
		Iterator<Row> rowIterator = sheet.iterator();
		Cell returnValue = null; 
		outerLoop:
		while (rowIterator.hasNext()){
			Row row = (Row)rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();			
			while (cellIterator.hasNext()){
				Cell cell = cellIterator.next();
				String cellValue = this.getCellValue(cell);
					if(cellValue.equals(searchCellValue)){
						returnValue = cell;
						break outerLoop;
				}
			}
		}
		return returnValue;
	}
	
	public String getCellValue(Cell cell){
		String cellValue = "";

			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					if( cell.getBooleanCellValue()){
						cellValue = "TRUE";
					} else {
						cellValue = "FALSE";
					}							
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						double dv = cell.getNumericCellValue();
						if(DateUtil.isValidExcelDate(dv)) {
							Date cellDate = DateUtil.getJavaDate(dv);
							SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
							String sCellDate = dateFormatter.format(cellDate);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							cell.setCellValue(sCellDate);	
							cellValue = this.getCellValue(cell);
						}
					}else{ 
						cellValue = Double.toString(cell.getNumericCellValue());
					}
					break;
				case  Cell.CELL_TYPE_STRING:
					cellValue = cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					break;
				case Cell.CELL_TYPE_ERROR:
					cellValue =  Byte.toString(cell.getErrorCellValue());
					break;
			}
		return cellValue;
	}

	
}

