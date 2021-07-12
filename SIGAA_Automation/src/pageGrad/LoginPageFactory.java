package pageGrad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	@FindBy(how = How.NAME, using = "user.login")
	@CacheLookup
	WebElement username;
	@FindBy(how = How.NAME, using = "user.senha")
	@CacheLookup
	WebElement password;
	@FindBy(how = How.CSS, using = "input[type=\"submit\"]")
	@CacheLookup
	WebElement submit;

	public LoginPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void logar(String usuario, String senha) {
		username.sendKeys(usuario);
		password.sendKeys(senha);
		submit.click();
	}

}
