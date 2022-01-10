package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class LocatorsTest extends BaseTest {

    @Test(description = "find elements on the site")
    public void FindElementsByLocators(){

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("react-burger-menu-btn"));
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.className("shopping_cart_container"));
        driver.findElement(By.tagName("footer"));
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Face"));
        driver.findElement(By.xpath("//div[@class='app_logo']"));
        driver.findElement(By.xpath("//span[text()='Name (A to Z)']"));
        driver.findElement(By.xpath("//div[contains(@class, 'burger')]"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/../../..//button[contains(text(), 'Add')]"));
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']/ancestor::a"));
        driver.findElement(By.xpath("//footer/descendant::img"));
        driver.findElement(By.xpath("//a[@id='item_4_title_link']/following::button[@name='add-to-cart-sauce-labs-backpack']"));
        driver.findElement(By.xpath("//option/parent::select"));
        driver.findElement(By.xpath("//option[@value='za']/preceding::option"));
        driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack' and @src='/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']"));
        driver.findElement(By.cssSelector(".shopping_cart_link"));
        driver.findElement(By.cssSelector(".select_container .active_option"));
        driver.findElement(By.cssSelector("#shopping_cart_container"));
        driver.findElement(By.cssSelector("footer"));
        driver.findElement(By.cssSelector("select.product_sort_container"));
        driver.findElement(By.cssSelector("img[alt='Sauce Labs Onesie']"));
        driver.findElement(By.cssSelector("img[alt~='Light']"));
        driver.findElement(By.cssSelector("div[id ^= 'shop']"));
        driver.findElement(By.cssSelector("img[alt $= 'er']"));
        driver.findElement(By.cssSelector("img[alt *= 'lt']"));
    }
}
