package pageobject;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pageobject.helpers.CustomListener;

import static com.codeborne.selenide.Selenide.open;

/**
 * Class TestBase
 */
@Listeners(CustomListener.class)
public class TestBase {
    // Logger:
    private final Logger LOG = Logger.getLogger(TestBase.class);

    /**
     * Setup method for all tests
     */
    @Step("Setup method to open browser with full size window")
    @BeforeMethod(groups = "for all tests")
    @Description("Setup method for all tests")
    public void setup() {
        LOG.debug("* [SETUP_METHOD]: Open driver and maximize window");
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
