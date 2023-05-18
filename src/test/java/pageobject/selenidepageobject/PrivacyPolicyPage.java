package pageobject.selenidepageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageobject.selenidepageobject.pageelement.FooterMenu;

import static com.codeborne.selenide.Selenide.$;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class for object PrivacyPolicyPage
 */
public class PrivacyPolicyPage extends PageBase {
    // Fields:
    public FooterMenu footerMenu;

    /**
     * Constructor for class PrivacyPolicyPage
     */
    public PrivacyPolicyPage() {
        footerMenu = new FooterMenu($(getLocator("HomePage.footerMenuLocator")));
    }

    /**
     * Method to check open 'Privacy Policy' page
     */
    @Step("Checking opening 'Privacy Policy' page")
    public SelenideElement hasOpened() {
        return super.hasOpened("Privacy Policy | My Store");
    }
}
