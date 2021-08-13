import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99ApplicationTest {

    ChromeDriver driver;

    String url = "http://demo.guru99.com/v4/";

    @Test(priority = 0)
    public void invokeBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);
    }

    @Test(priority = 100)
    public void verifyTitleOfThePage() {

        String expectedTitle = "Guru99 Bank Manager HomePage";

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 200)
    public void verifyLoginToGuru99Application() {

        WebElement userId = driver.findElement(By.name("uid"));

        WebElement userPassword = driver.findElement(By.name("password"));

        WebElement loginButton = driver.findElement(By.name("btnLogin"));

        userId.sendKeys("mngr347495");

        userPassword.sendKeys("utaregU");

        loginButton.click();
    }

    @Test(priority = 300)
    public void addCustomer() {

        WebElement addCustomerLink = driver.findElement(By.linkText("New Customer"));

        addCustomerLink.click();

        driver.findElement(By.xpath("//input[@value='f']")).click();
        driver.findElement(By.name("name")).sendKeys("Jan Kowalski");
        driver.findElement(By.name("dob")).sendKeys("08/08/1999");
        driver.findElement(By.name("addr")).sendKeys("Warszawa");
        driver.findElement(By.name("city")).sendKeys("mazow");
        driver.findElement(By.name("state")).sendKeys("mazow");
        driver.findElement(By.name("pinno")).sendKeys("122001");
        driver.findElement(By.name("telephoneno")).sendKeys("97987689345");
        driver.findElement(By.name("emailid")).sendKeys("abc@dru.com");
        driver.findElement(By.name("password")).sendKeys("barbapapa69");
        driver.findElement(By.name("sub")).click();
    }
}
