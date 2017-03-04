package Tests;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Chain.ChainPage;
import Core.CommonTest;
import Utils.Const;

public class AppTest extends CommonTest {
	private ChainPage responsibleChain;
	
	@Parameters({"nameBrowser"})
	public AppTest(String nameBrowser){
		super(nameBrowser);
		responsibleChain = new ChainPage(driver);
	}
	
	@BeforeTest
	@Parameters({"URL"})
	public void navigate(String url){
		driver.get(url);
		Assert.assertEquals(driver.getTitle(), Const.titleMainPage );
	}
	
	@Test
	@Parameters({"mail", "pass", "nameProduct"})
	public void buyProduct(@Optional("buscandoPractice@gmail.com") String mail, @Optional("123456") String pass, String nameProduct){
		responsibleChain.buyProductFounded(mail, pass, nameProduct);
		Assert.assertNotNull(driver.getTitle(), Const.titleProductSelected);
	}
	
}