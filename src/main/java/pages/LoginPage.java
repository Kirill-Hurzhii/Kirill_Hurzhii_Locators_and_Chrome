package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class LoginPage extends BasePage {

private String emailLogin = "kirillhurzhii";
private String emailPassword = "Locators$and$Chrome";

//XPath
    @FindBy(xpath = "//input[@type='text']")
    public WebElement login;
//CSS
    @FindBy(css = "[type=password]")
    public WebElement password;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(login));
        login.sendKeys(emailLogin);
        password.sendKeys(emailPassword, Keys.ENTER);
    }
}
