package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class GoogleSearchTest { //video 2: localizadores y 3 tipos de espera
	
	private WebDriver driver; //creamos objeto driver de tipo webdriver
	By videoLinkLocator = By.cssSelector("a[href='https://www.youtube.com/watch?v=R_hh3jAqn8M']");
	
	@Before 
	public void setUp() { //método setup
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); //directorio donde esta el chromedriver
		driver = new ChromeDriver(); //declaro el objeto driver
		driver.manage().window().maximize(); //maximizar la ventana de chrome
		driver.get("https://www.google.com/");//este método le da la url q queremos abrir al navegador
	}
	
	@Test
	public void testGooglePage() {
		
	
		WebElement searchbox = driver.findElement(By.name("q")); //creamos un webelemt "findelemnt" es el cmd de selenium para encontrar un elemento en la página "by.name" es el localizador				
		searchbox.clear();//para limpiar cualquier texto en la búsqueda
		
		searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software"); //el texto q le mandamos al buscador de guugo
		
		searchbox.submit();
		
		
		 
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		/*
		//explicit wait
		WebDriverWait ewait = new WebDriverWait(driver, 10); //creamos el objeto webdriver y le ponemos ewait, tiempo de espera es en segundos.
		ewait.until(ExpectedConditions.titleContains("quality-stream"));//condición por la cual esperamos, hay muchos para usar. En este caso una string que está en lo que vamos a buscar
		
		
		//fluent wait
		
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)//creamos ub element fluent wait "fwait"
				.withTimeout(10,TimeUnit.SECONDS)//le damos tiempo de consulta máxima ameo
				.pollingEvery(2,TimeUnit.SECONDS)//que realice consultas a la página cada 2 segundos 
				.ignoring(NoSuchElementException.class);//y que ignore la opción NoSuchElementException si la tira el programa
		
		WebElement video = fwait.until(new Function<WebDriver,WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(videoLinkLocator);
			}
		}
		);
		assertTrue(driver.findElement(videoLinkLocator).isDisplayed());*/
		
	    assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google", driver.getTitle());
	  
	}
	
     @After
     public void tearDown() { //método de cierre
    	 
    	//driver.quit(); //para cerrar el navegador una vez haga la prueba
     }
}
