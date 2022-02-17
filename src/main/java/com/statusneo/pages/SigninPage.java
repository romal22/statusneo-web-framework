package com.statusneo.pages;


import com.statusneo.framework.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * This class contains all the elements and actions performed on SigninPage
 *
 * @author ikumar
 */

@Log4j2
public class SigninPage extends AbstractBasePage {

    @FindBy(xpath = "//h1[normalize-space()='Sign in']")
    private WebElement pageHeaderTitle;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//a[normalize-space()='Use email instead']")
    private WebElement useEmailInsteadLink;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//label[normalize-space()='Password']")
    private WebElement passwordFieldPlaceholder;

    @FindBy(xpath = "//a[normalize-space()='Forgot your password?']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[@cursor='pointer']")
    private WebElement showPasswordIcon;

    @FindBy(xpath = "//input[@name='rememberMe']/..")
    private WebElement rememberMeRadioButton;

    @FindBy(css = "button[type='submit']")
    private WebElement signinButton;

    @FindBy(id = "checkbox")
    private WebElement hCaptchaCheckbox;

    @FindBy(xpath = "//iframe[contains(@title,'checkbox')]")
    private WebElement hCaptchaiFrame;

    @FindBy(xpath = "//label[normalize-space()='Email']")
    private WebElement emailFieldPlaceholder;

    @FindBy(name = "email")
    private WebElement emailInputField;

    @FindBy(xpath = "//span[contains(text(),'Invalid login and password')]")
    private WebElement invalidLoginErrorMessage;

    @FindBy(css = ".flag.us")
    private WebElement countryCodeFlagUS;

    @FindBy(xpath = "//a[normalize-space()='Try for free']")
    private WebElement tryForFreeLink;

    @FindBy(xpath = "//div[contains(text(),'Email is required')]")
    private WebElement blankEmailErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Invalid Phone Number')]")
    private WebElement invalidPhoneErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Please enter a valid email')]")
    private WebElement invalidEmailErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Password is too short')]")
    private WebElement invalidPasswordErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'must be at most 40 characters')]")
    private WebElement maxPasswordLengthErrorMessage;

    public SigninPage(WebDriver driver) {
        super(driver);
    }



    public boolean isPhoneNumberFieldDisplayed() {
        log.info("Verify Phone Number field is displayed");
        return phoneNumberField.isDisplayed();
    }

    public boolean isUseEmailInsteadLinkDisplayed() {
        log.info("Verify Use Email Instead link is displayed");
        return useEmailInsteadLink.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        log.info("Verify Password field is displayed");
        return passwordField.isDisplayed();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        log.info("Verify Forgot Password link is displayed");
        return forgotPasswordLink.isDisplayed();
    }

    public boolean isShowPasswordIconDisplayed() {
        log.info("Verify Show Password icon is displayed");
        return showPasswordIcon.isDisplayed();
    }

    public boolean isRememberMeRadioButtonDisplayed() {
        log.info("Verify Remember Me radio button is displayed");
        return rememberMeRadioButton.isDisplayed();
    }

    public boolean isSignInButtonDisplayed() {
        log.info("Verify Sign In button is displayed");
        return signinButton.isDisplayed();
    }

    public boolean isSignInButtonEnabled() {
        log.info("Verify Sign In button is enabled");
        return signinButton.isEnabled();
    }

    public SigninPage enterPhoneNumber(String phoneNumber) {
        log.info("Enter phone number");
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    public SigninPage clearEmailAddress() {
        log.info("Clear phone number");
        useEmailInsteadLink.click();
        waitForVisibilityOfElement(emailInputField);
        emailInputField.sendKeys("A", Keys.BACK_SPACE);
        return this;
    }

    public SigninPage enterEmailAddress(String email) {
        log.info("Enter email address");
        useEmailInsteadLink.click();
        waitForVisibilityOfElement(emailInputField);
        emailInputField.sendKeys(email);
        return this;
    }

    public SigninPage enterPassword(String password) {
        log.info("Enter password");
        passwordField.sendKeys(password);
        return this;
    }

    public SigninPage clickRememberMeRadioButton() {
        log.info("Click Remember Me radio button");
        rememberMeRadioButton.click();
        return this;
    }

    public String getPhoneNumberFieldPlaceholder() {
        log.info("Get Phone Number field placeholder text");
        return phoneNumberField.getAttribute("placeholder");
    }

    public String getTextForEmailField() {
        log.info("Get Email field placeholder text");
        useEmailInsteadLink.click();
        waitForVisibilityOfElement(emailFieldPlaceholder);
        return emailFieldPlaceholder.getText();
    }

    public String getTextForPasswordField() {
        log.info("Get Password field placeholder text");
        return passwordFieldPlaceholder.getText();
    }

    public SigninPage clickSigninButton() {
        log.info("Click Signin button");
        signinButton.click();
        return this;
    }

    public boolean isInvalidLoginErrorMessageDisplayed() {
        log.info("Verify Invalid Login Error Message is displayed");
        return invalidLoginErrorMessage.isDisplayed();
    }

    public String getPhoneNumberFieldValue() {
        log.info("Get Phone Number field value");
        return phoneNumberField.getAttribute("value");
    }

    public String getPasswordFieldValue() {
        log.info("Get Password field value");
        return passwordField.getAttribute("value");
    }

    public SigninPage clickBackButton() {
        log.info("Click Back Button ");
        driver.navigate().back();
        return this;
    }

    public SigninPage clickForwardButton() {
        log.info("Click Forward Button Button ");
        driver.navigate().forward();
        return this;
    }

    public boolean isCountryCodeFlagUSDisplayed() {
        log.info("Verify Country Code Flag US is displayed");
        return countryCodeFlagUS.isDisplayed();
    }

    public boolean isBlankEmailErrorMessageDisplayed() {
        log.info("Verify Blank Email Error Message is displayed");
        return blankEmailErrorMessage.isDisplayed();
    }

    public boolean isInvalidPhoneErrorMessageDisplayed() {
        log.info("Verify Invalid Phone Error Message is displayed");
        return invalidPhoneErrorMessage.isDisplayed();
    }

    public boolean isInvalidEmailErrorMessageDisplayed() {
        log.info("Verify Invalid Email Error Message is displayed");
        return invalidEmailErrorMessage.isDisplayed();
    }

    public boolean isInvalidPasswordErrorMessageDisplayed() {
        log.info("Verify Invalid Password Error Message is displayed");
        return invalidPasswordErrorMessage.isDisplayed();
    }

    public boolean isMaxPasswordLengthErrorMessageDisplayed() {
        log.info("Verify Max Password Length Error Message is displayed");
        return maxPasswordLengthErrorMessage.isDisplayed();
    }

    @Override
    public void isOnPage() {
        log.info("Verify Login Page");
        waitForVisibilityOfElement(pageHeaderTitle);
    }
}
