package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_pf {
	
	//Identification
	@FindBy(linkText = "Sign In")
	public WebElement signIn_Lnk;
	
	@FindBy(linkText = "Sign Out")
	public WebElement signOut_Lnk;
	
	@FindBy(xpath = "//*[@id='username']/a")
	public WebElement welcome_msg;
		
	@FindBy(name = "search")
	public WebElement search_txt;
			
	//Initialisation of page factory
	public HomePage_pf(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Operation
	
	public void fnsignInclick() {
		signIn_Lnk.click();
	}
	

	public void fnsignOutclick() {
		signIn_Lnk.click();
	}
	
	
	public String fnVerifyWelcomeMsg() {
		return welcome_msg.getText();
	}
	
	public void fnenterKeyword(String keyword) {
		search_txt.sendKeys(keyword);
	}
	
}
