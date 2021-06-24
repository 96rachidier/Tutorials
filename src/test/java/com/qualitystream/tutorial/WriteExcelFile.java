package com.qualitystream.tutorial;

import java.io.File;         //video 5: lectura y escritura de Excel con Apache POI
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile { //clase para escribir los datos en el fichero
	
	public WriteExcelFile() {
		
	}
	
	public void writeExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException { //método 1 para escribir una lista de datos al excel
		
		File file = new File(filepath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		int rowCount = newSheet.getLastRowNum()-newSheet.getFirstRowNum();
		
		XSSFRow newRow = newSheet.createRow(rowCount+1);
		
		for(int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWrite[i]);
		}
		
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		
	    newWorkbook.write(outputStream);
	    
	    outputStream.close();
		
	}
	
	public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException { //método 2 para crear un valor en una celda específica
		
		File file = new File(filepath);
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		
		XSSFRow row = newSheet.getRow(rowNumber);
		
		XSSFCell firstCell = row.getCell(cellNumber -1);
		
		System.out.println("first cell value is:" + firstCell.getStringCellValue());
		
		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(resultText);
		
		System.out.println("nextCell value:" + nextCell.getStringCellValue());
		
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		 
		newWorkbook.write(outputStream);
		
		outputStream.close();
		
	}

}
