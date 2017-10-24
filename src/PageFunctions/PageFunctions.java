package PageFunctions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ExcelFunctions.ExcelFunctions;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFunctions {
	private WebDriver driver;
	private WebDriverWait wait;
	private WebElement myButton;
    private WebElement myTextBox;
	private ExcelFunctions myExcel;
	private ArrayList<String> parameterList;
	
	public PageFunctions(WebDriver driver) throws IOException {
		this.driver = driver;
		wait  = new WebDriverWait(this.driver, 10);
		myExcel = new ExcelFunctions("/Users/chris.gill/Desktop/Test1.xlsx");
		parameterList = new ArrayList<String>();
		
	}

	private String returnObjectString(String sheetName, String valueName, int arrayPosition){
	    // Fetch the array of items from the spreadsheet row
        parameterList = myExcel.buildExcelList(sheetName, valueName);

        // Return the required array string object
        return parameterList.get(arrayPosition);
    }

	public void buttonClickXPath(String buttonID) {
		try {
		// Read in the button ID from the spreadsheet
        buttonID = returnObjectString("Buttons", buttonID, 0);

		// wait for the button to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonID)));

		// Click on the button
		myButton = this.driver.findElement(By.xpath(buttonID));
		myButton.click();
		}
		catch (Exception e) {
			Assert.fail("Could not click on the button. Check that the button is displayed.");
		}
	}
	
	public void textBoxType(String sheetName, String textBoxID) {
		try {
        // Read in the text box ID and text value from the spreadsheet
        parameterList = myExcel.buildExcelList(sheetName, textBoxID);
        textBoxID = parameterList.get(0);
        String textValue = parameterList.get(1);

        // wait for the button to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textBoxID)));
		
		// Write in the text box
		myTextBox = this.driver.findElement(By.xpath(textBoxID));
		myTextBox.clear();
		myTextBox.sendKeys(textValue);
		}
		catch (Exception e) {
			Assert.fail("Could not type in the text box. Check that the text box is displayed.");
		}
	}
}
