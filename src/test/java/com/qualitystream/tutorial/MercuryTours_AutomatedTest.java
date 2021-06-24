package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	
	
	private WebDriver driver; 
	//LOCALIZADORES para registrarse:
	By registerLinkLocator = By.linkText("REGISTER"); //el link text lo copiamos del botón de la página cuando le damos a inspeccionar elemento
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']"); //copiar como está en inspeccionar y chantarlo acá entre '' no más
    By usernameLocator = By.id("email"); //le di a inspeccionar al espacio en blanco y copié la id
    By passwordLocator = By.name("password"); //si en la caja al inspeccionar dice "name=" le metemos name, si dice "id =" le metemos id
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']"); //input[name='...'] se usa el cssSelector
	By registerBtnLocator = By.name("submit");
	
	//localizadores para loguearse
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By loginBtnLocator = By.name("submit");
    @Before
	public void setUp() { //método setup procedemos igual que la script anterior
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); //esta mierda la dejamos siempre
		driver = new ChromeDriver(); //se deja igual locoooo
		driver.manage().window().maximize(); //se deja igual
		driver.get("http://demo.guru99.com/test/newtours/index.php");//este método le da la url q queremos abrir al navegador
	}
	@After
	public void tearDown() throws Exception {
		//driver.quit();  //para sacar el navegador al final, podemos ponerle un // y queda todo abierto
	}

	@Test //caso de prueba 1: registro
	public void registerUser() throws InterruptedException{   //TEST, el interriptedexception es para el thread.sleep
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000); //espera entre que encuentra la imagen anterior y hace el registro, para que carge la page
	    if(driver.findElement(registerPageLocator).isDisplayed()) {
	    	driver.findElement(usernameLocator).sendKeys("isaias");
	    	driver.findElement(passwordLocator).sendKeys("naftalina");
	    	driver.findElement(confirmPasswordLocator).sendKeys("naftalina");
	    	
	    	driver.findElement(registerBtnLocator).click();
	    }
	    else {
	    	System.out.print("Register page was not found");
	    }
	    
	    List<WebElement> fonts = driver.findElements(By.tagName("font"));
	    assertEquals("Note: Your user name is isaias.",fonts.get(5).getText()); //accedemos al 5 (6to xq se cuenta desde 0) de la lista de //font que tiene en total la page
	    }
	@Test //caso de prueba 2: loguearse
	
	public void signIn() { //nuevo método test
		if(driver.findElement(userLocator).isDisplayed());
		   driver.findElement(userLocator).sendKeys("isaias");
		   driver.findElement(passLocator).sendKeys("naftalina");
		   driver.findElement(loginBtnLocator).click();
		
	}
}

