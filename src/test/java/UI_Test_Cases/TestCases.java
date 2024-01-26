package UI_Test_Cases;

import UI.pages.ResultsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import UI.common.CommonDefinitions;
import UI.pages.HomePageBundles;

public class TestCases extends CommonDefinitions {

    HomePageBundles bundlesPage = new HomePageBundles();
    ResultsPage resultPage = new ResultsPage();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.hotwire.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
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
