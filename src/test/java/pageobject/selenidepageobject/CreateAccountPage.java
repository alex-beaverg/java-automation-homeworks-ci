package pageobject.selenidepageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageobject.selenidepageobject.pageelement.FooterMenu;

import static com.codeborne.selenide.Selenide.$;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class for object CreateAccountPage
 */
public class CreateAccountPage extends PageBase {
    // Fields:
    public FooterMenu footerMenu;

    /**
     * Constructor for class CreateAccountPage
     */
    public CreateAccountPage() {
        footerMenu = new FooterMenu($(getLocator("HomePage.footerMenuLocator")));
    }

    /**
     * Method to check open 'Create Account' page
     */
    @Step("Checking opening 'Create Account' page")
    public SelenideElement hasOpened() {
        return super.hasOpened("Create Account | My Store");
    }
}
