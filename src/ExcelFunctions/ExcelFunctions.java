package ExcelFunctions;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ExcelFunctions {
	private XSSFWorkbook  wb;
	private XSSFSheet sheet;
	private ArrayList<String> myList = new ArrayList<>();

	public ExcelFunctions(String excelFilePath) throws IOException{
        InputStream ExcelFileToRead = new FileInputStream(excelFilePath);
        wb = new XSSFWorkbook(ExcelFileToRead);

	}

	// Returns the parameters from a row in an excel sheet
	public ArrayList<String> buildExcelList(String sheetName, String valueName){
	    // Open the sheet and count the number of rows
        sheet = wb.getSheet(sheetName);
		int MaxRow = sheet.getLastRowNum() + 1;
		myList.clear();

		// Find the row to be used
		for (int i = 0; i < MaxRow; i++) {
			String cellValue = (sheet.getRow(i).getCell(0)).toString();
			int MaxColumn = sheet.getRow(i).getLastCellNum();
			if (cellValue.equals(valueName)) {

			    // Build the list of parameters in the row
			    for (int j = 1; j < MaxColumn; j++) {
                    String myValue = (sheet.getRow(i).getCell(j)).toString();
                    myList.add(myValue);
                }
				break;
			}
		}
		return myList;
    }
}
