package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Task_PageObject {

	@FindBy(xpath = "//tr[1]//td//input[@type='checkbox']" )
	public WebElement cb_SelectReferenceRow;
	
	@FindBy(xpath = "//img[@title='Modify']" )
	public WebElement btn_Modify;
	
	@FindBy(xpath = "//input[@id='secId:mainBody:cont_note:j_id_id3pc18::content']" )
	public WebElement vfy_Task;
	
	@FindBy(id="secId:mainBody:cont_note:s_15_aac:innerTbl:0:aststatus::content")
	public WebElement tbl_Status;
	
	@FindBy(id="secId:mainBody:cont_note:s_12_aal::content")
	public WebElement vfy_IssueDate;
	
	@FindBy(id="secId:mainBody:cont_note:s_12_aau::content")
	public WebElement vfy_Memo;

	@FindBy(id="secId:frmAgdTblSubVw:s_byb_aao:innerTbl:ciblenum::content")
	public WebElement txt_ReferenceCode;
	
	@FindBy(xpath="(//label[text()='Base Date From:']/../..//input)[1]")
	public WebElement txt_BaseDateFrom;
	
	@FindBy(xpath="(//label[text()='Base Date From:']/../..//input)[2]")
	public WebElement txt_BaseDateTo;
	
	@FindBy(xpath = "//div//a//img[@title='Search']")
	public WebElement btn_Search;

	@FindBy(xpath = "//select[contains(@id,':innerTbl:admetat::content')]")
	public WebElement lst_Status;
	
	@FindBy(xpath="//div[@id='secId:frmAgdTblSubVw:s_byb_aao:innerTbl::db']//table")
	public WebElement vfy_TransactionHistory;
}
