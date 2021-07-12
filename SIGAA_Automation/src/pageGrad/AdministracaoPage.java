package pageGrad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author iwasse
 *
 *         Página Administração no qual possui a função Logar Como
 */

public class AdministracaoPage {

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/center/table/tbody/tr/td[2]/input")
	WebElement loginAs;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/center/table/tfoot/tr/td/input")
	WebElement logarbtn;

	public AdministracaoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Página Administração, onde há o "Logar como"
	public void logarComo(String login) {
		loginAs.sendKeys(login);
		logarbtn.click();
	}

}
