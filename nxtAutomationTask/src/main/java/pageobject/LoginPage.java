package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	public LoginPage(WebDriver webdriver) {
		driver = webdriver;
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Skip (only for testing)')]")
	private WebElement skipBtn;
	
	public void setUsername(String Username) {
		username.sendKeys(Username);
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public SkipPage login(String Username, String Password) {
		setUsername(Username);
		setPassword(Password);
		clickLogin();
		return new SkipPage(driver);
	}
	
	public boolean isSkipPageOpen() {
		return skipBtn.isDisplayed();
	}
	
}
