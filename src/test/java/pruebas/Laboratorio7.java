package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaContactUs;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio7 {
	WebDriver driver;
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT17Mar2022\\Drivers\\chromedriver.exe";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginDatosPositivos() {
		// Paso 1: Hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();
		
		// Paso 2: Completar el correo, contraseña y hacer clic en el botón
		PaginaLogin login = new PaginaLogin(driver);
		// Caso Negativo: login.escribirEmail("correo12Abr2022@mailinator.com");
		login.escribirEmail("micorreo0.28325844194589145@correo.com");
		login.escribirPassword("1q2w3e4r5t");
		login.clicEnSignIn();
		
		// Validamos que luego de las acciones no se quede en la página login
		Assert.assertNotEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication");
	}
	
	@Test
	public void loginDatosNegativos() {
		// Paso 1: Hacer clic en Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();
		
		// Paso 2: Completar el correo, contraseña y hacer clic en el botón
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail("correo12Abr2022@mailinator.com");
		login.escribirPassword("1q2w3e4r5t");
		login.clicEnSignIn();
		
		// Validamos que luego de las acciones no se quede en la página login
		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication");
	}
	
	@Test
	public void irAContactUs() {
		// Hacer clic en Contact Us
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnContactUs();
		
		// Llenar el formulario
		PaginaContactUs contactUs = new PaginaContactUs(driver);
		contactUs.seleccionarSubjectHeading("Customer service");
		contactUs.escribirEmail("micorreo0.28325844194589145@correo.com");
		contactUs.escribirOrderId("1");
		contactUs.escribirAttached("C:\\addIntegerData.txt");
		contactUs.escribirMessage("Mensaje de felicitación");
		contactUs.clicEnSend();
	}
}
