package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest{
    String userName = "standard_user";
    String password = "secret_sauce";

    @Test
    public void validAuthorization(){
        loginPage.open();
        loginPage.login(userName, password);
        assertEquals(inventoryPage.getTitle(), "PRODUCTS");
    }

    @Test
    public void userNameShouldBeRequired(){
        loginPage.open();
        loginPage.login("", password);
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }

    @Test
    public void passwordShouldBeRequired(){
        loginPage.open();
        loginPage.login(userName, "");
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
    }

    @Test
    public void userDataShouldBeCorrect(){
        loginPage.open();
        loginPage.login("hgfgfg", "fgvrgrtve");
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockedUser(){
        loginPage.open();
        loginPage.login("locked_out_user", password);
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
    }


}
