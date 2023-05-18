package pageobject.selenidepageobject;

import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static pageobject.helpers.Locators.getLocator;

/**
 * Parent class PageBase
 */
public class PageBase {
    // Logger:
    protected Logger LOG = Logger.getLogger(PageBase.class);
    /**
     * Method to check open page
     */
    public SelenideElement hasOpened(String titleText) {
        LOG.info("Checking opening '" + ($(getLocator("title")).getAttribute("text"))
                .replace(" | My Store", "' page"));
        return $(getLocator("title")).shouldHave(attribute("text", titleText));
    }
}
