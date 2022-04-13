package Main;

import Pages.CreateAccountForm;
import Pages.CreateAccountPage;
import Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class base {
    public WebDriver driver;
    public SignInPage signin;
    public CreateAccountPage accpage;
    public CreateAccountForm accForm;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sradm\\Downloads\\chromedriver.exe\\");
        driver = new ChromeDriver();

        signin = new SignInPage(driver);
        accpage = new CreateAccountPage(driver);
        accForm = new CreateAccountForm(driver);

        driver.manage().window().maximize();
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
