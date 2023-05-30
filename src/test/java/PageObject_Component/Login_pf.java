package PageObject_Component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_pf {
	
	@FindBy(name = "logid")
	public WebElement email_text;
	
	@FindBy(name = "pswd")
	public WebElement password_text;
	
	@FindBy(xpath = "//*[@value='Login']")
	public WebElement login_btn;
	
	@FindBy(xpath = "//b[contains(text(),'Sorry we were unable')]")
	public WebElement error_msg;
			
	
	public Login_pf(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void fnlogin(String uname, String pwd) {
		email_text.sendKeys(uname);
		password_text.sendKeys(pwd);
		login_btn.click();		
	}
	
	public String fngetInvalidMsg() {
		return error_msg.getText();
	}
	
	

}
