package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KSIOPHomeObject {

	@FindBy(xpath="//a[text()='Contracts']")
	public WebElement lst_contracts;
	
	@FindBy(xpath="//table[@id='modulesMenu:s_tu_abl::ScrollContent']//tr[@id='modulesMenu:s_tu_abo']/td[text()='Global Events']")
	public WebElement lst_GlobalEvents;
	
	//@FindBy(xpath="//img[@id='secId:s_bd8_aam:tbTableToolbar:new::icon']")
	@FindBy(xpath="//div[@id='secId:s_bd8_aam']//div[@id='secId:s_bd8_aam:_otrWpr::t']//table[@class='xmf']//div[@id='secId:s_bd8_aam:tbTableToolbar:new']")
	public WebElement btn_new;
	
	@FindBy(xpath="//select[@id='tabGeneralitiesEvtGlobCmbEvtGlob:s_bd6_aaf::content']/option[@title='Bulk Payment : D_BULKP']")
	public WebElement lst_events;
	
	@FindBy(id="button_bar:btnNext")
	public WebElement btn_next;
	
	@FindBy(xpath="select[@id='s_cbd_1::content']")
	public WebElement lst_input_list;
	
	@FindBy(xpath="//option[@title='Manual']")
	public WebElement lst_input_select;
	
	@FindBy(xpath="//select[@id='s_cbd_2::content']")
	public WebElement lst_spread;
	
	@FindBy(xpath="//option[@title='Waterfall']")
	public WebElement lst_spread_select;
	
	@FindBy(xpath="//select[@name='s_cbd_3']")
	public WebElement lst_payment_list;                
	
	@FindBy(xpath="//option[@title='Lockbox']")
	public WebElement lst_payment_select_Lockbox;
	
	@FindBy(xpath="//select[@name='s_cbd_3']")
	public WebElement lst_payment_list0;
	
	@FindBy(xpath="//option[@title='ACH']")
	public WebElement lst_select_ach;
	
	@FindBy(xpath="//select[@id='s_cbd_3::content']")
	public WebElement lst_payment_list1;
	
	@FindBy(xpath="//select[@id='s_cbd_3::content']/option[text()='Payoff']")
	public WebElement lst_payment_select_payoff;
	
	@FindBy(xpath="//select[@id='s_cbd_5::content']")
	public WebElement lst_gropup_select;		
	
	@FindBy(xpath="//textarea[@id='s_txta_1::content']")
	public WebElement txt_comment;

	@FindBy(id="j_id_id8pc8:tbTableToolbar:new::icon")
	public WebElement btn_new1;
	
	@FindBy(xpath="//input[@id='j_id_id8pc8:innerTbl:0:regpiece::content']")
	public WebElement txt_check_no;
	
	@FindBy(xpath="//input[@id='j_id_id8pc8:innerTbl:0:regmt::content']")
	public WebElement txt_check_amt;
	
	@FindBy(xpath="//input[@name='j_id_id8pc8:innerTbl:0:regmt']")
	public WebElement txt_check_amt_clear;
	
	@FindBy(xpath="//input[@id=j_id_id8pc8:innerTbl:0:checktype']")
	public WebElement txt_eff_date;
	
	@FindBy(xpath="//select[@name='j_id_id8pc8:innerTbl:0:checktype']")
	public WebElement lst_dealer_check_list;
		
	@FindBy(xpath="//option[@title='Personal check']")
	public WebElement lst_dealer_check_select;

	@FindBy(id="j_id_id8pc8:innerTbl:0:paymentcount::content")
	public WebElement txt_noofpayment;
	
	@FindBy(id="j_id_id8pc8:innerTbl:0:checkcomments::content")
	public WebElement txt_check_comment;
	
	@FindBy(xpath="//input[@id='j_id_id8pc8:innerTbl:0:paymentcount::content']")
	public WebElement txt_input_amt;
	
	@FindBy(xpath="//button[@id='button_bar:btnNext']")
	public WebElement btn_next1;
	
	
	
}
