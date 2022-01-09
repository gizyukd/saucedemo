package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public static final By USERNAME_INPUT = By.cssSelector("[placeholder='Username']");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Step("Open site Saucedemo")
    public void open(){
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Login as user '{userName}' use password '{password}'")
    public void login(String userName, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Get error message")
    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
