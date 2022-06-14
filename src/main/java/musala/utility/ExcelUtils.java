package musala.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet excelWSheet;

	private static XSSFWorkbook excelWBook;

	private static XSSFCell cell;

	private static XSSFRow row;

	// This method is to set the File path and to open the Excel file
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream excelFile = new FileInputStream(Path);

			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	@SuppressWarnings("deprecation")
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			String cellData = "";

			if (cell.getCellType() == CellType.STRING.getCode())
				cellData = cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC.getCode())
				cellData = String.valueOf(cell.getNumericCellValue());

			return cellData;
		} catch (Exception e) {
			return "";
		}
	}

	// This method is to write in the Excel cell
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			row = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(Result);
			} else {
				cell.setCellValue(Result);
			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

			excelWBook.write(fileOut);

			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
}
