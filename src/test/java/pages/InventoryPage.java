package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class InventoryPage extends BasePage{
    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button";
    public static final String PRODUCT_PRICE = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//div[@class='inventory_item_price']";
    public static final By TITLE_TEXT = By.xpath("//span[@class='title']");
    public static final By CART_BADGE = By.xpath("//span[@class='shopping_cart_badge']");

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    @Step("Add a product to cart")
    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    @Step("Get the title of Inventory page")
    public String getTitle(){
        return driver.findElement(TITLE_TEXT).getText();
    }

    @Step("Get price of chosen product")
    public String getPriceByName(String nameProduct){
       return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, nameProduct))).getText().split("\\r?\\n")[0];
    }

    @Step("Check cart isn't empty")
    public boolean getMarkedStatusOfCart(){
        return driver.findElement(CART_BADGE).isDisplayed();
    }

    @Step("Get number of items on cart")
    public String getCounterOfCartBadge(){
        return driver.findElement(CART_BADGE).getText();
    }

    @Step("Open inventory page")
    public void open(){
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @Step("Get status name of product button")
    public String getProductButtonStatusNameByProductName(String nameProduct) {
       return driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).getText();
    }
}
