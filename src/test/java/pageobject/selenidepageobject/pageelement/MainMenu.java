package pageobject.selenidepageobject.pageelement;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import pageobject.selenidepageobject.HomePage;
import pageobject.selenidepageobject.PageBase;
import pageobject.selenidepageobject.RubberDucksPage;
import pageobject.selenidepageobject.SubcategoryPage;

import static com.codeborne.selenide.Selenide.page;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class MainMenu (page element)
 */
public class MainMenu {
    // Logger:
    private final Logger LOG = Logger.getLogger(MainMenu.class);
    // SelenideElements:
    private final SelenideElement mainMenuItems;

    /**
     * Constructor for class MainMenu
     * @param mainMenuItems
     */
    public MainMenu(SelenideElement mainMenuItems) {
        this.mainMenuItems = mainMenuItems;
    }

    /**
     * Method to click main menu item
     * @param mainMenuItem
     */
    @Step("Clicking to '{0}' main menu item")
    public PageBase clickToMainMenuItem(String mainMenuItem) {
        LOG.info("Clicking to '" + mainMenuItem + "' main menu item");
        switch (mainMenuItem) {
            case "Home" -> {
                mainMenuItems.$(getLocator("MainMenu.home")).click();
                return page(HomePage.class);
            }
            case "Rubber Ducks" -> {
                mainMenuItems.$(getLocator("MainMenu.rubberDucks")).click();
                return page(RubberDucksPage.class);
            }
            case "Subcategory" -> {
                Actions builder = new Actions(WebDriverRunner.getWebDriver());
                builder.moveToElement(mainMenuItems.$(getLocator("MainMenu.subcategory")))
                        .moveByOffset(0,45).click().perform();
                return page(SubcategoryPage.class);
            }
            default -> throw new RuntimeException("No such main menu item");
        }
    }
}
