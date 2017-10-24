package Keywords;

import PageFunctions.PageFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Keywords {
    private PageFunctions myPage;
    private WebDriver driver;

    public Keywords(WebDriver driver) throws IOException {
        myPage = new PageFunctions(driver);
        this.driver = driver;
    }

    public void login(String email, String password){
        myPage.buttonClickXPath("Close Newsletter");
        myPage.buttonClickXPath("LoginRegister");
        myPage.textBoxType("Buttons", email);
        myPage.textBoxType("Buttons", password);
        myPage.buttonClickXPath("Login");
    }
}
