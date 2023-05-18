package pageobject.selenidepageobject.pageelement;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pageobject.selenidepageobject.*;

import static com.codeborne.selenide.Selenide.page;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class FooterMenu (page element)
 */
public class FooterMenu {
    // Logger:
    private final Logger LOG = Logger.getLogger(FooterMenu.class);
    // SelenideElements:
    private final SelenideElement footerMenuItems;

    /**
     * Constructor for class FooterMenuMenu
     * @param footerMenuItems
     */
    public FooterMenu(SelenideElement footerMenuItems) {
        this.footerMenuItems = footerMenuItems;
    }

    /**
     * Method to get footer menu item
     * @param footerMenuItem
     */
    @Step("Clicking to '{0}' footer menu item")
    public PageBase clickFooterMenuItem(String footerMenuItem) {
        LOG.info("Clicking to '" + footerMenuItem + "' footer menu item");
        switch (footerMenuItem) {
            case "Rubber Ducks" -> {
                footerMenuItems.$(getLocator("FooterMenu.rubberDucks")).click();
                return page(RubberDucksPage.class);
            }
            case "ACME Corp." -> {
                footerMenuItems.$(getLocator("FooterMenu.acmeCorp")).click();
                return page(AcmeCorpPage.class);
            }
            case "Customer Service" -> {
                footerMenuItems.$(getLocator("FooterMenu.customerService")).click();
                return page(CustomerServicePage.class);
            }
            case "Regional Settings" -> {
                footerMenuItems.$(getLocator("FooterMenu.regionalSettings")).click();
                return page(RegionalSettingsPage.class);
            }
            case "Create Account" -> {
                footerMenuItems.$(getLocator("FooterMenu.createAccount")).click();
                return page(CreateAccountPage.class);
            }
            case "About Us" -> {
                footerMenuItems.$(getLocator("FooterMenu.aboutUs")).click();
                return page(AboutUsPage.class);
            }
            case "Delivery Information" -> {
                footerMenuItems.$(getLocator("FooterMenu.deliveryInformation")).click();
                return page(DeliveryInformationPage.class);
            }
            case "Privacy Policy" -> {
                footerMenuItems.$(getLocator("FooterMenu.privacyPolicy")).click();
                return page(PrivacyPolicyPage.class);
            }
            case "Terms & Conditions" -> {
                footerMenuItems.$(getLocator("FooterMenu.termsAndConditions")).click();
                return page(TermsAndConditionsPage.class);
            }
            default -> throw new RuntimeException("No such footer menu item");
        }
    }
}
