package pageobject.selenidepageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageobject.selenidepageobject.pageelement.FooterMenu;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static pageobject.helpers.Locators.getLocator;

/**
 * Class for object LoginPage
 */
public class LoginPage extends PageBase {
    // Fields:
    public FooterMenu footerMenu;

    /**
     * Constructor for class LoginPage
     */
    public LoginPage() {
        footerMenu = new FooterMenu($(getLocator("HomePage.footerMenuLocator")));
    }

    /**
     * Method to enter email into email input field
     * @param email
     */
    private void enterEmail(String email) {
        LOG.debug("Entering email");
        $(getLocator("LoginPage.emailInput")).sendKeys(email);
    }

    /**
     * Method to enter password into password input field
     * @param password
     */
    private void enterPassword(String password) {
        LOG.debug("Entering password");
        $(getLocator("LoginPage.passwordInput")).sendKeys(password);
    }

    /**
     * Method to click login button
     */
    @Step("Clicking login button after entering email and password")
    private void clickLoginButton() {
        LOG.debug("Clicking login button");
        $(getLocator("LoginPage.loginButton")).click();
    }

    /**
     * Method to full login actions
     * @param email
     * @param password
     */
    public HomePage attemptLogin(String email, String password) {
        LOG.info("Logining on the login page");
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return page(HomePage.class);
    }

    /**
     * Method to check error login message
     */
    @Step("Checking error login message")
    public void loginErrorMessageIsVisible() {
        LOG.info("Checking error login message");
        $(getLocator("LoginPage.loginErrorMessage")).shouldBe(Condition.visible)
                .shouldHave(text("Wrong password or the account is disabled, or does not exist"));
    }

    /**
     * Method to check open 'Login' page
     */
    @Step("Checking opening 'Login' page")
    public SelenideElement hasOpened() {
        return super.hasOpened("Login | My Store");
    }
}
