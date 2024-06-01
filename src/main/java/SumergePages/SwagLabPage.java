package SumergePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabPage extends LandingPage{
    public SwagLabPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="user-name")
    WebElement userName;
    @FindBy(id="password")
    WebElement Password;
    @FindBy(id="login-button")
    WebElement loginButton;
    @FindBy(xpath = "//span[@class='title' and text()='Products']")
    WebElement productsPage;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement invalidCredntialsMessage;
    @FindBy(xpath = "//h3[@data-test='error' and contains(text(),'Username is required')]")
    WebElement userNameIsRequiredText;
    @FindBy(xpath = "//h3[@data-test='error' and contains(text(),'Password is required')]")
    WebElement passwordIsRequiredText;


    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
    public WebElement getProductsPage(){return  productsPage;}
    public  WebElement getInvalidCredntialsMessage(){return invalidCredntialsMessage;}
    public WebElement getUserNameIsRequiredText(){return userNameIsRequiredText;}
    public WebElement getPasswordIsRequiredText(){return passwordIsRequiredText;}

    public void enterUserName(String username){
        getUserName().sendKeys(username);
    }
    public void enterPasswrod(String password){
        getPassword().sendKeys(password);
    }
    public void clickOnLoginButton(){
        getLoginButton().click();
    }



}
