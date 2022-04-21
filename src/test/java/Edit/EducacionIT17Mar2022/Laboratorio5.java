package Edit.EducacionIT17Mar2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT17Mar2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		// Acciones que se van a ejecutar al inicio de toda la suite de pruebas 
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="CP03 - Completar Formulario Contáctanos", priority=300)
	public void irAContactUs() {
		// Acciones de la prueba que queremos hacer
		driver.findElement(By.linkText("Contact us")).click();
		
		Select contact = new Select(driver.findElement(By.name("id_contact")));
		contact.selectByVisibleText("Webmaster");
		
		driver.findElement(By.cssSelector("#fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.id("message")).sendKeys("Mensaje de Felicitacion");
		
		driver.findElement(By.name("submitMessage")).click();
	}
	
	@Test(description="CP02 - Hacer Búsqueda de Palabra o Frase", priority=200)
	public void hacerBusqueda() {
		// Acciones de la prueba que queremos hacer
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // escribir en el campo de texto
		txtBuscador.sendKeys(Keys.ENTER); // simular que presiono la tecla ENTER
		
		String tituloEsperado = "X"; //"Search - My Store";
		Assert.assertEquals(driver.getTitle(), tituloEsperado);
		
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		Assert.assertEquals(driver.getCurrentUrl(), urlEsperada);
	}
	
	@Test(description="CP01 - Registrar Usuario", priority=150)
	public void registrarUsuario() {
		// Acciones de la prueba que queremos hacer
		// Ingresar el correo y hacer clic en el botón
		driver.findElement(By.id("email_create")).sendKeys("micorreo" + Math.random() + "@correo.com");
		driver.findElement(By.name("SubmitCreate")).click();
		
		// Espera para capturar la transición de página
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender1")));
				
		// Completar el formulario y hacer clic en el botón
		driver.findElement(By.cssSelector("#id_gender1")).click(); // Title
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Patricio"); // Nombre
		driver.findElement(By.id("customer_lastname")).sendKeys("Torres"); // Apellido
		driver.findElement(By.name("passwd")).sendKeys("1q2w3e4r5t"); // Contraseña
				
		Select dia = new Select(driver.findElement(By.cssSelector("#days")));
		dia.selectByValue("18"); // Día de nacimiento
				
		Select mes = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		mes.selectByVisibleText("June "); // Mes de nacimiento
				
		Select anio = new Select(driver.findElement(By.id("years")));
		anio.selectByIndex(20); // Año de nacimiento
				
		driver.findElement(By.name("newsletter")).click(); // Check Newsletter
		driver.findElement(By.cssSelector("#optin")).click(); // Check Ofertas Especiales
			
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("MiDireccion 123 4B"); // Direccion
		driver.findElement(By.id("city")).sendKeys("Cordoba"); // Ciudad
				
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Florida"); // Estado
				
		driver.findElement(By.name("postcode")).sendKeys("54345"); // Código Postal
				
		Select pais = new Select(driver.findElement(By.cssSelector("#id_country")));
		pais.selectByValue("21"); // Pais
				
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("13054657685");
				
		WebElement alias = driver.findElement(By.id("alias"));
		alias.clear();
		alias.sendKeys("Mi Casa");
				
		driver.findElement(By.name("submitAccount")).click();
	}
	
	@AfterSuite
	public void tearDown() {
		// Acciones que se van a ejecutar al final de toda la suite de pruebas
		//driver.close();
	}
	
}
