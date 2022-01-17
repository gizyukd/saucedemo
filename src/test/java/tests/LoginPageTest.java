package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;
import utils.AllureUtils;

import java.util.Locale;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {
    String userName = "standard_user";
    String password = "secret_sauce";
    Set<Cookie> cookies;

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"fjfs", "fwdoprkc", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Link("www.google.by")
    @Issue("number of task in url")
    @TmsLink("")
    @Test(retryAnalyzer = Retry.class, description = "Authorization with valid data")
    public void validAuthorization(){
        loginPage.open();
        loginPage.login(userName, password);
        assertEquals(inventoryPage.getTitle().toLowerCase(), "products");

        cookies = driver.manage().getCookies();
        inventoryPage.open();

        driver.manage().deleteAllCookies();
        inventoryPage.open();

        for (Cookie ck : cookies){
            driver.manage().addCookie(ck);
        }
        inventoryPage.open();
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Вход с невалидными данными", dataProvider = "loginData", groups = "smoke")
    public void negativeLoginTest(String userName, String password, String errorMessage){
        loginPage.open();
        loginPage.login(userName, password);
        assertEquals(loginPage.getErrorMessage(), errorMessage);
        AllureUtils.takeScreenshot(driver);
    }
}
