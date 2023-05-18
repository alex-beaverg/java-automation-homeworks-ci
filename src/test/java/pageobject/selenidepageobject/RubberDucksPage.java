package pageobject.selenidepageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageobject.selenidepageobject.pageelement.FooterMenu;
import pageobject.selenidepageobject.pageelement.MainMenu;

import static com.codeborne.selenide.Selenide.$;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class for object RubberDucksPage
 */
public class RubberDucksPage extends PageBase {
    // Fields:
    public MainMenu mainMenu;
    public FooterMenu footerMenu;

    /**
     * Constructor for class RubberDucksPage
     */
    public RubberDucksPage() {
        mainMenu = new MainMenu($(getLocator("RubberDucksPage.mainMenuLocator")));
        footerMenu = new FooterMenu($(getLocator("HomePage.footerMenuLocator")));
    }

    /**
     * Method to check open 'Rubber Ducks' page
     */
    @Step("Checking opening 'Rubber Ducks' page")
    public SelenideElement hasOpened() {
        return super.hasOpened("Rubber Ducks | My Store");
    }
}
