package UI.common;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;;git stat

import static org.junit.Assert.fail;

public class CommonDefinitions {

    public static WebDriver driver = null;

    public void wait10AndClick(By xpath) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.elementToBeClickable(xpath));
        driver.findElement(xpath).click();
    }

    public void elementIsDisplayed(By xPathToSearchFor) {
        WebElement element = driver.findElement(xPathToSearchFor);
        Assert.assertNotNull("Element not found with locator: " + xPathToSearchFor, element);
    }

    public void insertKeywoardIntoField(By locator, String keyword) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement field = waiter.until(ExpectedConditions.elementToBeClickable(locator));
        field.clear();
        field.sendKeys(keyword);
    }

    public static void selectDropdownByValue(By dropdownId, String value) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement dropdownElement = waiter.until(ExpectedConditions.elementToBeClickable(dropdownId));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public void iPress(String keyboardKey) {
        if ("Enter".equals(keyboardKey)) {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
        } else {
            fail("Key " + keyboardKey + " not handled!");
        }
    }
}

