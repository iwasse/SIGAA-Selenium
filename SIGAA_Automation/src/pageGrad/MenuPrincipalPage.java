package pageGrad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MenuPrincipalPage {

	@FindBy(how = How.XPATH, using = ".//*[@id='modulos']/ul[1]/li[5]/a")
	WebElement modgrad;
	@FindBy(how = How.XPATH, using = ".//*[@id='modulos']/ul[1]/li[21]/a")
	WebElement modPs;
	@FindBy(how = How.CLASS_NAME, using = "sair-sistema")
	WebElement logoff;
	@FindBy(how = How.XPATH, using = ".//*[@id='portais']/ul/li[5]/a")
	WebElement portCoord;
	@FindBy(how = How.LINK_TEXT, using = "Portal do Discente")
	WebElement pdis;

	public MenuPrincipalPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Acessar Módulo Graduação
	public void modGrad() {
		modgrad.click();
	}

	// Acessar Módulo Processo Seletivo
	public void modPS() {
		modPs.click();
	}

	// Acessar Portal Coord. Graduação
	public void portCoord() {
		portCoord.click();
	}

	// Clicar em Sair
	public void logOff() {
		logoff.click();
	}

	public void portalDisc() {
		pdis.click();
	}

}
