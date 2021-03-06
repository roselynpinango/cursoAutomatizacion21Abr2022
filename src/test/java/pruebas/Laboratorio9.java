package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio9 {
	String url = "https://demo.guru99.com/test/table.html";
	String driverPath = "..\\EducacionIT17Mar2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void verValorTabla() {
		System.out.println("Tercera Fila, Segunda Columna: " + driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText());
		System.out.println("Cambio en el archivo - GIT");
	}
}
