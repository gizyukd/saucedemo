package tests.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println(String.format("Test started: %s", result.getName()));
    }

    public void onTestFailure(ITestResult result) {
        //TODO Make Screenshots
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        System.out.println(String.format("Test failed: %s", result.getName()));
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(String.format("Test succeed: %s", result.getName()));
    }
}
