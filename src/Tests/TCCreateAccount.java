package Tests;
import Main.base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TCCreateAccount extends base {

    @Test(priority = 1)
    public void authenticationEmailFieldTest(){
    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    //Blank email field
    accForm.getCreateAccButton().click();
        Assert.assertTrue(accForm.getCreateEmailError().isDisplayed());

    //Wrong email format
    accForm.setCreateEmail("wrongformat");
    accForm.getCreateAccButton().click();

    Assert.assertTrue(accForm.getCreateEmailError().isDisplayed());
    Assert.assertTrue(accForm.getCreateEmailHighlightRed().isDisplayed());

    //Email already registered
    accForm.setCreateEmail("INSERT VALID EMAIL");
    accForm.getCreateAccButton().click();

    Assert.assertTrue(accForm.getEmailRegisteredError().isDisplayed());

    //No error
    accForm.setCreateEmail("email5@gmail.com");
    accForm.getCreateAccButton().click();

    Assert.assertTrue(accpage.getAccountCreationForm().isDisplayed());
    }

    @Test(priority = 2)
    public void personalFieldHighlightsTest(){

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accForm.setCreateEmail("email45@gmail.com");
        accForm.getCreateAccButton().click();

        WebDriverWait waitForPageLoad = new WebDriverWait(driver, 20);
        waitForPageLoad.until(ExpectedConditions.presenceOfElementLocated(By.id("account-creation_form")));

    accpage.setFirstName("");
    accpage.setLastName("");
    accpage.setEmail("");
    accpage.setPassword("");
    accpage.getAccountCreationForm().click();

    Assert.assertTrue(accpage.getFirstNameHighlightRed().isDisplayed());
    Assert.assertTrue(accpage.getLastNameHighlightRed().isDisplayed());
    Assert.assertTrue(accpage.getEmailHighlightRed().isDisplayed());
    Assert.assertTrue(accpage.getPasswordHighlightRed().isDisplayed());

        //filled in (green highlights)
        accpage.setFirstName("John");
        accpage.setLastName("Doe");
        accpage.setEmail("jd@gmail.com");
        accpage.setPassword("johndoe123");
        accpage.getAccountCreationForm().click();

        Assert.assertTrue(accpage.getFirstNameHighlightGreen().isDisplayed());
        Assert.assertTrue(accpage.getLastNameHighlightGreen().isDisplayed());
        Assert.assertTrue(accpage.getEmailHighlightGreen().isDisplayed());
        Assert.assertTrue(accpage.getPasswordHighlightGreen().isDisplayed());
    }
    @Test(priority = 3)
    public void emptyRequiredFields(){

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accForm.setCreateEmail("email45@gmail.com");
        accForm.getCreateAccButton().click();

        WebDriverWait waitForPageLoad = new WebDriverWait(driver, 20);
        waitForPageLoad.until(ExpectedConditions.presenceOfElementLocated(By.id("account-creation_form")));

        accpage.setFirstName("");
        accpage.setLastName("");
        accpage.setPassword("");
        accpage.selectCountry("-");
        accpage.setAddressOne("");
        accpage.setMobilePhone("");
        accpage.setAddressAlias("");
        accpage.setCity("");

        accpage.getRegisterButton().click();

        Assert.assertTrue(accpage.getEmailRequiredError().isDisplayed());
        Assert.assertTrue(accpage.getFirstNameError().isDisplayed());
        Assert.assertTrue(accpage.getLastNameError().isDisplayed());
        Assert.assertTrue(accpage.getCountryRequiredError().isDisplayed());
        Assert.assertTrue(accpage.getPasswordRequiredError().isDisplayed());
        Assert.assertTrue(accpage.getAddressRequiredError().isDisplayed());
        Assert.assertTrue(accpage.getNoPhoneNumberError().isDisplayed());
        Assert.assertTrue(accpage.getAddressAliasRequiredError().isDisplayed());
        Assert.assertTrue(accpage.getCityRequiredError().isDisplayed());

        //Can't select state and zip, without selecting country.
        accpage.selectCountry("United States");
        accpage.setPostalCode("");

        Assert.assertTrue(accpage.getStateRequiredError().isDisplayed());
        Assert.assertTrue(accpage.getPostalCodeError().isDisplayed());
    }

    @Test(priority = 4)
    public void fieldFormatTest(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accForm.setCreateEmail("email45@gmail.com");
        accForm.getCreateAccButton().click();

        WebDriverWait waitForPageLoad = new WebDriverWait(driver, 20);
        waitForPageLoad.until(ExpectedConditions.presenceOfElementLocated(By.id("account-creation_form")));

        accpage.setFirstName("412412");
        accpage.setLastName("4124125");
        accpage.setEmail("email@wrong");
        accpage.setPassword("1234");
        accpage.setPostalCode("abcd");
        accpage.setMobilePhone("abcd");
        accpage.setHomePhone("abcd");
        accpage.getRegisterButton().click();

        Assert.assertTrue(accpage.getFirstNameInvalidError().isDisplayed());
        Assert.assertTrue(accpage.getLastNameInvalidError().isDisplayed());
        Assert.assertTrue(accpage.getEmailInvalidError().isDisplayed());
        Assert.assertTrue(accpage.getPasswordInvalidError().isDisplayed());
        Assert.assertTrue(accpage.getPostalCodeError().isDisplayed());
        Assert.assertTrue(accpage.getMobilePhoneInvalidError().isDisplayed());
        Assert.assertTrue(accpage.getHomePhoneInvalidError().isDisplayed());
    }
    @Test(priority = 5)
    public void createAccount() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accForm.setCreateEmail("email45@gmail.com");
        accForm.getCreateAccButton().click();

        WebDriverWait waitForPageLoad = new WebDriverWait(driver, 20);
        waitForPageLoad.until(ExpectedConditions.presenceOfElementLocated(By.id("account-creation_form")));

        accpage.setTitleMr();
        accpage.setFirstName("John");
        accpage.setLastName("Doe");
        accpage.setEmail("jd@email.com");
        accpage.setPassword("johndoe123");
        accpage.setDateOfBirthDay("12");
        accpage.setDateOfBirthMonth("10");
        accpage.setDateOfBirthYear("1993");
        accpage.setCompany("Unknown");
        accpage.setAddressOne("Nowhere 1");
        accpage.setAddressTwo("Nowhere 2");
        accpage.setCity("Nowhere land");
        accpage.selectCountry("United States");
        accpage.selectState("5");
        accpage.setPostalCode("12345");
        accpage.setAdditionalInfo("I'm nobody.");
        accpage.setHomePhone("070123321");
        accpage.setMobilePhone("070321123");
        accpage.setAddressAlias("Pastnowhere 3");
        accpage.getRegisterButton().click();

        Assert.assertTrue(accpage.isLoginSuccessful());
    }
}
