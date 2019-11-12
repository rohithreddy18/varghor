package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
	
	Workbook wb;
	
	//to read excel file path
	public ExcelFileUtil() throws Throwable{
		FileInputStream fis=new FileInputStream("D:\\Ojt4oclock\\ERP_Maven\\TestInput\\InputSheet.xlsx");
		wb=WorkbookFactory.create(fis);
	}
	
	//count no of rows in sheet
	public int rowCount(String Sheetname){
		return wb.getSheet(Sheetname).getLastRowNum();
	}
	
	//count no of columns in row
	public int colCount(String sheetname){
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();
	}
	
	//reading data from cell
	public String getCellData(String sheetname,int row, int column){
		String data="";
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC){
			int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data=String.valueOf(celldata);
			}
		else{
			data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		}
		return data;
	}
	
	public void setCellData(String sheetname, int row, int column, String status)throws Throwable{
		
		//get sheet
		Sheet ws=wb.getSheet(sheetname);
		Row r=ws.getRow(row);
		Cell c=r.createCell(column);
		//write into status
		c.setCellValue(status);
		if(status.equalsIgnoreCase("Pass")){
			
			//create a cell style
			CellStyle style=wb.createCellStyle();
			//create a font
			Font font=wb.createFont();
			//apply color to the text
			font.setColor(IndexedColors.GREEN.getIndex());
			//apply bold 
			font.setBold(true);
			//set font
			style.setFont(font);
			//set cell style
			r.getCell(column).setCellStyle(style);
		}
		else if((status.equalsIgnoreCase("Fail"))){
			
			//create a cell style
			CellStyle style=wb.createCellStyle();
			//create a font
			Font font=wb.createFont();
			//apply color to the text
			font.setColor(IndexedColors.RED.getIndex());
			//apply bold 
			font.setBold(true);
			//set font
			style.setFont(font);
			//set cell style
			r.getCell(column).setCellStyle(style);
		}
		
		else if((status.equalsIgnoreCase("Not Executed"))){
			
			//create a cell style
			CellStyle style=wb.createCellStyle();
			//create a font
			Font font=wb.createFont();
			//apply color to the text
			font.setColor(IndexedColors.BLUE.getIndex());
			//apply bold 
			font.setBold(true);
			//set font
			style.setFont(font);
			//set cell style
			r.getCell(column).setCellStyle(style);
		}
		
		FileOutputStream fos=new FileOutputStream("D:\\Ojt4oclock\\ERP_Maven\\TestOutput\\MavenHybrid.xlsx");
		wb.write(fos);
		fos.close();
	}
}
