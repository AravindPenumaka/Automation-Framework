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

public class pageElementToTestSteps {

	String pageName = "asset_page";
	String fileName = "Asset_PageObject.java";
	
	String inputFileLocation = "D:\\HCA\\Brahma\\Framework\\com.automation.HCA\\com.automation.HCA\\src\\test\\java\\ObjectLibrary\\";
	String outPutFileLocation = "D:\\HCA\\Brahma\\Framework\\com.automation.HCA\\com.automation.HCA\\outPut";
	
	public static void main(String args[]) throws IOException  {
		pageElementToTestSteps read = new pageElementToTestSteps();
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
                if(line.contains("public WebElement")){
                	
                	String[] getElement = line.split(" ");
                	System.out.println(getElement[2]);
                	
                	if(getElement[2].contains("btn_") || getElement[2].contains("lnk_") || getElement[2].contains("tab_") || getElement[2].contains("cb_") || getElement[2].contains("rb_")){
                		String prefixValue = null;
                		
                		switch(getElement[2].split("_")[0]){
                		case "btn" :
                			prefixValue= "Button";
                			break;
                		case "lnk":
                			prefixValue = "Link";
                			break;
                		case "tab":
                			prefixValue = "Tab";
                			break;
                		case "cb":
                			prefixValue = "Checkbox";
                			break;
                		case "rb":
                			prefixValue = "RadioButton";
                			break;
                		}
                		String lineStep = "reportData.add(click(appPages." + pageName + "." + getElement[2].substring(0, getElement[2].length()-1) + ", \" "+ prefixValue +"\"));";
                		step.add(lineStep);
                	}
                	
                	if(getElement[2].contains("txt_")){
                		String lineStep = "reportData.add(type(appPages." + pageName + "." + getElement[2].substring(0, getElement[2].length()-1) + ", data.get(\"\"), \" Textbox\"));";
                		step.add(lineStep);
                	}
                	
                	if(getElement[2].contains("lst_")){
                		String lineStep = "reportData.add(select(appPages." + pageName + "." + getElement[2].substring(0, getElement[2].length()-1) + ", data.get(\"\"), \" Dropdown\"));";
                		step.add(lineStep);
                	}
                	
                	if(getElement[2].contains("vfy_")){
                		String lineStep = "reportData.add(verifyText(appPages." + pageName + "." + getElement[2].substring(0, getElement[2].length()-1) + ", \"\", \" Label\"));";
                		step.add(lineStep);
                	}
                } else if(line.contains("public String")){
                	
                	String[] getElement = line.split(" ");
                	System.out.println(getElement[2]);
                	
                	String lineStep = "reportData.add(waitForVisibilityOfElement(setStringValueInToWebElement(appPages." + pageName + "." + getElement[2].substring(0, getElement[2].length()) + ", \" \", \"XPATH\"), \" Label\"));";
                	step.add(lineStep);
                }
            }
         	  
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(files +"\\TestStep.java"));
	    	for(int l = 0; l < step.size(); l++){
            	String test = step.get(l);
            	writer.write(test);
            	writer.newLine();
            }
	        writer.close();
	}
}
