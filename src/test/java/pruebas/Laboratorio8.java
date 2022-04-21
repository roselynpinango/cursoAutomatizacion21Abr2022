package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio8 {
	String url = "http://automationpractice.com";
	String driverPath = "..\\EducacionIT17Mar2022\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login desde Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.clicEnSignIn();
		
		// Verificar si el usuario se logueo
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		
		login.clicSignOut();
	}
	
	@DataProvider(name="Datos Login desde Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIT17Mar2022\\Datos\\datos_Login.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		/*
		 * Matriz Bidimensional (Arreglo) = Datos
		 * micorreo0.28325844194589145@correo.com	1q2w3e4r5t
		 * correo1@correo.com						3re34t4wt
		 * correo2@correo.com						u76ru5ur
		 * correo3@correo.com 						65ryhr5
		 * */
		
		Object[][] datos = new Object[4][2];
		datos[0][0] = "micorreo0.28325844194589145@correo.com";
		datos[0][1] = "1q2w3e4r5t";
		
		datos[1][0] = "correo1@correo.com";
		datos[1][1] = "3re34t4wt";
		
		datos[2][0] = "correo2@correo.com";
		datos[2][1] = "u76ru5ur";
		
		datos[3][0] = "correo3@correo.com";
		datos[3][1] = "65ryhr5";
		
		return datos;
	}
}
