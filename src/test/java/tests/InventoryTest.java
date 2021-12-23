package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class InventoryTest extends BaseTest {
    String userName = "standard_user";
    String password = "secret_sauce";
    String nameProduct = "Sauce Labs Onesie";

    @Test
    public void cartShouldBeMarkedAfterAddingProduct(){
        loginPage.open();
        loginPage.login(userName, password);
        inventoryPage.addToCart(nameProduct);
        assertTrue(inventoryPage.getMarkedStatusOfCart(), "Продукт не добавлен в корзину");
    }

    @Test
    public void cartBadgeShouldBeCountable(){
        loginPage.open();
        loginPage.login(userName, password);
        inventoryPage.addToCart(nameProduct);
        String counterOfCartBadge =  inventoryPage.getCounterOfCartBadge();
        inventoryPage.addToCart("Sauce Labs Backpack");
        assertNotEquals(inventoryPage.getCounterOfCartBadge(), counterOfCartBadge, "Счетчик продуктов в корзине работает неверно");
    }

    @Test
    public void productButtonShouldChangeNameAfterAddingToCart(){
        loginPage.open();
        loginPage.login(userName, password);
        String buttonName = inventoryPage.getProductButtonStatusNameByProductName(nameProduct);
        inventoryPage.addToCart(nameProduct);
        assertNotEquals(inventoryPage.getProductButtonStatusNameByProductName(nameProduct), buttonName, "Название кнопки продукта не изменилось после нажатия на нее");
    }
}
