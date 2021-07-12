package pageGrad.portalDiscente;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author iwasse
 *
 *         Página inicial do portal do discente
 */

public class PortalDiscentePage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//*[@id='cmSubMenuID3']/table/tbody/tr[1]/td[2]")
	WebElement realizarMat;

	public PortalDiscentePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Clica em: Ensino -> Matricula Online -> Realizar Matrícula
	public void clickRealizarMat() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.visibility='visible';", realizarMat);
		realizarMat.click();

	}
}
