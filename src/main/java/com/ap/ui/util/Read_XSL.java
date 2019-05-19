package com.ap.ui.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_XSL {

	
	public String fileName;
	public FileInputStream ipstr = null;
	public FileOutputStream opstr = null;
    private XSSFWorkbook wb = null;
    private XSSFSheet ws = null;
    List<String>list = new ArrayList<String>();
    
    public Read_XSL(String fileName, String relativePath) {
    	this.fileName = fileName;
    	
    	try {
			ipstr = new FileInputStream(relativePath+fileName);
			wb = new XSSFWorkbook(ipstr);
			ws = wb.getSheetAt(0);
			ipstr.close();
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    //retrieveNoOfRows//
    public int retrieveNoOfRows(String wsName) {
    	int sheetIndex = wb.getSheetIndex(wsName);
    	if(sheetIndex==-1) //if sheet does not contain any data return 0//
    		return 0;
    	else {
    		ws = wb.getSheetAt(sheetIndex);
    		int rowCount = ws.getLastRowNum() + 1; //getting the total # of rows// staring from 1st index +1//
    		return rowCount;
    		
    	}

}
    

    
    public int retrieveNoOfCol(String wsName) {
    	int sheetIndex = wb.getSheetIndex(wsName);
    	if(sheetIndex==-1) //if sheet does not contain any data return 0//
    		return 0;
    	else {
    		ws = wb.getSheetAt(sheetIndex);
    		int colCount = ws.getRow(0).getLastCellNum() + 1; //get row points to the row at 0th index and .getLastCellNum get all the cell values from that row//
    		return colCount;
    		
	
    	}
    
  }
    
    public String retrieveTestData(String wsName, String ColName, String rowName)
	{
		
    	int sheetIndex = wb.getSheetIndex(wsName);
    	if(sheetIndex==-1)
    		return null;
    	else {
    		int rowNum = retrieveNoOfRows(wsName);
    		int ColNum = retrieveNoOfCol(wsName);
    		int colnumber = -1;
    		int rowNumber = -1;
    		
    		XSSFRow Suiterow = ws.getRow(0);
    		
    		for(int i=0; i <ColNum; i++) {
    			if(Suiterow.getCell(i).getStringCellValue().equals(ColName.trim())){
    			colnumber = i;
    			}
    		}
    		if(colnumber==-1) {
    			return "";
    		
    		}
    		
    			for(int j=0; j<rowNum; j++) {
    				XSSFRow Suitecol = ws.getRow(j);
    				if(Suiterow.getCell(0).getStringCellValue().equals(rowName.trim())){
    	    			rowNumber =  j;
    	    		}
    	}
    			if (rowNumber==-1) {
    				return "";
    			}
    			XSSFRow row = ws.getRow(rowNumber);
    			XSSFCell cell = row.getCell(colnumber);
    			if(cell ==null) {
    				return "";
    			}
    			String value = cellToString(cell);
    			return value;
    	}
}  	

    
    	@SuppressWarnings("deprecation")
    	public List<String>retrieveTestData(String wsName){
    		int sheetIndex = wb.getSheetIndex(wsName);
    		if (sheetIndex == -1)
    			return null;
    		else {
    			
    			int rowNum = retrieveNoOfRows(wsName);
    			int ColNum = retrieveNoOfCol(wsName);
    			
    			for(int i=0; i<rowNum -1; i++) {
    				XSSFRow  row = ws.getRow(i);
    				for(int j = 0; j<ColNum; j++) {
    					if(row ==null){
    						list = null;
    					}else {
    						XSSFCell cell = row.getCell(j);
    						if(cell==null) {
    							list=null;
    						}else {
    						cell.setCellType(Cell.CELL_TYPE_STRING);
    						String value = cellToString(cell);
    						System.out.println(value);
    						list.add(value);
    					}
    					
    				}
    			}
    		
    }			return list;
    
    
  }
    		
  }

	@SuppressWarnings("deprecation")
	public Object[][]retrieveTestData1(String wsName){
		int sheetIndex = wb.getSheetIndex(wsName);
		if (sheetIndex == -1)
			return null;
		else {
			
			int rowNum = retrieveNoOfRows(wsName);
			int ColNum = retrieveNoOfCol(wsName);
			
			Object data[][] = new Object[rowNum -1][ColNum];
			
			for(int i=0; i<rowNum -1; i++) {
				XSSFRow  row = ws.getRow(i + 1);
				for(int j = 0; j<ColNum; j++) {
					if(row ==null){
						data[i][j] = "";
					}else {
						XSSFCell cell = row.getCell(j);
						if(cell==null) {
							data[i][j] = "";
						}else {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String value = cellToString(cell);
						System.out.println(value);
						data[i][j] = value;
					}
					
				}
			}
		
		}   return data;

}
		
}
	
@SuppressWarnings("deprecation")
public static String cellToString(XSSFCell cell) {
	int type;
	Object result;
	type = cell.getCellType();
	switch (type) {
	
	case 0:
	 result = cell.getNumericCellValue();
	 break;
	 
	case 1:
	result = cell.getStringCellValue();
	break;
	
	default:
		throw new RuntimeException("UNsupported Cell.");
	}
	return result.toString();
	
	
	}
}
		


