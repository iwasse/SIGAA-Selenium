package pageGrad.portalCoordenador.turmas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DadosTurmaResumo {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using=".//*[@id='resumo:btCadastrar']") WebElement register;
	
	public DadosTurmaResumo(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void register(){
		register.click();
	}
	
}
