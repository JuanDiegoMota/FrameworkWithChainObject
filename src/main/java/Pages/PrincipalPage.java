package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.CommonPage;

public class PrincipalPage {
	protected WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class, 'header_user_info')]")
	private WebElement signInButton;
	
	public PrincipalPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToMyAccount(){
		CommonPage.OnClick(signInButton);
	}
}
