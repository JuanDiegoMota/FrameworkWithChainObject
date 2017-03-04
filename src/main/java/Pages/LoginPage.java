package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Core.CommonPage;

public class LoginPage {
	protected WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		
		//Metodo para inicializar WebElement
		PageFactory.initElements(driver, this);
	}
	
	//Definicion de los WebElement 
	@FindBy(id="email")
	private WebElement inputEmail;
	
	@FindBy(id="passwd")
	private WebElement inputPass;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButton;
	
	
	public void setLogin(String email, String pass){
		CommonPage.setText(inputEmail, email);
		CommonPage.setText(inputPass, pass);
		CommonPage.OnClick(signInButton);
	}
	
	
}
