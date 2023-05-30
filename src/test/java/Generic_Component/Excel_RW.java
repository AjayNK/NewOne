package Generic_Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_RW {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet ws;
	
	public Excel_RW(String path) throws IOException {
		fis = new FileInputStream(path);	
		wb = new XSSFWorkbook(fis);
	}
	
	public int getRowCount(String sheetName) {
		ws = wb.getSheet(sheetName);		
		int rc = ws.getLastRowNum();
		return rc;
	}
	
	
	public int getColCount(String sheetName, int rowNo) {
		ws = wb.getSheet(sheetName);		
		int cc = ws.getRow(rowNo).getLastCellNum();
		return cc;
	}
	
	
	public String getCellValue(String sheetName, int rowNo, int ColNo) {
		ws = wb.getSheet(sheetName);	
		String celltext = null;			
		XSSFCell cell = ws.getRow(rowNo).getCell(ColNo);
		
		if(cell.getCellType()==cell.CELL_TYPE_STRING) {
			celltext = cell.getStringCellValue();
		}
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC) {
			celltext = String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==cell.CELL_TYPE_BLANK)	{
			celltext = "";
		}
		
		return celltext;		
	}
	
	public void writeCellValue(String sheetName, int rowNo, int ColNo,  String cellValue) {
		ws = wb.getSheet(sheetName);
		ws.getRow(rowNo).getCell(ColNo).setCellValue(cellValue);		
	}
	
	
	public void saveAndClose(String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fis.close();
		fos.close();
	}
	
	
	
}
