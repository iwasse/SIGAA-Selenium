package pageGrad.CATG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author iwasse
 * 
 *         Formulário de criação de curso
 */

public class DadosCursoPage {

	WebDriver driver;

	public DadosCursoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "formulario:nome")
	WebElement idCurso; // *
	@FindBy(how = How.ID, using = "formulario:municipio")
	WebElement idMunicipio; // *
	@FindBy(how = How.ID, using = "formulario:campus")
	WebElement idCampus;
	@FindBy(how = How.ID, using = "formulario:grauAcadem")
	WebElement idGrau;
	@FindBy(how = How.ID, using = "formulario:modalidade")
	WebElement idModalidade;
	@FindBy(how = How.ID, using = "formulario:codigoINEP")
	WebElement idInep;
	@FindBy(how = How.ID, using = "formulario:codigoINEP")
	WebElement idOCDE;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/table/tbody/tr[10]/td/div/table/tbody/tr/td/input")
	List<WebElement> idTurno;
	@FindBy(how = How.ID, using = "formulario:unidade")
	WebElement idUni;
	@FindBy(how = How.ID, using = "formulario:unidade2")
	WebElement idUni2;
	@FindBy(how = How.ID, using = "formulario:titulacaoMasculino")
	WebElement idTitm;
	@FindBy(how = How.ID, using = "formulario:titulacaoFeminino")
	WebElement idTitf;
	@FindBy(how = How.ID, using = "formulario:area")
	WebElement idArea;
	@FindBy(how = How.ID, using = "formulario:areaVestibular")
	WebElement idAreaVest;
	@FindBy(how = How.ID, using = "formulario:tipoOfertaCurso")
	WebElement idTipoOfertaCurso;
	@FindBy(how = How.ID, using = "formulario:regimeLetivo")
	WebElement idRegime;
	@FindBy(how = How.ID, using = "formulario:situacao")
	WebElement idSitu;
	@FindBy(how = How.ID, using = "formulario:inicioFuncionamento")
	WebElement idInicioCurso;
	@FindBy(how = How.NAME, using = "formulario:permiteColacaoGrau")
	WebElement idColaGrau;
	@FindBy(how = How.ID, using = "formulario:website")
	WebElement idWeb;
	@FindBy(how = How.ID, using = "formulario:projetoGraduacao")
	WebElement idProjetoPed;
	@FindBy(how = How.XPATH, using = ".//*[@id='formulario']/table/tbody/tr[24]/td/table/tbody/tr[1]/td/select")
	WebElement idSelectAto;
	@FindBy(how = How.ID, using = "formulario:ato_normativo")
	WebElement idAto;
	@FindBy(how = How.ID, using = "formulario:dataAtoNormativo")
	WebElement idDataAto;
	@FindBy(how = How.ID, using = "formulario:dataPublicacao")
	WebElement idDataPub;
	@FindBy(how = How.ID, using = "formulario:btProximoPasso")
	WebElement idSubmit;
	@FindBy(how = How.ID, using = "formulario:btCancelar")
	WebElement idCancel;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/table/tbody/tr[7]/td/table/tbody/tr/td[1]/input")
	WebElement yes;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/table/tbody/tr[7]/td/table/tbody/tr/td[2]/input")
	WebElement nope;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/table/tbody/tr[6]/td/table/tbody/tr/td[1]/input")
	WebElement yeshab;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/table/tbody/tr[6]/td/table/tbody/tr/td[2]/input")
	WebElement nohab;

	// Nome:*
	public void cursoNome(String sNomeCurso) {
		idCurso.sendKeys(sNomeCurso);
	}

	// Município:*
	public void cursoMunicipio(String nomeMunicipio) throws InterruptedException {
		new Select(idMunicipio).selectByVisibleText(nomeMunicipio);
		Thread.sleep(1000);
	}

	// Campus:*
	public void cursoCampus(String sCampusCurso) {
		new Select(idCampus).selectByValue(sCampusCurso);
	}

	// Grau Acadêmico:*
	public void grauCurso(String grau) {
		new Select(idGrau).selectByVisibleText(grau);
	}

	// Modalidade:*
	public void modalidadeCurso(String modalidade) {
		new Select(idModalidade).selectByVisibleText(modalidade);
	}

	// Possui Habilitação?*
	public void habCurso(String habilitacao) {

		if (habilitacao.equalsIgnoreCase("sim")) {
			yeshab.click();
		} else {
			nohab.click();
		}
	}

	// Possui Convênio Acadêmico?*
	public void convenioCurso(String convenio) {

		if (convenio.equalsIgnoreCase("sim")) {
			yes.click();
		} else {
			nope.click();
		}
	}

	// Código INEP:
	public void codinepCurso(String inep) {
		idInep.sendKeys(inep);
	}

	// Código OCDE:
	public void codocdeCurso(String ocde) {
		idOCDE.sendKeys(ocde);
	}

	// Turnos de Ingresso Predominantes:*
	public void turnoCurso(int turno) {
		idTurno.get(turno).click();
	}

	// Unidade de Vínculo:*
	public void unidCurso(String unitOne) {
		new Select(idUni).selectByValue(unitOne);
	}

	// Unidade de Vínculo 2:
	public void unid2Curso(String unitTwo) {
		new Select(idUni2).selectByValue(unitTwo);
	}

	// Titulação para o Gênero Masculino:
	public void titmascCurso(String titulacaom) {
		idTitm.sendKeys(titulacaom);
	}

	// Titulação para o Gênero Feminino:
	public void titfemCurso(String titulacaof) {
		idTitf.sendKeys(titulacaof);
	}

	// Área de Conhecimento:
	public void areaCurso(String sAreaCurso) {
		new Select(idArea).selectByValue(sAreaCurso);
	}

	// Área de Conhecimento do Vestibular:
	public void areaVestCurso(String sAreaVestCurso) {
		new Select(idAreaVest).selectByValue(sAreaVestCurso);
	}

	// Tipo de Oferta do Curso:*
	public void ofertaCurso(String sOfertaCurso) {
		new Select(idTipoOfertaCurso).selectByValue(sOfertaCurso);
	}

	// Regime Letivo:*
	public void regimeCurso(String sRegimeCurso) {
		new Select(idRegime).selectByValue(sRegimeCurso);
	}

	// Situação:*
	public void situCurso(String sSituCurso) {
		new Select(idSitu).selectByValue(sSituCurso);
	}

	// Início de Funcionamento:
	public void inicioCurso(String sInicioCurso) {
		idInicioCurso.sendKeys(sInicioCurso);
	}

	// Permite colação de grau?
	public void colagrauCurso(String sColagrauCurso) {
		new Select(idColaGrau).selectByValue(sColagrauCurso);
	}

	// Website do curso:
	public void websiteCurso(String site) {
		idWeb.sendKeys(site);
	}

	// Documento do Projeto Pedagógico:
	// public void docped(String sDocped){ idProjetoPed.}

	// Ato Normativo:*
	public void atoSCurso(String sAtoSCurso) {
		new Select(idSelectAto).selectByValue(sAtoSCurso);
	}

	// Ato Normativo:* (segundo campo)
	public void atoCurso(String sAtoCurso) {
		idAto.sendKeys(sAtoCurso);
	}

	// Data do Ato Normativo:*
	public void dataAtoCurso(String sDataAtoCurso) {
		idDataAto.sendKeys(sDataAtoCurso);
	}

	// Data da Publicação:*
	public void dataPubCurso(String sDataPubCurso) {
		idDataPub.sendKeys(sDataPubCurso);
	}

	// Botão Próximo Passo
	public void clickNext() {
		idSubmit.click();
	}

	// Botão Cancelar
	public void clickCancel() {
		idCancel.click();
	}

}
