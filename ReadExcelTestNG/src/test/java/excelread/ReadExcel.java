package excelread;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	
	 public Object[][] readnumericvalue(String ExcelPath) throws IOException {
		 
		    File src = new File(ExcelPath);
	        //File src = new File("/Users/Apple/Documents/TestData.xlsx");
	        FileInputStream fis = new FileInputStream(src);
	        XSSFWorkbook wb = new XSSFWorkbook(fis);
	        XSSFSheet sheet1 = wb.getSheetAt(0);

	        int rowcount = sheet1.getPhysicalNumberOfRows();
	        int columnCount = sheet1.getRow(0).getLastCellNum();
	        Object objects[][] = new Object[rowcount-1][columnCount];
	        int rowCounter = 0;

	        Iterator<Row> rowIterator = sheet1.iterator();
	        boolean firstRow = true;
	        while (rowIterator.hasNext()) {
	            Row currentRow = rowIterator.next();
	            if (firstRow) {
	                firstRow = false;
	                continue;
	            }
	            Iterator<Cell> cellIterator = currentRow.iterator();
	            int colCounter = 0;
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                        objects[rowCounter][colCounter] = cell.getStringCellValue();
	                        break;

	                    case Cell.CELL_TYPE_NUMERIC:
	                        objects[rowCounter][colCounter] =  new Double(cell.getNumericCellValue()).intValue();
	                        break;
	                }
	                colCounter++;
	            }
	            rowCounter++;
	        }
	        return objects;
	    }
	
	

}
