package Tests;
import Main.base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TCLogin extends base {
    //Sign in test with proper credentials
    @Test(priority = 4)
    public void signIn() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        signin.setEmail("INSERT VALID ACCOUNT EMAIL");
        signin.setPass("INSERT PASSWORD");
        signin.clickLogin();

        Assert.assertTrue(accpage.isLoginSuccessful());
    }
    //Sign in test with wrong credentials
    @Test(priority = 3)
    public void wrongSignIn(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        signin.setEmail("wrong@mail.com");
        signin.setPass("fakepass");
        signin.clickLogin();

        Assert.assertTrue(signin.getAuthError().isDisplayed());
    }
    //Blank field error test
    @Test(priority = 2)
    public void signInBlank(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        signin.setEmail("");
        signin.setPass("fakepass");
        signin.clickLogin();
        Assert.assertTrue(signin.getBlankEmailError().isDisplayed());

        signin.setEmail("mail@mail.com");
        signin.setPass("");
        signin.clickLogin();
        Assert.assertTrue(signin.getBlankPassError().isDisplayed());

        signin.setEmail("");
        signin.setPass("");
        signin.clickLogin();
        Assert.assertTrue(signin.getBlankEmailError().isDisplayed());

    }


    //Email format highlight test
    @Test(priority = 1)
    public void emailHighlightTest(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        //Correct format
        signin.setEmail("email@email.com");
        signin.getPassInput().click();

        Assert.assertTrue(signin.emailHighlightGreen());

        //Wrong format
        signin.setEmail("email");
        signin.getPassInput().click();

        Assert.assertTrue(signin.emailHighlightRed());

    }


}
