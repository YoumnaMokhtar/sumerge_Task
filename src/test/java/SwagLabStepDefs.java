import SumergePages.SwagLabPage;
import SumergeTest.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SwagLabStepDefs  extends TestBase {
    public WebDriver driver;
    public SwagLabPage sawgPage;


    @Before
    public void setUp() {
        driver = TestBase.getWebDriver();
        sawgPage = new SwagLabPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @And("I clicked Login")
    public void iClickedLogin() {
        sawgPage.clickOnLoginButton();
    }

    @Then("I will be logged successfully")
    public void iWillBeLoggedSuccessfully() {
        Assert.assertTrue(sawgPage.getProductsPage().isDisplayed());
    }


    @When("I enter {string}")
    public void iEnterValid(String username) {
        sawgPage.enterUserName(username);

    }

    @And("I entered {string}")
    public void iEnteredValid(String password) {
        sawgPage.enterPasswrod(password);
    }

    @Given("I opened the website")
    public void iOpenedTheWebsite() {
        driver.navigate().to("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
    }

    @Then("it will appear an error message for invalid credntials")
    public void itWillAppearAnErrorMessageForInvalidCredntials() {
        WebElement errorMessage = sawgPage.getInvalidCredntialsMessage();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorMessage.getText(), expectedMessage);

    }



    @Then("it will appear an error message that username is required")
    public void itWillAppearAnErrorMessageThatUsernameIsRequired() {
        WebElement errorMessage = sawgPage.getUserNameIsRequiredText();
        String expectedMessage = "Epic sadface: Username is required";
        Assert.assertEquals(errorMessage.getText(), expectedMessage);

    }

    @Then("it will appear an error message that password is required")
    public void itWillAppearAnErrorMessageThatPasswordIsRequired() {
        WebElement errorMessage = sawgPage.getPasswordIsRequiredText();
        String expectedMessage = "Epic sadface: Password is required";
        Assert.assertEquals(errorMessage.getText(), expectedMessage);

    }
}