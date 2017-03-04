package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.CommonPage;

public class BuyProductPage {
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='add_to_cart']/button")
	private WebElement buyButton;
	
	public BuyProductPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCar(){
		//Common.ExplicitWait(driver, buyButton);
		CommonPage.OnClick(buyButton);
	}
	
	
}
