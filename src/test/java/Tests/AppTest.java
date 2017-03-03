package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Chain.ChainPage;
import Core.Common;
import Utils.Const;

public class AppTest {
	public WebDriver driver;
	private ChainPage responsibleChain;
		
	public AppTest(){
		driver = Common.instanceBrowser(driver, Const.firefox);
		responsibleChain = new ChainPage(driver);
	}
	
	@BeforeTest
	@Parameters({"URL"})
	public void navigate(String url){
		driver.get(url);
		Assert.assertEquals(driver.getTitle(), Const.titleMainPage );
	}
	
	
	@Test(priority=2)
	public void goToLogin(){
		responsibleChain.goToLogin();
		Assert.assertEquals(driver.getTitle(), Const.titleMainPage);
	}
	
	@Test(priority=3)
	@Parameters({"mail", "pass"})
	public void initSession(@Optional("No hay mail") String mail, @Optional("No hay password") String pass){
		responsibleChain.inputToMyAccount(mail, pass);
		Assert.assertEquals(driver.getTitle(), Const.titleLoginWeb);
	}
	
	@Test(priority=4)
	@Parameters({"nameProduct"})
	public void searchProductInStore(String productName){
		responsibleChain.searchProductInStore(productName);
		Assert.assertNotNull(productName, null);
	}
	
	@Test(priority=5)
	public void selectProduct(){
		responsibleChain.selectProductFounded();
		Assert.assertEquals(driver.getTitle(), Const.titleResultsProductWeb);
	}
	
	@Test(priority=6)
	public void buyProduct(){
		responsibleChain.buyProduct();
		Assert.assertNotNull(driver.getTitle(), Const.titleProductSelected);
	}
	
	@AfterMethod
	public void OnFailure(ITestResult testResult){
		if(testResult.getStatus()== ITestResult.FAILURE){
			Common.captureScreenShot(driver);
		}else{
			System.out.println("La prueba fue exitosa");
		}
	}
}