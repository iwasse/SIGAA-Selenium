package pageGrad.CATG.Matriz;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DadosMatrizConfirmacao {
	
	@FindBy(how=How.ID,using="formulario:senha")
	WebElement  inputSenha;
	
	@FindBy(how=How.ID,using="formulario:btnConfirmar")
	WebElement  btnConfirmar;
		
	public void inputSenha(String senha){
		inputSenha.sendKeys(senha);
	}
	
	public void clickConfirmar(){
		btnConfirmar.click();
	}
	
	
	

}
