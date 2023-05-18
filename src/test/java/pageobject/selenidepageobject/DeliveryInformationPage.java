package pageobject.selenidepageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageobject.selenidepageobject.pageelement.FooterMenu;

import static com.codeborne.selenide.Selenide.$;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class for object DeliveryInformationPage
 */
public class DeliveryInformationPage extends PageBase {
    // Fields:
    public FooterMenu footerMenu;

    /**
     * Constructor for class DeliveryInformationPage
     */
    public DeliveryInformationPage() {
        footerMenu = new FooterMenu($(getLocator("HomePage.footerMenuLocator")));
    }

    /**
     * Method to check open 'Delivery Information' page
     */
    @Step("Checking opening 'Delivery Information' page")
    public SelenideElement hasOpened() {
        return super.hasOpened("Delivery Information | My Store");
    }
}
