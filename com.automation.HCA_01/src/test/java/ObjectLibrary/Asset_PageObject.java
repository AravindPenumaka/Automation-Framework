package ObjectLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Asset_PageObject {

	@FindBy(xpath = "//div[@id='secId:vboxlist:s_cc_aab::tabh']//a[text()='Elements list']")
	public WebElement tab_ElementList;
	
	@FindBy(xpath = "//div[@id='firstId:pnlEventsPanel_CollListMainPanel_']//span[text()='Asset address change']")
	public WebElement lnk_AssetAddressChange;
	
	@FindBy(id = "cont_note:j_id_id3pc10::content")
	public WebElement lst_AddressToChange;
	
	@FindBy(xpath = "//button[text()='Next']")
	public WebElement btn_Next;

	@FindBy(id = "s_by_aa0::content")
	public WebElement txt_Address1;
	
	public String txt_GarageAaddressCountry= "//label[text()='%s']/../../td[2]//select";
	
	@FindBy(xpath = "//h3[text()='Garage Address']")
	public WebElement lbl_GaragingAddress;
	
	public String txt_GarageAaddressField = "(//label[text()='%s']/../../td[2]//input)[1]";
	
	@FindBy(id="secId:mainBody:s_yb_aac::tabh::eoi" )
	public WebElement btn_MoreActorOption;
	
	@FindBy(xpath = "//div[@id='secId:vboxlist:s_cc_aab::tabh::eoc']//a[text()='Past Events']" )
	public WebElement tab_PastEvents;

	public String lnk_PastEvent="(//a[text()='%s'])[1]";
	
	@FindBy(xpath="//div[@id='secId:vboxlist:s_bf7_aak']")
	public WebElement vfy_PastEventTable;
	
	@FindBy(xpath="//button[text()='Finish']")
	public WebElement btn_Finish;
	
	@FindBy(xpath="//div[@title='New address']/..")
	public WebElement lbl_NewAddress;
	
	@FindBy(xpath="//div[@title='Old address']/..")
	public WebElement lbl_OldAddress;
	
	@FindBy(xpath="//button[text()='Confirm']")
	public WebElement btn_Confirm;
	
	@FindBy(xpath="//a//img[@title='Search']")
	public WebElement btn_Search;
	
	@FindBy(xpath="(//div[@id='srchDlg:s_be8_aaj:innerTbl::db']//table//tr//td//a/../../..//td//span)[1]")
	public WebElement tbl_CityPostalCodeDirectory_SearchDialog;
	
	@FindBy(xpath="//input[@id='secId:frmRubLsteTblSVw:s_cl_aao:innerTbl:dosnum::content']")
	public WebElement txt_ContractNumber;
	
	@FindBy(xpath="//a[@id='secId:frmRubLsteTblSVw:s_cl_aao:innerTbl:0:itrnum']")
	public WebElement lnk_AssetCode;
	
	@FindBy(xpath="//div[@class='xyg p_AFFlow']")
	public WebElement vfy_GeneralInformationTab;
	
	@FindBy(xpath="//label[text()='Step']/../../td[2]/select")
	public WebElement lst_Step;
	
	@FindBy(xpath = "//h1[text()='Turn-in / Grounding']")
	public WebElement lbl_TurnInGrounding;
	
	@FindBy(xpath = "//label[text()='Grounding Status']/../../td[2]/select")
	public WebElement lst_GroundingStatus;
	
	@FindBy(xpath = "//div[@title='Save']")
	public WebElement btn_Save;
	
	@FindBy(xpath = "//div[@id='secId:vboxlist:j_id_id3pc50:innerTbl::db']//tr[1]")
	public WebElement vfy_GroundingHistoryDetails;
	
	@FindBy(xpath = "(//label[text()='Mileage']/../../td[2]/input)[2]")
	public WebElement txt_Mileage;
	
	public String lbl_DealerInfo = "(//div[@title='%s'])[1]";
	
	@FindBy(xpath = "//label[text()='Dealer type']/../../td[2]/select")
	public WebElement lst_DealerType;
	
	@FindBy(xpath = "//label[text()='Grounding Source']/../../td[2]/select")
	public WebElement lst_GroundingSource;
	
	@FindBy(xpath = "//label[text()='Maturity status']/../../td[2]/select")
	public WebElement lst_MaturityStaus;
	
	public String txt_ContactDeatils = "//label[text()='%s']/../../td[2]//input";
	
	public String lst_DealerDeatils = "//label[text()='%s']/../../td[2]//select";
	public String txt_DealerDeatils = "//label[text()='%s']/../../td[2]//input";
	
	public String  txt_VehicleDeatils= "//div[@id='secId:vboxlist:j_id_id6pc50']//label[text()='%s']/../../td[2]//input";
	public String lst_VehicleDeatils = "//div[@id='secId:vboxlist:j_id_id6pc50']//label[text()='%s']/../../td[2]//select";

	@FindBy(xpath = "//div[@title='Auction List']//h2")
	public WebElement lbl_AuctionList;
	
	@FindBy(xpath = "//div[@id='secId:vboxlist:j_id_id0pc28']//div//h3[text()='Auction Detail']")
	public WebElement lbl_AuctionDetail;
	
	public String vfytbl_AuctionList = "//div[@id='secId:vboxlist:j_id_id4pc27:innerTbl::ch']//div[text()='%s']";
	public String vfy_AuctionDetail="//div[@id='secId:vboxlist:j_id_id0pc28']//label[text()='%s']";
	
	@FindBy(xpath = "//a[@class='eventsPanelLinkClass']//span[text()='Auctions Management']")
	public WebElement lnk_AuctionsManagement;
	
	@FindBy(xpath = "//label[text()='Auction Status']/../../td[2]//select[@id='cont_note:j_id_id6pc10::content']")
	public WebElement lst_AuctionStatus;
	
	@FindBy(xpath = "//label[text()='Sell Method']/../../td[2]//select[@id='cont_note:j_id_id41pc10::content']")
	public WebElement lst_SellMethod;

	@FindBy(xpath = "//label[text()='Auction type']/../../td[2]//select[@id='cont_note:j_id_id13pc10::content']")
	public WebElement lst_AuctionType;
	
	@FindBy(xpath="//label[text()='Phase']/../../td[2]/select")
	public WebElement lst_Phase;
	
	@FindBy(xpath = "//div[@id='secId:vboxlist:s_cc_aab::tabh']//a[text()='Repossession']")
	public WebElement tab_Repossession;
	
	@FindBy(xpath = "//h2[text()='Repossession Detail']")
	public WebElement lbl_RepossessionDetail;

	public String lst_ExternalDealerDeatils="//div[@id='secId:vboxlist:j_id_id36pc50']//label[text()='%s']/../../td[2]//input";
	
	//added 5/30/2019
	@FindBy(xpath="//a[@class='eventsPanelLinkClass']//span[text()='Update Deficiency Indicator']")
	public WebElement lnk_UpdateDeficiencyIndicator;
}
