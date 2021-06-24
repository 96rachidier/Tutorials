package com.WebElements.packg;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DropdownList_Text { //junit test
	
	private WebDriver driver;
	DropdownList_page ddLPage; 

	@Before
	public void setUp() throws Exception {
		ddLPage = new DropdownList_page(driver);
		driver = ddLPage.chromeDriverConnection();
		driver.manage().window().maximize();//para maximizar la ventana al testear
	}

	@After
	public void tearDown() throws Exception {
	}
	/*

	@Test //	COMENTADO SOLO PARA PROBAR EL OTRO TEST
	public void testing_classic_DDL() throws InterruptedException {
		ddLPage.visit("http://demo.guru99.com/test/newtours/reservation.php");
		//ddLPage.signIn(); este es para autenticarse antes de ir al reservorio, pero mi page es diferente asi que no lo necesito
		Thread.sleep(2000);
		//assertEquals(ddLPage.selectDropdownList_Passengers(), "4 ");
		assertEquals(ddLPage.selectDropdownList_DepartingFrom(), "London");
	}*/
	
	@Test
	public void testing_React_DDL() throws InterruptedException {
		ddLPage.visit("https://react-bootstrap.github.io/components/dropdowns/");
		ddLPage.selectReactDropdownList();
		
	}
	

}
