// Nombre del Paquete donde está el archivo
package Edit.EducacionIT17Mar2022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Inicio de la clase
public class Laboratorio2 {
	// Atributos
	String chromeDriverPath = "..\\EducacionIT17Mar2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT17Mar2022\\Drivers\\geckodriver.exe";
	String url = "http://automationpractice.com";
	
	WebDriver driver; // Representa al navegador

	// Metodos
	@Test
	public void buscarPalabraChrome() {
		// Paso 1 - Indicar donde esta nuestro driver (.exe)
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// Paso 2 - Abrir el navegador en la página que queremos probar
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize(); // maximizar la ventana del navegador
		driver.manage().deleteAllCookies(); // borra las cookies
		
		// Paso 3 - Hacer las acciones propias de la prueba
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // escribir en el campo de texto
		txtBuscador.sendKeys(Keys.ENTER); // simular que presiono la tecla ENTER
		
		System.out.println("URL: " + driver.getCurrentUrl()); // Escribir algo en la consola
		System.out.println("Título: " + driver.getTitle()); // Escribir algo en la consola
	}
	
	@Test
	public void buscarPalabraFirefox() {
		// Paso 1 - Indicar donde esta nuestro driver (.exe)
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		// Paso 2 - Abrir el navegador en la página que queremos probar
		driver = new FirefoxDriver();
		driver.get(url);
		
		// Paso 3 - Hacer las acciones propias de la prueba
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // escribir en el campo de texto
		txtBuscador.sendKeys(Keys.ENTER); // simular que presiono la tecla ENTER
	}
}
