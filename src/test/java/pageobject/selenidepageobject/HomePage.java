package pageobject.selenidepageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageobject.selenidepageobject.pageelement.FooterMenu;
import pageobject.selenidepageobject.pageelement.MainMenu;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class for object HomePage
 */
public class HomePage extends PageBase {
    // Fields:
    public MainMenu mainMenu;
    public FooterMenu footerMenu;

    /**
     * Constructor for class HomePage
     */
    public HomePage() {
        mainMenu = new MainMenu($(getLocator("HomePage.mainMenuLocator")));
        footerMenu = new FooterMenu($(getLocator("HomePage.footerMenuLocator")));
    }

    /**
     * Method to check success login message
     */
    @Step("Checking success login message")
    public void successMessageIsVisible() {
        LOG.info("Checking success login message");
        $(getLocator("HomePage.successMessage")).shouldBe(Condition.visible)
                .shouldHave(text("You are now logged in as Alexey Bobrikov."));
    }

    /**
     * Method to check open 'Online Store' page (Home page)
     */
    @Step("Checking opening 'Online Store' page (Home page)")
    public SelenideElement hasOpened() {
        return super.hasOpened("Online Store | My Store");
    }
}
