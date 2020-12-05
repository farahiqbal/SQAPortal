package QAClick.SQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		//ExtentReport ,//ExtentSparkReport
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automated testcase");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Farah");
		
		
	}
	

	@Test
	public void intialDemo()
	{
		ExtentTest test=extent.createTest("initial demo");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		WebDriver driver =new ChromeDriver();

		driver.get("https://testcrm.broadlandhousinggroup.org/bhaintranet/login.aspx");
		System.out.println(driver.getTitle());
		extent.flush();
	}
	
}
