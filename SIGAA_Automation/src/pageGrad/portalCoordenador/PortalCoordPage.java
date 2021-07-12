package pageGrad.portalCoordenador;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author iwasse Página principal do portal do coordenador
 */

public class PortalCoordPage {

	WebDriver driver;
	@FindBy(how = How.XPATH, using = ".//*[@id='cmSubMenuID8']/table/tbody/tr[7]/td[2]")
	WebElement ofertarTurma;
	
	@FindBy(how = How.XPATH, using="/html/body/div[2]/div[2]/div[1]/ul/li")
	WebElement label;

	public PortalCoordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Menu Ensino -> Matricula Online -> Realizar Matrícula

	public void clickOfertarTurma() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.visibility='visible';", ofertarTurma);
		ofertarTurma.click();

	}
	
	public boolean verifyMsg(){
		if(label.getText().trim().contains("cadastrada com sucesso!")){
			return true;
		}else{
			return false;
		}
	}
}
