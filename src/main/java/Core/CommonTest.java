package Core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;


public class CommonTest {
	protected WebDriver driver;
	
	public CommonTest(String nameBrowser){
		driver = CommonPage.instanceBrowser(nameBrowser);
	}
	
	@AfterMethod
	public void OnFailure(ITestResult testResult){
		if(testResult.getStatus()== ITestResult.FAILURE){
			CommonPage.captureScreenShot(driver);
		}else{
			System.out.println("La prueba fue exitosa");
		}
	}
	
	@AfterSuite
	public void executeClose(){
		closeDriver();
	}
	
	public void closeDriver(){
		System.out.println("Cerrando el driver");
		driver.close();
		driver.quit();
	}
}
