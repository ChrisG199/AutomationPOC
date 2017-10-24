

import PageFunctions.PageFunctions;
import Keywords.Keywords;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ExcelFunctions.ExcelFunctions;

import java.util.ArrayList;

public class LoginTest {
	private WebDriver driver;
	private PageFunctions myPage;
	private Keywords myKeyword;
	private static String url = "https://regress.spreeza.net/";
	
	@Test
	public void test1() throws Exception {

        // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chromedriver", "/Users/chris.gill/Desktop/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        myKeyword = new Keywords(driver);
        myKeyword.login("Email", "Password");

//        driver.quit();
    }

}
