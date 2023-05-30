package Generic_Component;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base_Class {
	
	public WebDriver driver;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	public static Logger log = Logger.getLogger(Base_Class.class);

	Utility c1 = new Utility();
	String btype = c1.reading_Properties("browsertype");
	
	@BeforeMethod
	public void launchApp() {
	
	if(btype.equals("Firefox")) {
		driver = new FirefoxDriver();
	} else if(btype.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "E:\\browser_driver\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if(btype.equals("IE")) {
		driver = new InternetExplorerDriver();
	}
		
	driver.get("https://books.rediff.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
	
	public String capture_Screenshot(String TC_ID, String Order_Set) throws IOException {
	Date date = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
	String str = df.format(date)+".png";
	
	TakesScreenshot screenshot = (TakesScreenshot) driver; 
	File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotAs, new File("E:\\hybridFramework\\Screenshots\\"+TC_ID+"-"+Order_Set+"-"+str));
	String path = "E:\\hybridFramework\\Screenshots\\"+TC_ID+"-"+Order_Set+"-"+str;
	return path;
	}
	
	@BeforeSuite
	public void Report_extent() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String str = df.format(date);
		extentReport = new ExtentReports("E:\\hybridFramework\\Report\\Results_"+str+".html");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		extentReport.endTest(extentTest);
		extentReport.flush();
		System.out.println("Hello");
		
		
	}
	

}
