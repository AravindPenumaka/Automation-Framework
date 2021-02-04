package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class getTestCaseName {

	String fileName = "PayoffQuotation.java";
	
	String inputFileLocation = "D:\\Workspace\\com.automation.HCA_Latest\\src\\test\\java\\testCases\\";
	String outPutFileLocation = "D:\\HCA\\Brahma\\Framework\\com.automation.HCA\\com.automation.HCA\\outPut";
	
	public static void main(String args[]) throws IOException  {
		getTestCaseName read = new getTestCaseName();
		read.ReadData();
		System.out.println("----------------Writting Done------------------");
		
	}
	
	public void ReadData() throws IOException{
		
		/*String path = "C:\\Users\\tcs_2232602\\workspaceIE\\test\\src\\test\\java\\testDataInput\\";
		File excel= new File(path);
	    File[] listOfFiles = excel.listFiles();
	    System.out.println(listOfFiles.length);*/
	    
	    	File files = new File(outPutFileLocation);
         	files.mkdirs();
         	File file = new File(inputFileLocation + fileName); 
         	  
         	BufferedReader br = new BufferedReader(new FileReader(file)); 
         	 List<String> step = new ArrayList<String>();
         	String line;
			while((line = br.readLine()) != null){
                //process the line
                if(line.contains("public void")){
                	
                	String[] getElement = line.split(" ");
                	System.out.println(getElement[2]);
                	
                	step.add(getElement[2]);
                }
            }
         	  
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(files +"\\TestCaseName.java"));
	    	for(int l = 0; l < step.size(); l++){
            	String test = step.get(l);
            	writer.write(test);
            	writer.newLine();
            }
	        writer.close();
	}
}
