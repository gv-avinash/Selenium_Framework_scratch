package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static Workbook wb;
	private static Sheet sh;
	
	public static void LoadExcel(String filepath, String sheetname) throws IOException {
		
		FileInputStream fis = new FileInputStream(filepath);
		
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheetname);
		
	}
	
	public static String getCellData(int row, int col) {
		Cell cell = sh.getRow(row).getCell(col);
		if(cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		}
		
		else if(cell.getCellType()== CellType.NUMERIC) {
			return String.valueOf((int) cell.getNumericCellValue());
		}
		return "";
	}
	
	public static int getRowCount() {
		return sh.getPhysicalNumberOfRows();
	}
	
	public static void closeExcel() throws IOException {
		wb.close();
	}

}
