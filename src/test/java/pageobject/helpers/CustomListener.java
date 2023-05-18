package pageobject.helpers;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.service.ReportPortal;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.*;
import java.util.Calendar;

/**
 * Class CustomScreenshotListener
 */
public class CustomListener implements IInvokedMethodListener {
    // Logger:
    private final Logger LOG = Logger.getLogger(CustomListener.class);

    /**
     * Override method to take a screenshot of failed test
     * After every method in the Test Class
     * @param method
     * @param testResult
     */
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (testResult.getStatus() != 1) {
            LOG.info("* [ON_TEST_FAILURE_METHOD]: Trying to take a screenshot of failed test");
            File screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.FILE);
            try {
                Allure.addAttachment(testResult.getTestName() + " screenshot", new FileInputStream(screenshot));

            } catch (FileNotFoundException e) {
                LOG.error("* [ON_TEST_FAILURE_METHOD]: Could not take screenshot: " + e.getMessage());
            }
            ReportPortal.emitLog(testResult.getTestName() + " screenshot", "ERROR",
                    Calendar.getInstance().getTime(), screenshot);

            File pageHtml = new File("target/reportportal_page_source.html");
            String pageSource = WebDriverRunner.getWebDriver().getPageSource();
            FileWriter writer = null;
            try {
                writer = new FileWriter(pageHtml);
                writer.write(pageSource);
            } catch (IOException e) {
                LOG.error("* [ON_TEST_FAILURE_METHOD]: Could not take page HTML: " + e.getMessage());
            }
            ReportPortal.emitLog(testResult.getTestName() + " page HTML", "ERROR",
                    Calendar.getInstance().getTime(), pageHtml);
        }
    }
}
