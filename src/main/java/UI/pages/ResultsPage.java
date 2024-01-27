package UI.pages;

import UI.common.CommonDefinitions;
import org.openqa.selenium.By;

public class ResultsPage extends CommonDefinitions {
    private final By resultElements = By.xpath("//a[@data-stid='open-hotel-information']");
    public void result() {
        elementIsDisplayed(resultElements);
    }

}
