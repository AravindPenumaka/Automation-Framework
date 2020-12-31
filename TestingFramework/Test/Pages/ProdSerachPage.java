package Pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import Objects.ObjConnect;
import Reusables.Reusables;

public class ProdSerachPage extends Reusables{
	
	ObjConnect obj =new ObjConnect();
	
	public void SearchProduct(WebDriver driver,HashMap<String, String> data) throws Exception {
		
		entertext(driver, obj.prodsearch.Search, data.get("ProductSearch"), "serach");
		click(driver, obj.prodsearch.Submit, "Submit");
	}

}
