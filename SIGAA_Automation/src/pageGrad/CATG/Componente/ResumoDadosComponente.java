package pageGrad.CATG.Componente;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResumoDadosComponente {

	WebDriver driver;
	
	@FindBy(how = How.XPATH, using=".//*[@id='form:senha']")
	WebElement senha;
	@FindBy(how = How.XPATH, using=".//*[@id='form:cadastrar']")
	WebElement cadastrar;

	
	public ResumoDadosComponente() {
		PageFactory.initElements(driver, this);
	}

	public void cadastrar(){
		senha.clear();
		senha.sendKeys("12345");
		cadastrar.click();
	}
	
}
