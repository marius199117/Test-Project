package UI.common;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public void scrollToElement(By area) {
        WebElement areaToGoTo = driver.findElement(area);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", areaToGoTo);
    }

    public void elementLoadedInAnotherTab(String page) {
        String initialTab = driver.getWindowHandle();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        tabs.remove(initialTab);

        boolean wasFound = false;
        for (int i = 0; i < tabs.size() && !wasFound; i++) {

            driver.switchTo().window(tabs.get(i));
            wasFound = driver.getCurrentUrl().equalsIgnoreCase(page);

            if (wasFound) {
                driver.close();
                driver.switchTo().window(initialTab);
            }
        }
        if (!wasFound) {
            fail("Could not find page in another tab");
        }
    }

    public static void selectDropdownByValue(By dropdownId, String value) {
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        WebElement dropdownElement = waiter.until(ExpectedConditions.elementToBeClickable(dropdownId));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public void i_Press(String keyboardKey) {
        if ("Enter".equals(keyboardKey)) {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
        } else {
            fail("Key " + keyboardKey + " not handled!");
        }
    }

    public void atLeastOneResult (By xpath) {
        List<WebElement> elements = driver.findElements(xpath);

        if (!elements.isEmpty()) {
            System.out.println("At least one element is present with the specified XPath.");
        } else {
            System.out.println("No element found with the specified XPath.");
        }
    }
}

