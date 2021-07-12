package pageGrad;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuGradAlunos {

	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form[2]/div/div[1]/div/table/tbody/tr/td[1]/a/span/em/span")
	// @CacheLookup
	WebElement abaAlunos;

	@FindBy(how = How.XPATH, using = ".//*[@id='discente']/ul/li[1]/ul/li[2]/a")
	// @CacheLookup
	WebElement linkConsultarDadosAluno;

	@FindBy(how = How.XPATH, using = ".//*[@id='discente']/ul/li[3]/ul/li[2]/a")
	// @CacheLookup
	WebElement linkEmitirHistorico;
	
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form[2]/div/div[2]/div[9]/ul/li[4]/ul/li[1]/a")
	WebElement linkAproveitarCompCurricular;
	

	public void clickAbaAlunos() {
		abaAlunos.click();
	}

	public void clickConsultarDadosAluno() {
		clickAbaAlunos();
		linkConsultarDadosAluno.click();
	}

	public void clickEmitirHistorico() {
		clickAbaAlunos();
		linkEmitirHistorico.click();
	}
	
	public void clickAproveitarCompCurricular(){
		linkAproveitarCompCurricular.click();
	}
}
