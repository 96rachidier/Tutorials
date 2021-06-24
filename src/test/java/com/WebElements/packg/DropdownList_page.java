package com.WebElements.packg; 
 
                              //Video 6: Cómo Automatizar Listas Desplegables con Selenium WebDriver
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.project.pom.Base;

public class DropdownList_page extends Base{ //heredamos la clase Base
	
	// 1)vamos a automatizar dropdownlist, (menú desplegable), clásico en la -mercury tours page-
	
	//By dropdownList_Passengers = By.name("passCount"); //el select name de la lista, localizador.
	By dropdownList_DepartingFrom = By.name("fromPort");
    //By registeredMessage = By.tagName("font");
	By dropdownListBtn = By.id("dropdown-basic");
	By option2 = By.cssSelector("div[aria-labelledby='dropdown-basic']>a[href='#/action-2']"); //creamos el cssselector xq el selector no tiene id ni name, entonces
	//sacamos info del inspector div, el nombre del botón aria-labelledby y después el href correspondiente
	
	// 2) dropdownlist con bootstrap y react
	

	public DropdownList_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 
	
	// a) Opción o método más largo de hacer un test de droplist: ESTE METODO NO LO PUDE HACER ANDAR
	/*
	public String selectDropdownList_Passengers() { //método string porque devuelve el texto de la cantidad de passengers
		WebElement dropdownList = findElement(dropdownList_Passengers); //passengers porque aca probamos con el nro de pasajeros
		List<WebElement> options = dropdownList.findElements(By.tagName("option"));  //le decimos que busque las opciones que contiene el droplist q se llaman "option value" en el navegador
		for (int i = 0; i < options.size(); i++) {
			if(getText(options.get(i)).equals("4 ")) { //siempre incluir un espacio al final del numero porque asi esá en la inspeccion de la page
			   click(options.get(i));		
		}				
	}
	String selectedOption = "";
	for(int i = 0; i < options.size(); i++){
		if(options.get(i).isSelected()) 
		selectedOption = getText(options.get(i));
		
	}
	
	return selectedOption;
	
	}*/		
	
	// b) Opción o método más sencillo para hacer test droplist
	
	public String selectDropdownList_DepartingFrom(){ //departing porque aca probamos con el punto de partida
		
		Select selectList = new Select(findElement(dropdownList_DepartingFrom)); //creamos el objeto de tipo select list
		selectList.selectByVisibleText("London"); //seleccionamos el que quiera probar
		return getText(selectList.getFirstSelectedOption());
	}
	
	public void selectReactDropdownList() throws InterruptedException { //de tipo void porque el click en la opción no nos lleva a una url
		click(dropdownListBtn);
		Thread.sleep(3000);
		click(option2);
	}

}
