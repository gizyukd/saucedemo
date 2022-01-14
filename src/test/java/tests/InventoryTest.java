package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import utils.AllureUtils;

import static org.testng.Assert.*;

public class InventoryTest extends BaseTest {
    String userName = "standard_user";
    String password = "secret_sauce";
    String nameProduct = "Sauce Labs Onesie";

    @Test(description = "Adding product into cart")
    public void cartShouldBeMarkedAfterAddingProduct(){
        loginPage.open();
        loginPage.login(userName, password);
        inventoryPage.addToCart(nameProduct);
        assertTrue(inventoryPage.getMarkedStatusOfCart(), "Продукт не добавлен в корзину");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Check if a product counter changes a number after adding product into cart")
    public void cartBadgeShouldBeCountable(){
        loginPage.open();
        loginPage.login(userName, password);
        inventoryPage.addToCart(nameProduct);
        String counterOfCartBadge =  inventoryPage.getCounterOfCartBadge();
        inventoryPage.addToCart("Sauce Labs Backpack");
        assertNotEquals(inventoryPage.getCounterOfCartBadge(), counterOfCartBadge, "Счетчик продуктов в корзине работает неверно");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Check if the name of a product button changes after click on it")
    public void productButtonShouldChangeNameAfterAddingToCart(){
        loginPage.open();
        loginPage.login(userName, password);
        String buttonName = inventoryPage.getProductButtonStatusNameByProductName(nameProduct);
        inventoryPage.addToCart(nameProduct);
        assertNotEquals(inventoryPage.getProductButtonStatusNameByProductName(nameProduct), buttonName, "Название кнопки продукта не изменилось после нажатия на нее");
        AllureUtils.takeScreenshot(driver);
    }
}
