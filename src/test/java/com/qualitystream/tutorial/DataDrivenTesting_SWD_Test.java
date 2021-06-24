package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting_SWD_Test {  //video 5: lectura y escritura de Excel con Apache POI
	
	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search"); //loacalizadores
	private By resultTextLocator = By.cssSelector("span.heading-counter");
	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		
		driver.get("http://automationpractice.com/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws IOException {
		String filepath = "C:\\Users\\Isaías\\Desktop\\Test.xlsx"; //siempre quedan dos barras en eclipse para buscar
		
		String searchText = readFile.getCellValue(filepath, "Hoja1", 0, 0); //guardando el valor de la celda y fila (1, a sería) "Dresses"
		
		driver.findElement(searchBoxLocator).sendKeys(searchText); //mandamos el término de la celda anterior la caja de búsqueda
		driver.findElement(searchBtnLocator).click(); // y le damos click para que lo busque ameo
		
		String resultText = driver.findElement(resultTextLocator).getText(); //guardar el resultado y mostrarlo en este string
		
		System.out.println("Page result text: " + resultText); //mostrar el resultado en la console
		
		/* ahora vamos a hacer que en el archivo de excel aparezcan la cantidad de resultados a cada
		 * palabra en la celda del costado
		 */
		
		readFile.readExcel(filepath, "Hoja1");
		writeFile.writeCellValue(filepath, "Hoja1", 0, 1, resultText); //0 es la fila y 1 la celda a la derecha de "Dresses"
		readFile.readExcel(filepath, "Hoja1");
	}

}
