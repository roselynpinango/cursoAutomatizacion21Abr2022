package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaContactUs {
	@FindBy(xpath="//select[@id='id_contact']")
	WebElement selSubject;
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(id="id_order")
	WebElement txtOrderId;
	
	@FindBy(css="#fileUpload")
	WebElement fileAttach;
	
	@FindBy(name="message")
	WebElement txtMessage;
	
	@FindBy(xpath="//button[@id='submitMessage']")
	WebElement btnSend;
	
	public PaginaContactUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void seleccionarSubjectHeading(String subject) {
		Select list = new Select(selSubject);
		list.selectByVisibleText(subject);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirOrderId(String orderId) {
		txtOrderId.sendKeys(orderId);
	}
	
	public void escribirAttached(String attached) {
		fileAttach.sendKeys(attached);
	}
	
	public void escribirMessage(String message) {
		txtMessage.sendKeys(message);
	}
	
	public void clicEnSend() {
		btnSend.click();
	}
}
