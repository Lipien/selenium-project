import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Guru99ApplicationTest {

    ChromeDriver driver;

    String url = "http://demo.guru99.com/v4/";

    @BeforeMethod
    public void invokeBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);
    }

    @Test
    public void verifyTitleOfThePage() {

        String expectedTitle = "Guru99 Bank Home Page";

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
