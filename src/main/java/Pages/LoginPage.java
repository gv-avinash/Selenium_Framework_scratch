package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	protected WebDriver driver;
	
	@FindBy(id="Email") private WebElement Uname;
	@FindBy(id="Password") private WebElement Pwd;
	@FindBy(className="login-button") private WebElement Btn;

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUname(String name) {
		Uname.clear();
		Uname.sendKeys(name);
	}
	
	public void setPwd(String pass) {
		Pwd.clear();
		Pwd.sendKeys(pass);
	}
	
	public void clickbtn() {
		Btn.click();
	}
}
