package Reporting;

import java.util.ArrayList;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BasePack.BaseClass;


public class addReport extends BaseClass{
	
	public ExtentTest node;

	ArrayList<String> methods = new ArrayList<>();
	public void AssetMessage(String scPath, String status,String MethodName) {
		if(!methods.contains(MethodName)){
			methods.add(MethodName);
			node = test.createNode(MethodName);
		}
		
		
		
		if(methods.contains(MethodName)){
			node.pass(status, MediaEntityBuilder.createScreenCaptureFromPath(scPath).build());
		}else{
			test.pass(status, MediaEntityBuilder.createScreenCaptureFromPath(scPath).build());
		}
	}


}
