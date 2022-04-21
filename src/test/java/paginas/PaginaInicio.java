package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos de la página que voy a utilizar en la automatización
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(linkText="Contact us")
	WebElement lnkContactUs;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		// Inicializa los elementos de la página
		PageFactory.initElements(driver, this);
	}
	
	// Acciones (métodos)
	public void clicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void clicEnContactUs() {
		lnkContactUs.click();
	}
}
