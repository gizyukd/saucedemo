package tests.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

// работа его запускается через аннотацию(можно повесить на BaseTest читобы везде работало), где параметр - это название класса: @Listeners(TestListener.class)
//нужен для выполнения каких-то действий на каком-то из этапов выполнения тестов(здесь используем для базового логирования в консоль и для получения скрина окна при падении теста)
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.printf("Test started: %s%n", result.getName());
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.
                getTestContext(). // достает контекст выполнения теста, в которым будет храниться наш драйвер
                getAttribute("driver");
        //старая строчка
        //byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        System.out.println(String.format("Test failed: %s", result.getName()));

        AllureUtils.takeScreenshot(driver);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(String.format("Test succeed: %s", result.getName()));
    }
}
