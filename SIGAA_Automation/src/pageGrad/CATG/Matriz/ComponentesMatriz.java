package pageGrad.CATG.Matriz;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ComponentesMatriz {
	
	@FindBy(how=How.XPATH,using=".//*[@id='conteudo']/table/tfoot/tr/td/input[4]")
	WebElement  btnProxPasso;
	
	
	public void clickBtnProxPasso(){
		btnProxPasso.click();
	}
}
