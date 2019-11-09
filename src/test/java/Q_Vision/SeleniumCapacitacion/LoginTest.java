package Q_Vision.SeleniumCapacitacion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	WebDriver driver = null;
	
	@Before
	public void cargaInicial() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QV-3578\\eclipse-workspace\\SeleniumCapacitacion\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://sahitest.com/demo/training/login.htm");
		
		RegisterTest a = new RegisterTest();
		a.cargaInicial();
		
	}
	

	@Test
	public void test() {
		//Escribir sobre el campo usuario
		WebElement txtUsuario = driver.findElement(By.name("user"));
		txtUsuario.sendKeys("test");
		//Escribir sobre el campo password
		WebElement txtpassword = driver.findElement(By.name("password"));
		txtpassword.sendKeys("secret2");
		//Boton
		WebElement btnLogin = driver.findElement(By.xpath("/html/body/center/div/form/table/tbody/tr[3]/td[2]/input"));
		btnLogin.click();
		
		//Validar titulo compras
		
		WebElement lblMensaje = driver.findElement(By.xpath("//*[@id=\"available\"]/h2"));
		Assert.assertTrue(lblMensaje.isDisplayed());
		
		
		
	}

	@After
	public void cerrar () {
		
		
		
		
	}
}
