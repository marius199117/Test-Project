package UI.pages;

import UI.common.CommonDefinitions;
import com.gargoylesoftware.htmlunit.svg.SvgFeOffset;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class HomePageBundles extends CommonDefinitions {
    private final By bundlesButton = By.xpath("//div[@data-bdd='farefinder-option-bundles']");
    private final By carButton = By.xpath("//button[@data-bdd='farefinder-package-bundleoption-car']");

    private final By flyFrom = By.xpath("(//input[@placeholder='Enter address, city or airport'])[1]");
    private final By flyTo = By.xpath("(//input[@placeholder='Enter address, city or airport'])[2]");

    private final By departureDateLocator = By.xpath("//div[@class='picker__overlay picker__overlay--selectable'][@data-bdd='farefinder-package-startdate-input']");

    private final By startDateLocator = By.xpath("//td[@aria-label='February 12, 2024']");
    private final By endDateLocator = By.xpath("//td[@aria-label='February 24, 2024']");

    private final By departingTime = By.xpath("//select[@name='carPickupTime']");
    private final By returningTime = By.xpath("//select[@name='carDropoffTime']");
    private final By findADeal = By.xpath("//button[@type='submit']");


    public void bundles() throws InterruptedException {
        wait10AndClick(bundlesButton);
        wait10AndClick(carButton);
        insertKeywoardIntoField(flyFrom, "SFO");
        i_Press("Enter");
        Thread.sleep(2000);
        insertKeywoardIntoField(flyTo, "LAX");
        Thread.sleep(2000);
        i_Press("Enter");
        wait10AndClick(departureDateLocator);
        Thread.sleep(1000);
        wait10AndClick(startDateLocator);
        wait10AndClick(endDateLocator);
        Thread.sleep(1000);
        selectDropdownByValue(departingTime, "Evening");
        selectDropdownByValue(returningTime, "Morning");
        wait10AndClick(findADeal);
    }
}
