package step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseSteps {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    EmailPage emailPage;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("User entry in Gmail account")
    public void login() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.openHomePage();
        loginPage.loginEmail();
    }

    @When("User send letter")
    public void send() {
        emailPage = new EmailPage(driver);
        emailPage.sendEmail();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}