package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsCriticalPathTest extends BaseTest {
    String userName = "standard_user";
    String password = "secret_sauce";

    @Test
    public void productShouldBeAddedIntoCart(){
        loginPage.open();
        loginPage.login(userName, password);
        inventoryPage.addToCart("Sauce Labs Onesie");
        String productPrice =  inventoryPage.getPriceByName("Sauce Labs Onesie");
        //cartPage.open();
        //cartPage.getProductName();
        //cartPage.getProductPrice();

        //assertEquals("Sauce Labs Onesie", cartPage.getProductName());
        //assertEquals(productPrice, cartPage.getProductPrice());
    }
}
