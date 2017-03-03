package Chain;

import org.openqa.selenium.WebDriver;

import Core.Common;
import Pages.BuyProductPage;
import Pages.LoginPage;
import Pages.PrincipalPage;
import Pages.ProductsResultsPage;
import Pages.SearchProductPage;

public class ChainPage {
	private WebDriver driver;
	
	private PrincipalPage mainPage;
	private LoginPage login;
	private SearchProductPage searchProduct;
	private ProductsResultsPage selectProduct;
	private BuyProductPage buyProduct;
	
	public ChainPage(WebDriver driver){
		this.driver = driver;
		mainPage = new PrincipalPage(driver);
		login = new LoginPage(driver);
		searchProduct = new SearchProductPage(driver);
		selectProduct = new ProductsResultsPage(driver);
		buyProduct = new BuyProductPage(driver);
	}
	
	public void goToLogin(){
		mainPage.goToMyAccount();
	}
	
	public void inputToMyAccount(String email, String pass){
		login.setLogin(email, pass);
		Common.ImplicitWait(driver);
	}
	
	public void searchProductInStore(String product){
		searchProduct.searchProduct(product);
	}
	
	public void selectProductFounded(){
		selectProduct.selectProduct();
	}
	
	public void buyProduct(){
		buyProduct.addProductToCar();
	}
}
