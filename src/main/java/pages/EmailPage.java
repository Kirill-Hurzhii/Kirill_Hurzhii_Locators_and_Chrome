package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailPage extends BasePage{

    public String toEmail = "7vgurjiykirillgrey@gmail.com";
    public String text = "Hello, EPAM!!!";

    //XPath
    @FindBy(xpath = "//button[@class='button primary compose']")
    public WebElement typeLetterButton;

    //CSS
    @FindBy(css = "[name = toFieldInput]")
    public WebElement to;

     //ID
     @FindBy(id = "mce_0_ifr")
     public WebElement iframe;

     //Class
    @FindBy(className = "mce-content-body")
    public WebElement writeLine;

    //CSS
    @FindBy(css = ".send")
    public WebElement send;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(typeLetterButton));
        typeLetterButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(to));
        to.click();
        to.sendKeys(toEmail);
        driver.switchTo().frame(iframe);
        writeLine.click();
        writeLine.sendKeys(text);
        driver.switchTo().defaultContent();
        send.click();
    }
}
