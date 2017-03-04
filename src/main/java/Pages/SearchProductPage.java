package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.CommonPage;

public class SearchProductPage {
	protected WebDriver driver;
	
	@FindBy(css="#search_query_top")
	private WebElement inputNameProduct;
	
	@FindBy(css=".button-search")
	private WebElement searchProductButton;
	
	public SearchProductPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchProduct(String product){
		//Common.ImplicitWait(driver);
		CommonPage.setText(inputNameProduct, product);
		CommonPage.OnClick(searchProductButton);
	}
}
