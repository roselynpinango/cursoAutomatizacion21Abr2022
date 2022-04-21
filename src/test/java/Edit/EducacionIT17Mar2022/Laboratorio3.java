package Edit.EducacionIT17Mar2022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionIT17Mar2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		// Modo incognito
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		/* ChromeOptions
		 * - incognito
		 * - start-maximized
		 * - headless
		*/
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
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
	
}
