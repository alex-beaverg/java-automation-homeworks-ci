package pageobject.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class Locators
 */
public class Locators {
    // Fields:
    private static final Properties locators;
    // Logger:
    protected static Logger LOG = Logger.getLogger(Locators.class);
    // Static initializer:
    static {
        locators = new Properties();
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");
        try {
            locators.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Could not read from locators.properties file.\n" + e.getMessage());
        }
    }

    public static By getLocator(String elem) {
        LOG.debug("Getting locator for '" + elem + "' element");
        String locator = locators.getProperty(elem);
        String[] result = locator.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(result[0]);
        String selector = result[1];
        switch (locatorType) {
            case id -> { return By.id(selector); }
            case name ->  { return By.name(selector); }
            case className -> { return By.className(selector); }
            case tagName -> { return By.tagName(selector); }
            case linkText -> { return By.linkText(selector); }
            case partialLinkText -> { return By.partialLinkText(selector); }
            case cssSelector -> { return By.cssSelector(selector); }
            case xpath -> { return By.xpath(selector); }
            default -> throw new RuntimeException("No such locator type");
        }
    }
}
