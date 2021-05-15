package SeleniumAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LaunchApplication{
	
	public static void main(String args[]) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	
	ChromeDriver driver = new ChromeDriver(); 
	driver.get("http://leaftaps.com//opentaps/control/main");
	driver.manage().window().maximize();
	
	driver.findElementById("username").sendKeys("DemosalesManager");
	
    WebElement password1 = driver.findElementById("password");
    
	password1.clear();
	password1.sendKeys("crmsfa");
	driver.findElementByClassName("decorativeSubmit").click();
	Thread.sleep(5000);
	
	//Landing Page
	
	Assert.assertEquals(driver.getTitle(), "Leaftaps - TestLeaf Automation Platform");
	driver.findElementByLinkText("CRM/SFA").click();
	
	  //Create Lead//
	 driver.findElementByLinkText("Leads");
     driver.findElementByLinkText("Create Lead").click();
     
     //Company Information//
     driver.findElementById("createLeadForm_companyName").sendKeys("WorkfromHome");
     driver.findElementById("createLeadForm_firstName").sendKeys("Damodar");
     driver.findElementById("createLeadForm_lastName").sendKeys("Baviri");
     
     WebElement source = driver.findElementById("createLeadForm_dataSourceId");
     Select sourceDropdown = new Select(source);
     sourceDropdown.selectByValue("LEAD_EMPLOYEE");
     WebElement marketing = driver.findElementById("createLeadForm_marketingCampaignId");
     Select marketingDropdown = new Select(marketing);
     marketingDropdown.selectByValue("9002");
	
     driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Damodar");
     driver.findElementById("createLeadForm_lastNameLocal").sendKeys("Baviri");
     driver.findElementById("createLeadForm_personalTitle").sendKeys("Mr");
     driver.findElementById("createLeadForm_birthDate").sendKeys("02/20/84");
     driver.findElementById("createLeadForm_generalProfTitle").sendKeys("Mr");
     driver.findElementById("createLeadForm_departmentName").sendKeys("CDS");
     driver.findElementById("createLeadForm_annualRevenue").sendKeys("80000");
	
     
     WebElement currency = driver.findElementById("createLeadForm_currencyUomId");
     Select currencyDropdown = new Select(currency);
     currencyDropdown.selectByValue("INR");
     WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
     Select industryDropdown = new Select(industry);
     industryDropdown.selectByValue("IND_GEN_SERVICES");
     driver.findElementById("createLeadForm_numberEmployees").sendKeys("100");
     WebElement ownership = driver.findElementById("createLeadForm_ownershipEnumId");
     Select ownershipDropdown = new Select(ownership);
     ownershipDropdown.selectByValue("OWN_PUBLIC_CORP");
     driver.findElementById("createLeadForm_sicCode").sendKeys("AIIMS");
     driver.findElementById("createLeadForm_tickerSymbol").sendKeys("DENIS");
     driver.findElementById("createLeadForm_description").sendKeys("Damodar_description");
     driver.findElementById("createLeadForm_importantNote").sendKeys("Damodar_First SeleniumProgram");
     //Contact Information//
     
     driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("91");
     driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("99404");
     driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("452");
     driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("1234");
     driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("Damodar");
     driver.findElementById("createLeadForm_primaryEmail").sendKeys("baviri.damodar@gmai.com");
     driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("https://damodar.baviri.com");
     driver.findElementById("createLeadForm_generalToName").sendKeys("Damodar Baviri");
     driver.findElementById("createLeadForm_generalAttnName").sendKeys("Testleaf Lead");
     driver.findElementById("createLeadForm_generalAddress1").sendKeys("Himayat Nagar");
     driver.findElementById("createLeadForm_generalAddress2").sendKeys("Srikakulam");
     driver.findElementById("createLeadForm_generalCity").sendKeys("Srikakulam");
     driver.findElementById("createLeadForm_generalPostalCode").sendKeys("505215");
     
     
     WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
     Select countryDropdown = new Select(country);
     countryDropdown.selectByValue("IND");
     Thread.sleep(2000);
     WebElement state = driver.findElementById("createLeadForm_generalStateProvinceGeoId");
     Select stateDropdown = new Select(state);
     stateDropdown.selectByValue("IN-AP");
     driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("1234");
     //Submit Lead//
     driver.findElementByClassName("smallSubmit").click();
     
     driver.findElementByLinkText("Duplicate Lead").click();
     Thread.sleep(2000);
     driver.findElementById("createLeadForm_companyName").clear();
     String duplicateCompanyName = "AIIMS";
     driver.findElementById("createLeadForm_companyName").sendKeys(duplicateCompanyName);
     driver.findElementByClassName("smallSubmit").click();
     Thread.sleep(2000);
     //Get The Duplicate Company name and Verify//
     WebElement newCompanyName = driver.findElementById("viewLead_companyName_sp");
     String newCompanyNameText = newCompanyName.getText();
     String newCompanyNameAfterTrim = newCompanyNameText.replaceAll("[0-9()]", "").trim();
     String duplicateCompanyNameAfterTrim = duplicateCompanyName.trim();
     Assert.assertEquals(newCompanyNameAfterTrim, duplicateCompanyNameAfterTrim);
     //Close Browser//
     
          
     Thread.sleep(5000);
     
     
        
     
     
     
     
	//driver.close();
	}
	
	
	
}