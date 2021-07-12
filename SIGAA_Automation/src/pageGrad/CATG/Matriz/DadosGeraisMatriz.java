package pageGrad.CATG.Matriz;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DadosGeraisMatriz {
	
	
	@FindBy(how=How.ID,using="formulario:avancar")
	WebElement  btnProxPasso;
	
	
	public void clickBtnProxPasso(){
		btnProxPasso.click();
	}

}
