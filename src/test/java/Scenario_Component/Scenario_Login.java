package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Generic_Component.Base_Class;
import PageObject_Component.HomePage_pf;
import PageObject_Component.Login_pf;

public class Scenario_Login extends Base_Class{
	
	@Test(dataProvider = "dp_invalidLogin", dataProviderClass = DataProvider_Component.dataProvider_loadData.class)
	public void invalidLogin(Map<String,String> login) throws IOException {
		
		SoftAssert sAssert = new SoftAssert();
		
		String Uname = login.get("UserName");
		String password = login.get("Password");
		String TC_ID = login.get("TC_ID");
		String Order_Set = login.get("Order_Set");
		String Expected_Results = login.get("Expected_Results");
		
		extentTest =  extentReport.startTest(TC_ID);
		extentTest.log(LogStatus.INFO, "Executing the testcases: "+TC_ID);
		
		System.out.println(Uname);
		System.out.println(password);
		log.info("Executing the testcase "+TC_ID+" Order Set is: "+Order_Set);
		//extentTest.log(LogStatus.PASS, "Executing the testcase "+TC_ID+" Order Set is: "+Order_Set);
		System.out.println("Return Value: "+capture_Screenshot(TC_ID, Order_Set));
		extentTest.log(LogStatus.PASS, "Passed as Actual Result is 10 Expected Result is ",extentTest.addScreenCapture(capture_Screenshot(TC_ID, Order_Set)));
		HomePage_pf home_page = new HomePage_pf(driver);
		home_page.fnsignInclick();
		
		Login_pf signin_page = new Login_pf(driver);
		signin_page.fnlogin(Uname, password);
		
		String actualResult = signin_page.fngetInvalidMsg();
		
		if(actualResult.equals(Expected_Results)) {
			log.info("Passed. Actual Result is: "+actualResult);
			extentTest.log(LogStatus.PASS, "Passed. Actual Result is: "+actualResult);
		} else {
			log.info("Failed. Actual Result is: "+actualResult);
			extentTest.log(LogStatus.FAIL, "Failed. Actual Result is: "+actualResult);
			capture_Screenshot(TC_ID,Order_Set);
			sAssert.fail("Failed. Actual Result is: "+actualResult);
		}
			
		sAssert.assertAll();
		
	}
	
	
	@Test(dataProvider = "dp_validLogin", dataProviderClass = DataProvider_Component.dataProvider_loadData.class)
	public void testValidLogin(Map<String,String> login) throws IOException {
		SoftAssert sAssert = new SoftAssert();
		
		String Uname = login.get("UserName");
		String password = login.get("Password");
		String TC_ID = login.get("TC_ID");
		String Order_Set = login.get("Order_Set");
		String Expected_Results = login.get("Expected_Results");
		
		extentTest =  extentReport.startTest(TC_ID);
		extentTest.log(LogStatus.INFO, "Executing the testcases: "+TC_ID);
		
		log.info("Executing the testcase "+TC_ID+" Order Set is: "+Order_Set);
		extentTest.log(LogStatus.PASS, "Executing the testcase "+TC_ID+" Order Set is: "+Order_Set);
		HomePage_pf home_page = new HomePage_pf(driver);
		home_page.fnsignInclick();
		
		Login_pf signin_page = new Login_pf(driver);
		signin_page.fnlogin(Uname, password);
		
		String actualResult = home_page.fnVerifyWelcomeMsg();
		
		if(actualResult.equals(Expected_Results)) {
			log.info("Passed. Actual Result is: "+actualResult);
			extentTest.log(LogStatus.PASS, "Passed. Actual Result is: "+actualResult, extentTest.addScreenCapture(capture_Screenshot(TC_ID,Order_Set)));
			capture_Screenshot(TC_ID,Order_Set);
		} else {
			log.info("Failed. Actual Result is: "+actualResult);
			extentTest.log(LogStatus.FAIL, "Failed. Actual Result is: "+actualResult, extentTest.addScreenCapture(capture_Screenshot(TC_ID,Order_Set)));
			capture_Screenshot(TC_ID,Order_Set);
			sAssert.fail("Failed. Actual Result is: "+actualResult);
		}
			
		sAssert.assertAll();
			
	}
	
	
	
	

}
