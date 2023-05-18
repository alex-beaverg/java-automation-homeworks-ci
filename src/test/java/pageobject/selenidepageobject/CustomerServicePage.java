package pageobject.selenidepageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageobject.selenidepageobject.pageelement.FooterMenu;

import static com.codeborne.selenide.Selenide.$;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class for object CustomerServicePage
 */
public class CustomerServicePage extends PageBase {
    // Fields:
    public FooterMenu footerMenu;

    /**
     * Constructor for class CustomerServicePage
     */
    public CustomerServicePage() {
        footerMenu = new FooterMenu($(getLocator("HomePage.footerMenuLocator")));
    }

    /**
     * Method to check open 'Customer Service' page
     */
    @Step("Checking opening 'Customer Service' page")
    public SelenideElement hasOpened() {
        return super.hasOpened("Customer Service | My Store");
    }
}
