package UI.pages;

import UI.common.CommonDefinitions;
import org.openqa.selenium.By;

public class ResultsPage extends CommonDefinitions {
    private final By resultElements = By.xpath("//div[@class='uitk-spacing uitk-spacing-margin-blockstart-three']");
    public void result() {
        atLeastOneResult(resultElements);
    }

}
