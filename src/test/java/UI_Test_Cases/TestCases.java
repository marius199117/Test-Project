package UI_Test_Cases;

import UI.pages.ResultsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import UI.common.CommonDefinitions;
import UI.pages.HomeBundlesPage;

public class TestCases extends CommonDefinitions {

    HomeBundlesPage bundlesPage = new HomeBundlesPage();
    ResultsPage resultPage = new ResultsPage();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.hotwire.com/");
        driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    public void testFlow() throws InterruptedException {
     bundlesPage.bundles();
     resultPage.result();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
