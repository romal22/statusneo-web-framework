package com.statusneo.utilities;

import com.statusneo.framework.Configuration;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


/**
 * Helper class contains all the element related generic methods
 *
 * @author ikumar
 */
public class ElementHelper {

    private WebDriver driver;
    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String getElementColorCode(WebElement webElement) {
        String colorCode = webElement.getCssValue("color");
        return Color.fromString(colorCode).asHex();
    }

    public void clearTextUsingRepeatedBackspace(WebElement webElement, int repeatCount) {
        String backspace = Keys.BACK_SPACE.toString();
        webElement.sendKeys(StringUtils.repeat(backspace, repeatCount));
    }

    public void selectValueFromDropDown(WebElement dropDownElement, String dropDownValue) {
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText(dropDownValue);
    }

    public String getValueFromDropDown(WebElement dropDownElement, int optionIndex) {
        Select dropDown = new Select(dropDownElement);
        List<WebElement> options = dropDown.getOptions();
        return options.get(optionIndex).getText();
    }

    public boolean isElementDisplayed(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver , Configuration.DEFAULT_EXPLICIT_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (NoSuchElementException| TimeoutException e) {
            return false;
        }
    }

    public boolean isImageDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver , Configuration.DEFAULT_EXPLICIT_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(element));
            return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        } catch (NoSuchElementException| TimeoutException e) {
        return false;
        }
    }

    /**
     * Wait for the element to disappear from the ui
     *
     * @return boolean false if element is not available in the page else will return true
     */
    public boolean isElementDisappeared(WebElement element) {

        try {
            WebDriverWait wait = new WebDriverWait(driver , Configuration.DEFAULT_EXPLICIT_TIMEOUT);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return element.isDisplayed();
        } catch (TimeoutException| StaleElementReferenceException| NoSuchElementException e) {
            return false;
        }
    }

    public List<String> getAllOptionsFromDropDown(WebElement dropDownElement) {
        Select dropDown = new Select(dropDownElement);
        List<WebElement> allOptions = dropDown.getOptions();

        // Excluding the first option from the list
        allOptions.remove(dropDown.getFirstSelectedOption());

        List<String> allDropDownValues = new ArrayList<>();
        for (WebElement ele : allOptions) {
            allDropDownValues.add(ele.getText());
        }
        return allDropDownValues;
    }

    public List<String> getAllElementsText(List<WebElement> webElements) {
        List<String> elementsText = new ArrayList<>();

        for (WebElement we : webElements) {
            elementsText.add(we.getText());
        }
        return elementsText;
    }

    public void mouseHover(WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
    }
}