package Q_Vision.SeleniumCapacitacion;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

public class RegisterTest {
	
	static WebDriver driver;

	
	@Before
	public void cargaInicial() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://sahitest.com/demo/training/login.htm");
	}
	

	@Test
	public void test() throws InterruptedException {
		
		
		String mensaje;
		
//		System.out.println("Prueba");
		
		WebElement buttonRegister = driver.findElement(By.xpath("//*[contains(text(),'Register')]")); //Boton registrar
		buttonRegister.click();	

		Thread.sleep(500);
		
		WebElement registrarNombre = driver.findElement(By.name("username"));
		WebElement registrarPassword = driver.findElement(By.name("password"));		
		WebElement registrarPassword2 = driver.findElement(By.name("password2")); //Campo confirmar contraseña
		WebElement genderMale = driver.findElement(By.xpath("//input[@name='gender'][@value='M']")); //campo seleccionar genero Male
		WebElement genderFemale = driver.findElement(By.xpath("//input[@name='gender'][@value='F']")); //campo seleccionar genero Female
		WebElement registrarAddress = driver.findElement(By.name("address")); //Campo direccion
		WebElement registrarAddressBull = driver.findElement(By.name("billaddress")); //Campo billing addrre
		WebElement seTerminos = driver.findElement(By.name("agree"));
		WebElement btnRegister = driver.findElement(By.xpath("//*[@value='Register']"));
		WebElement state = driver.findElement(By.xpath("//select[@name='state']"));
		
		
		registrarNombre.sendKeys("Juan Esteban");
		registrarPassword.sendKeys("Varios2017");
		registrarPassword2.sendKeys("Varios2017");
		genderFemale.click();	
		registrarAddress.sendKeys("Calle 11 46 39");		
		
		Select selectState = new Select(state);
		selectState.selectByVisibleText("Kerala");
		
		registrarAddressBull.sendKeys("Calle 45 B");
		seTerminos.click();
		btnRegister.click();
				

		
		driver.switchTo().alert();
		Alert alert = driver.switchTo().alert();
		mensaje = alert.getText();
		Assert.assertEquals("Registered Successfully", mensaje);
		
		Thread.sleep(500);
		
		driver.switchTo().alert().accept();
		
	}
	
	@After
	
	public void cerrar() {
	driver.close();
	}

}
