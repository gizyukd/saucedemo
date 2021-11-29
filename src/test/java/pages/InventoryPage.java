package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class InventoryPage extends BasePage{
    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button";
    public static final String PRODUCT_PRICE = "//div[div[div[a[div[@class='inventory_item_name'][text()='Sauce Labs Bolt T-Shirt']]]]]//div[@class='inventory_item_price']";
    public static final By TITLE_TEXT = By.xpath("//span[@class='title']");
    public static final By CART_BADGE = By.xpath("//span[@class='shopping_cart_badge']");

    public InventoryPage(WebDriver driver){
        super(driver);
    }

    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    public String getTitle(){
        return driver.findElement(TITLE_TEXT).getText();
    }

    public String getPriceByName(String nameProduct){
       return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, nameProduct))).getText().split("\\r?\\n")[1];
    }

    public boolean getMarkedStatusOfCart(){
        return driver.findElement(CART_BADGE).isDisplayed();
    }

    public String getCounterOfCartBadge(){
        return driver.findElement(CART_BADGE).getText();
    }

    public void open(){
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    public String getProductButtonStatusNameByProductName(String nameProduct) {
       return driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).getText();
    }
}
