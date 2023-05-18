/*
Run from IDE:
    Shift + F10
    With Run configuration
    With right click to java-file (class, method)
    With right click to xml-file
Run from command-line:
    Run all tests:
        mvn clean test
    Run tests with xml suite:
        Run all tests:
            mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/selenide-all-tests.xml
        Run login tests:
            mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/selenide-login-tests.xml
        Run after login tests:
            mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/selenide-after-login-tests.xml
        Run main menu items tests:
            mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/selenide-main-menu-items-tests.xml
        Run footer menu items tests:
            mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/selenide-footer-menu-items-tests.xml
Clean folder 'target' from command-line:
    mvn clean
View allure results after maven test:
    mvn allure:serve
Use another browser -> add to cmd-line:
    -Dselenide.browser=firefox
    -Dselenide.browser=edge
Run only test-file -> add to cmd-line:
    -Dtest="SelenideTest"
Run only test-method in test-file -> add to cmd-line:
    -Dtest="SelenideTest#successLoginTest"
( If you use PowerShell cmd-line, need to write --% before -D )
*/

package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pageobject.selenidepageobject.*;

import static com.codeborne.selenide.Selenide.open;

/**
 * Class SelenideTest (Selenide PageObject model)
 */
@Epic("Selenide tests")
@Feature("Selenide tests")
@Story("Selenide tests")
public class SelenideTest extends TestBase {
    // Logger:
    private final Logger LOG = Logger.getLogger(SelenideTest.class);
    private final String LOGInfo = "* [TEST_METHOD]: ";

    /**
     * Test method to successful customer login
     */
    @Test(groups = "login tests")
    @Description("Test method to successful customer login")
    public void successLoginTest() {
        LOG.info(LOGInfo + "Testing logining with successful customer login");
        LoginPage loginPage = open("https://litecart.stqa.ru/en/login", LoginPage.class);
        HomePage homePage = loginPage.attemptLogin("a.beaverg@gmail.com", "Test1234!");
        homePage.successMessageIsVisible();
    }

    /**
     * Test method to unsuccessful customer login
     */
    @Test(groups = "login tests")
    @Description("Test method to unsuccessful customer login")
    public void unSuccessLoginTest() {
        LOG.info(LOGInfo + "Testing logining with unsuccessful customer login");
        LoginPage loginPage = open("https://litecart.stqa.ru/en/login", LoginPage.class);
        loginPage.attemptLogin("my.mail@mail.domen", "Test1000!");
        loginPage.loginErrorMessageIsVisible();
    }

    /**
     * Test method to load 'Online Store' page (Home page) after successful logining
     */
    @Test(groups = "after login tests")
    @Description("Test method to load 'Online Store' page (Home page) after successful logining")
    public void homePageLoadedTest() {
        LOG.info(LOGInfo + "Testing loading 'Home' page after successful customer login");
        LoginPage loginPage = open("https://litecart.stqa.ru/en/login", LoginPage.class);
        HomePage homePage = loginPage.attemptLogin("a.beaverg@gmail.com", "Test1234!");
        homePage.hasOpened();
    }

    /**
     * Test method to load 'Login' page after unsuccessful logining
     */
    @Test(groups = "after login tests")
    @Description("Test method to load 'Login' page after unsuccessful logining")
    public void loginPageLoadedTest() {
        LOG.info(LOGInfo + "Testing loading 'Login' page after unsuccessful customer login");
        LoginPage loginPage = open("https://litecart.stqa.ru/en/login", LoginPage.class);
        loginPage.attemptLogin("my.mail@mail.domen", "Test1000!");
        loginPage.hasOpened();
    }

    /**
     * Test method to check 'Rubber Ducks' main menu item
     */
    @Test(groups = "main menu items tests")
    @Description("Test method to check 'Rubber Ducks' main menu item")
    public void rubberDucksMainMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Rubber Ducks' main menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        RubberDucksPage rubberDucksPage = (RubberDucksPage) homePage.mainMenu.clickToMainMenuItem("Rubber Ducks");
        rubberDucksPage.hasOpened();
    }

    /**
     * Test method to check 'Subcategory' main menu item
     */
    @Test(groups = "main menu items tests")
    @Description("Test method to check 'Subcategory' main menu item")
    public void subcategoryMainMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Subcategory' main menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        SubcategoryPage subcategoryPage = (SubcategoryPage) homePage.mainMenu.clickToMainMenuItem("Subcategory");
        subcategoryPage.hasOpened();
    }

    /**
     * Test method to check 'Home' main menu item
     */
    @Test(groups = "main menu items tests")
    @Description("Test method to check 'Home' main menu item")
    public void homeMainMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Home' main menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        RubberDucksPage rubberDucksPage = (RubberDucksPage) homePage.mainMenu.clickToMainMenuItem("Rubber Ducks");
        homePage = (HomePage) rubberDucksPage.mainMenu.clickToMainMenuItem("Home");
        homePage.hasOpened();
    }

    /**
     * Test method to check 'Rubber Ducks' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'Rubber Ducks' footer menu item")
    public void rubberDucksFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Rubber Ducks' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        RubberDucksPage rubberDucksPage = (RubberDucksPage) homePage.footerMenu.clickFooterMenuItem("Rubber Ducks");
        rubberDucksPage.hasOpened();
    }

    /**
     * Test method to check 'ACME Corp.' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'ACME Corp.' footer menu item")
    public void acmeCorpFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'ACME Corp.' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        AcmeCorpPage acmeCorpPage = (AcmeCorpPage) homePage.footerMenu.clickFooterMenuItem("ACME Corp.");
        acmeCorpPage.hasOpened();
    }

    /**
     * Test method to check 'Customer Service' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'Customer Service' footer menu item")
    public void customerServiceFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Customer Service' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        CustomerServicePage customerServicePage = (CustomerServicePage) homePage.footerMenu
                .clickFooterMenuItem("Customer Service");
        customerServicePage.hasOpened();
    }

    /**
     * Test method to check 'Regional Settings' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'Regional Settings' footer menu item")
    public void regionalSettingsFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Regional Settings' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        RegionalSettingsPage regionalSettingsPage = (RegionalSettingsPage) homePage.footerMenu
                .clickFooterMenuItem("Regional Settings");
        regionalSettingsPage.hasOpened();
    }

    /**
     * Test method to check 'Create Account' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'Create Account' footer menu item")
    public void createAccountFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Create Account' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        CreateAccountPage createAccountPage = (CreateAccountPage) homePage.footerMenu
                .clickFooterMenuItem("Create Account");
        createAccountPage.hasOpened();
    }

    /**
     * Test method to check 'About Us' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'About Us' footer menu item")
    public void aboutUsFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'About Us' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        AboutUsPage aboutUsPage = (AboutUsPage) homePage.footerMenu.clickFooterMenuItem("About Us");
        aboutUsPage.hasOpened();
    }

    /**
     * Test method to check 'Delivery Information' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'Delivery Information' footer menu item")
    public void deliveryInformationFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Delivery Information' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        DeliveryInformationPage deliveryInformationPage = (DeliveryInformationPage) homePage.footerMenu
                .clickFooterMenuItem("Delivery Information");
        deliveryInformationPage.hasOpened();
    }

    /**
     * Test method to check 'Privacy Policy' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'Privacy Policy' footer menu item")
    public void privacyPolicyFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Privacy Policy' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        PrivacyPolicyPage privacyPolicyPage = (PrivacyPolicyPage) homePage.footerMenu
                .clickFooterMenuItem("Privacy Policy");
        privacyPolicyPage.hasOpened();
    }

    /**
     * Test method to check 'Terms & Conditions' footer menu item
     */
    @Test(groups = "footer menu items tests")
    @Description("Test method to check 'Terms & Conditions' footer menu item")
    public void termsAndConditionsFooterMenuItemTest() {
        LOG.info(LOGInfo + "Testing checking 'Terms & Conditions' footer menu item");
        HomePage homePage = open("https://litecart.stqa.ru/en/", HomePage.class);
        TermsAndConditionsPage termsAndConditionsPage = (TermsAndConditionsPage) homePage.footerMenu
                .clickFooterMenuItem("Terms & Conditions");
        termsAndConditionsPage.hasOpened();
    }
}
