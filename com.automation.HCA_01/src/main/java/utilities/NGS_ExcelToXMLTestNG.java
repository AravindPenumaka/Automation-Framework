package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class NGS_ExcelToXMLTestNG  {

	//static String sheetExecutor = "CRM.xls";
	private static String resourceName = System.getProperty("user.dir") + "\\src\\test\\resources\\InputData\\";
	Element nodeClass;
	Element nodeMethod;
	
	public static void main(String args[]) throws IOException  {
		NGS_ExcelToXMLTestNG read = new NGS_ExcelToXMLTestNG();
		
		File excel= new File(resourceName);
	    File[] listOfFiles = excel.listFiles();
	    System.out.println(listOfFiles.length);
	    
	    for (int k = 0; k < listOfFiles.length; k++) {
	    	String strPathHold = listOfFiles[k].getName();
	    	read.readElements(strPathHold);
	    }
	}
	
	
	/**
	 * Read data from the excel files and store it in the Document builder.
	 * @param strPathHold 
	 *
	 */
	public void readElements(String strPathHold) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Error creating the document builder in XMLPageDataProviderCustom. " + e);
		}
		try {
			Element root;
			document = builder.newDocument();
			root = document.createElement("suite");
			document.appendChild(root);
			ReadExcelFile(strPathHold, document);
		} catch (Exception e) {
			System.out.println("Error reading the excel files."+ e);
		}
	}

	/**
	 * This function reads the excel files one by one and creates a single
	 * document object that is used as page data provider and based on the 
	 * file creation flag creates the file for future reference.
	 * @param strPath
	 * @param document
	 * @return 
	 */
	private void ReadExcelFile(String strPath, Document document) {
	    	
		if (strPath.contains(".xls")) {
			String fileName = strPath;
//			System.out.println(fileName);
			FileInputStream inputStream = null;
			HSSFWorkbook workbook = null;
			try {
				inputStream = new FileInputStream(new File(fileName));
				workbook = new HSSFWorkbook(inputStream);
				int numSheet = workbook.getNumberOfSheets();

				for (int j = 0; j < numSheet; j++) {
					String sheetName= workbook.getSheetName(j);
					if (sheetName.equals("Execution_Sheet")) {
						try{
		        	    		document = ExcelReaderFunction(workbook, workbook.getSheetName(j), fileName, document);
						
						}catch(NullPointerException e){
							System.out.println("Template for not found for the the entity:" + sheetName);
						}
					}
				}
				workbook.close();
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				try { 
					if (workbook !=null) workbook.close();
					if (inputStream !=null) inputStream.close(); 
					} catch(IOException e1) { e1.printStackTrace();}
			}

		try {
			
//			String xmlFileName = fileName.substring(0,fileName.lastIndexOf('.'));
			String xmlFileName = "testNG";
				writeXMLDocument(System.getProperty("user.dir")+"\\"+xmlFileName+".xml", document);
				System.out.println("---------Writting Done------------");
		} catch (Exception e) {
			System.out.println(e);
			}
		} else {
			System.out.println("File not found in path" + strPath);
		}
	 }

	/**
	 * This function reads the excel file and returns the document object
	 * @param workbook
	 * @param nameSheet
	 * @param FileName
	 * @param document
	 * @return Document object
	 */
	@SuppressWarnings("deprecation")
	private Document ExcelReaderFunction(HSSFWorkbook workbook, String nameSheet, String FileName, Document document) {
		
		NodeList roots = document.getElementsByTagName("suite");
		Element root = (Element) roots.item(0);
		
		Element record = document.createElement("test");
		
		FileName = FileName.substring(0,FileName.lastIndexOf('.'));
		root.setAttribute("name", "HCA");
		record.setAttribute("name", "Test");
		
		// reading the excell sheet...
		Element recordTest = document.createElement("classes");
		root.appendChild(record);
		record.appendChild(recordTest);
		
		HSSFSheet worksheet = workbook.getSheet(nameSheet);
		int numRow = worksheet.getPhysicalNumberOfRows();
		System.out.println("Entity Name: " + nameSheet);
		HSSFRow row = worksheet.getRow(0);
		int numCol = row.getPhysicalNumberOfCells();
		String data[][] = new String[numRow][numCol];
		List<String> classNameList = new ArrayList<String>();
		for(int i = 0; i< numRow; i++){
			
			row = worksheet.getRow(i);
			for(int j = 4; j < 5; j++){
				Cell cell = null;
				try{
					/*for(int m=0;m<worksheet.getNumMergedRegions();m++){ 
			              Region region=worksheet.getMergedRegionAt(m); 
			                  // +1 is required as both ends of range are inclusive 
			              int numCols=region.getColumnTo()-region.getColumnFrom()+1; 
			              int numRows=region.getRowTo()-region.getRowFrom()+1; 
			              cell = worksheet.getRow(numRows).getCell(numCols);
			              System.out.println("Cel is in merged region. The value stored in that region is " +
			                  cell.getStringCellValue());
			            }*/ 
					
					cell = row.getCell(j);
					String flag = row.getCell(4).getStringCellValue();
					
					if(flag.equals("Yes"))
					  {
						String testCaseName = null;
						String[] scenarioName = null;
						try {
							testCaseName = row.getCell(3).getStringCellValue();
							scenarioName = testCaseName.split("_");
							
							System.out.println("---" + nodeClass.getAttribute("name"));
							
							String clsName = nodeClass.getAttribute("name");
							String[] splitClassName = clsName.split("\\.");
							
							if(splitClassName[1].equals(scenarioName[0])){
								System.out.println("---exists");
							}else{
								nodeClass = document.createElement("class");
								nodeClass.setAttribute("name", "testCases."+scenarioName[0]);
								nodeMethod = document.createElement("methods");
							}
						}catch(NullPointerException e){
							nodeClass = document.createElement("class");
							nodeClass.setAttribute("name", "testCases."+scenarioName[0]);
							nodeMethod = document.createElement("methods");
						}
						
						Element nodeInclMethod = document.createElement("include");
						nodeInclMethod.setAttribute("name", testCaseName);
						
						recordTest.appendChild(nodeClass);
						nodeClass.appendChild(nodeMethod);
						nodeMethod.appendChild(nodeInclMethod);
					  }
					
				}catch(NullPointerException e){
					data[i][j] = "";
				}catch(IllegalStateException e){
					DataFormatter formatter = new DataFormatter();
					data[i][j] = formatter.formatCellValue(cell);					
				}
			}
		}
		return document;
		
	}

	/**
	 * This function writes the xml file.
	 * @param pathAndName
	 * @param document
	 * @throws IOException 
	 */
	public void writeXMLDocument(String pathAndName, Document document) throws IOException{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		
		try {
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://testng.org/testng-1.0.dtd");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		} catch (TransformerConfigurationException e1) {
			System.out.println("Error instantiating data transformer" + e1);
		}
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(pathAndName));

		try {
			transformer.transform(source, result);
			transformer.reset();
		} catch (TransformerException e) {
			e.printStackTrace();
			System.out.println("Error writing the file"+ e);
		}
	}
	
	
}
