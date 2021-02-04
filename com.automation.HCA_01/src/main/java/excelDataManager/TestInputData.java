package excelDataManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import pageDataFactory.ExcelPOIAdapter;

/**
 * TestInputData Class consists of methods that are going to read input data from different excel sheets.
 * 
 */

public class TestInputData {
	
	Workbook workbook;
	private HashMap<String, String> RetMap;
	private ExcelPOIAdapter exlPoiAdp = new ExcelPOIAdapter();

	
	@SuppressWarnings("unused")
	public HashMap<String, String> fetchInputData(String fpath,String sheetName,String className)throws Throwable{	
		
		if(fpath.contains(".xlsx")){
			
			workbook = new XSSFWorkbook(new FileInputStream(new File(fpath)));
			RetMap=readInputExcel(workbook, fpath,className);
			
		}else if(fpath.contains(".xls")){
			workbook = new HSSFWorkbook(new FileInputStream(new File(fpath)));
			RetMap=readInputExcel(workbook, sheetName,className);
		}
		return RetMap;
	}
	
	
	public HashMap<String, String> fetchDataIntoExcel(String fname,String tm, String className, String pnr)throws IOException{	
		System.out.println("Final Set ::::");
		//HashMap<String, String> RetMap=writeInputExcel(fname,tm,className,pnr);	
		
		return RetMap;
	}
	
	
	/*
	 * This method readInputExcel reads from excel sheet to capture Input test data.
	 *  
	 * @param workbook
	 * @param sheetName	
	 * @param className
	 * @return HashMap
	 * 
	 */	
	public HashMap<String, String> readInputExcel(Workbook workbook, String sheetName,String testCaseName) throws Throwable{
			 Sheet sheet = workbook.getSheet(sheetName);
			 Cell id = exlPoiAdp.getCell(sheet, testCaseName);
		        int rowNum = id.getRowIndex();
		        int numCols = sheet.getRow(0).getPhysicalNumberOfCells();
		        System.out.println("********* Fetching Input Data From SheetName: " + sheetName + " For RowName: " + testCaseName);
		        System.out.println("Avaliable Column Nos :"+ numCols + "\n");
		        Row HeaderRow = sheet.getRow(0);
		        Row  datasetRow = sheet.getRow(rowNum);   
		      
		        HashMap<String, String> RetMap = new HashMap<String, String>();
		            
		            for (int j = 0; j < numCols; j++) {
		            	
		            	Cell currentCell= datasetRow.getCell(j);            	
		                Cell currentHeader= HeaderRow.getCell(j);                
		                             
		                try {
		                	
							switch (currentCell.getCellType()) {
							    case Cell.CELL_TYPE_STRING:
							    	RetMap.put(currentHeader.getStringCellValue(), currentCell.getStringCellValue());
							        break;
							    case Cell.CELL_TYPE_NUMERIC:
							    	RetMap.put(currentHeader.getStringCellValue(),String.valueOf(currentCell.getNumericCellValue()).split("\\.")[0]);
							        break;
							    case Cell.CELL_TYPE_BLANK:
							    	RetMap.put(currentHeader.getStringCellValue(), "");
							    	break;
							    case Cell.CELL_TYPE_ERROR:
							    	RetMap.put(currentHeader.getStringCellValue(), "");
							        break;
							}
		                }catch (NullPointerException e) {
							
		                	RetMap.put(currentHeader.getStringCellValue(), "");
		          }
			}
		return RetMap;
	}
	
	

	/*public HashMap<String, String> writeInputExcel(String Filepath,String testcase, String className, String pnr) throws IOException{
		HashMap<String, String> mapDet; 
		mapDet=new HashMap<String, String>();
		try{			 
			 // Create a object for Workbook class				 	
			 Workbook workbook = Workbook.getWorkbook(new File(Filepath));		 
			 // Create a object for Sheet class. Put the sheet number you want to access in the getSheet() method
			 System.out.println(className);
			 Sheet sheet = workbook.getSheet(className);
			 //Get the row count and column count
			 int rowCount = sheet.getRows();
		  	 int colCount = sheet.getColumns();
		  	 int i=0;
		  	 int j=0;	
		  	 String key= null;	
		  	 String value= null;	
		  	 int desiredRowNum=0;
		  	 int desiredColmNum=0;
		  	 
		  	 	for (i=0; i<rowCount; i++){
		  			sheet.getRow(i); 
		  		        for (j=0; j<colCount; j++){		
		  		            sheet.getColumn(j);
	
			  			 	Cell valCellContents = sheet.getCellComment(j,0);
				  			 String desired = valCellContents.getContents();
				  			 	
				  			 Cell valCellContentsTC = sheet.getCellComment(0,i);
				  			 String desiredTC = valCellContentsTC.getContents();
				  			 	
				  			 desiredRowNum = i;
				  			 desiredColmNum = j;
				  			 	
				  			 String pnrnum = "PRN";
				  			 if((pnrnum.equalsIgnoreCase(desired)) && (testcase.equalsIgnoreCase(desiredTC))){
			  			 		
			  			 		
			  			     WritableWorkbook wb = Workbook.createWorkbook(new File(Filepath),workbook);
			  			     WritableSheet ws = wb.getSheet(className);
			  			      {
			  			     Label label = new Label(desiredColmNum,desiredRowNum,pnr);
			  			      ws.addCell(label);
			  			     }
			  			     wb.write();
			  			     wb.close();
	  			 	    
				  		}
		  		  }		  	
		 	} 
		}
		 	catch(FileNotFoundException error)
		 	{
				   error.printStackTrace();
		 	}
		 	catch(Exception error1)
		     {
			      error1.printStackTrace();	
		     }
		return(mapDet);
	}
*/
}