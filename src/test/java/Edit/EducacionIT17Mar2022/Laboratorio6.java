package Edit.EducacionIT17Mar2022;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Laboratorio6 {
	String url = "http://automationpractice.com";
	String chromeDriverPath = "..\\EducacionIT17Mar2022\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\EducacionIT17Mar2022\\Drivers\\geckodriver.exe";
	WebDriver driver;
	File screen;
	String imagePath = "..\\EducacionIT17Mar2022\\Evidencias\\";
	
	@Parameters("navegador")
	@BeforeTest
	public void setUp(String navegador) {
		if (navegador.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		} else if (navegador.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() throws IOException {
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "01_pantalla_principal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("shirt");
		
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "02_palabra_a_buscar.jpg"));

		txtBuscador.sendKeys(Keys.ENTER);
		
		// Captura de Pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "03_resultado_busqueda.jpg"));
	}
	
	//@AfterTest
	//public void tearDown() {
	//	driver.close();
	//}
}
