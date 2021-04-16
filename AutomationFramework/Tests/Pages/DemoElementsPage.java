package Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.common.base.Verify;

import Objects.ObjConnect;

public class DemoElementsPage extends Reusables.Keywords {

	ObjConnect ob = new ObjConnect();

	public void demoElementInteraction(HashMap<String, String> data) throws java.lang.Exception {
		List<String> result = new ArrayList<String>();
		
		result.add(enterText(ob.demoObj.textarea, data.get("TextArea"), "textarea"));
		result.add(enterText(ob.demoObj.firstName, data.get("FirstName"), "Firstname"));
		result.add(enterText(ob.demoObj.Lastname, data.get("LastName"), "Last Name"));
		result.add(click(ob.demoObj.Submit, "Submit"));
		driver.navigate().back();
		result.add(click(formatString(ob.demoObj.Radio, data.get("RadioData")), "radio button"));
		result.add(click(formatString(ob.demoObj.Checkbox, data.get("CheckBoxData")), "Check Box"));
		result.add(click(ob.demoObj.inputButton, "Input button"));
		result.add(isElementDisplayed(ob.demoObj.imgverify,"Image Verify"));
		result.add(select(ob.demoObj.Dropdown, data.get("DropDown"), "Dropdown"));
		switchtoFrame(ob.demoObj.Iframe1);
		System.out.println(getText(ob.demoObj.PrintFrame1Data));
		switchToDefaultFrame();
		switchtoFrame(ob.demoObj.Iframe2);
		System.out.println(getText(ob.demoObj.PrintFrame2Data));
		switchToDefaultFrame();
		result.add(enterText(ob.demoObj.Date, data.get("Date"),"Date"));
		UploadFile(ob.demoObj.FileUpload, "sample.png");
		result.add(click(ob.demoObj.Waitscenario, "click for wait"));
		result.add(isElementDisplayed(ob.demoObj.WaitTest,"Dynamic Wait"));
		System.out.println(getText(ob.demoObj.WaitTest));
		
		addReport(result,"Demo Page element Interactions");
	}

}
