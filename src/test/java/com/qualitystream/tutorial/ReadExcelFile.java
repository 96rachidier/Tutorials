package com.qualitystream.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {//video 5: lectura y escritura de Excel con Apache POI
	
	public ReadExcelFile(){
		
	}
	
	public void readExcel(String filepath, String sheetName) throws IOException { //primer metodo, nos va a permitir leer una hoja de excel fila por fila y cada celda de la fila
		
		File file = new File(filepath);//creamo objeto tipo file
		
		FileInputStream inputStream = new FileInputStream(file); //filepath = destino del archivo
		
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream); //creamos el objeto donde vamos a guardar el libro de excel

		XSSFSheet newSheet = newWorkBook.getSheet(sheetName); //creamo el objeto donde se guarda la hoja con la que estamos trabajando
        
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum(); //en esta variable guardamos cuántas filas de datos tiene el archivo 
        
        for(int i = 0; i <= rowCount; i++) {
        	XSSFRow row = newSheet.getRow(i);
        	
        	for (int j = 0; j < row.getLastCellNum(); j++) {
        		System.out.println(row.getCell(j).getStringCellValue() + "||");
        	
        	}
        }
	}
	public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException { //metodo 2 que nos va a permitir leer una celda especìfica
		
		File file = new File(filepath); //reutilizamos el código del método anterior
		
		FileInputStream inputStream = new FileInputStream(file); //para leer los datos del file creado 
		
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream); //libro de excel
		
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName); // la hoja	
		
		XSSFRow row = newSheet.getRow(rowNumber); //fila
		
		XSSFCell cell = row.getCell(cellNumber); //número de celda
				
		return cell.getStringCellValue();
	}

}
