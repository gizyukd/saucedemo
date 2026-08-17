package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // 1. Отключаем менеджер паролей через Preferences (Настройки профиля)
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false); // Не предлагать сохранить пароль
            prefs.put("profile.password_manager_enabled", false); // Полностью выключить менеджер паролей
            prefs.put("safebrowsing.enabled", false); // Отключить безопасный просмотр (который и ищет утечки)
            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);

            // 2. Отключаем конкретную фичу проверки утечек через флаги командной строки
            options.addArguments("--disable-features=PasswordLeakDetection");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else{
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.manage().window().maximize();

        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @AfterMethod (alwaysRun = true, description = "Close browser")
    public void tearDown(){
        driver.quit();
    }
}
