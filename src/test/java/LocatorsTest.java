import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest{

    @Test
    public void FindByLocators(){

        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.id("react-burger-menu-btn"));
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.className("shopping_cart_container"));
        

    }

}
