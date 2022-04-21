package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	// Elementos
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(name="passwd")
	WebElement txtPassword;
	
	@FindBy(css="#SubmitLogin")
	WebElement btnSignIn;
	
	@FindBy(linkText="Sign out")
	WebElement lnkSignOut;
	
	// Constructor
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones (Métodos)
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clicEnSignIn() {
		btnSignIn.click();
	}
	
	public void completarFormularioLogin(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnSignIn.click();
	}
	
	public void clicSignOut() {
		lnkSignOut.click();
	}
}
