package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateAccountPage {
    private WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAccountCreationForm() {
        return driver.findElement(By.id("account-creation_form"));
    }

    public WebElement getTitleMr() {
        return driver.findElement(By.id("id_gender1"));
    }

    public WebElement getTitleMrs() {
        return driver.findElement(By.id("id_gender2"));
    }

    public WebElement getFirstNameField() {
        return driver.findElement(By.id("customer_firstname"));
    }

    public WebElement getLastNameField() {
        return driver.findElement(By.id("customer_lastname"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("passwd"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }

    public Select selectDateOfBirthDay() {
        WebElement dayOfBirth = driver.findElement(By.id("days"));
        return new Select(dayOfBirth);
    }

    public Select selectDateOfBirthMonth() {
        WebElement monthOfBirth = driver.findElement(By.id("months"));
        return new Select(monthOfBirth);
    }

    public Select selectDateOfBirthYear() {
        WebElement yearOfBirth = driver.findElement(By.id("years"));
        return new Select(yearOfBirth);
    }

    public WebElement getCompanyField() {
        return driver.findElement(By.id("company"));
    }

    public WebElement getAddressFirstName() {
        return driver.findElement(By.id("firstname"));
    }

    public WebElement getAddressLastName() {
        return driver.findElement(By.id("lastname"));
    }

    public WebElement getAddressFieldOne() {
        return driver.findElement(By.id("address1"));
    }

    public WebElement getAddressFieldTwo() {
        return driver.findElement(By.id("address2"));
    }

    public WebElement getCityField() {
        return driver.findElement(By.id("city"));
    }

    public Select selectCountry() {
        WebElement selectCountry = driver.findElement(By.id("id_country"));
        return new Select(selectCountry);
    }

    public Select selectState() {
        WebElement selectState = driver.findElement(By.id("id_state"));
        return new Select(selectState);
    }

    public WebElement getPostalCode() {
        return driver.findElement(By.id("postcode"));
    }

    public WebElement getAdditionalInfo() {
        return driver.findElement(By.id("other"));
    }

    public WebElement getHomePhone() {
        return driver.findElement(By.id("phone"));
    }

    public WebElement getMobilePhone() {
        return driver.findElement(By.id("phone_mobile"));
    }

    public WebElement getAddressAlias() {
        return driver.findElement(By.id("alias"));
    }

    public WebElement getRegisterButton() {
        return driver.findElement(By.id("submitAccount"));
    }

    //--------------------------------------------------------------

    public void setTitleMr() {
        this.getTitleMr().click();
    }

    public void setTitleMrs() {
        this.getTitleMrs().click();
    }

    public void setFirstName(String firstName) {
        WebElement firstNameField = this.getFirstNameField();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement lastNameField = this.getLastNameField();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setEmail(String email) {
        WebElement emailField = this.getEmailField();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setPassword(String pass) {
        WebElement passField = this.getPasswordField();
        passField.clear();
        passField.sendKeys(pass);
    }

    public void setDateOfBirthDay(String day) {
        Select dayOfBirth = this.selectDateOfBirthDay();
        dayOfBirth.selectByValue(day);
    }

    public void setDateOfBirthMonth(String month) {
        Select monthOfBirth = this.selectDateOfBirthMonth();
        monthOfBirth.selectByValue(month);
    }

    public void setDateOfBirthYear(String year) {
        Select yearOfBirth = this.selectDateOfBirthYear();
        yearOfBirth.selectByValue(year);
    }

    public void setCompany(String company) {
        WebElement companyField = this.getCompanyField();
        companyField.clear();
        companyField.sendKeys(company);
    }

    public void setAddressOne(String addressOne) {
        WebElement addressFieldOne = this.getAddressFieldOne();
        addressFieldOne.clear();
        addressFieldOne.sendKeys(addressOne);
    }

    public void setAddressTwo(String addressTwo) {
        WebElement addressFieldTwo = this.getAddressFieldTwo();
        addressFieldTwo.clear();
        addressFieldTwo.sendKeys(addressTwo);
    }

    public void setCity(String city) {
        WebElement cityField = this.getCityField();
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void selectState(String state) {
        Select stateSelect = this.selectState();
        stateSelect.selectByValue(state);
    }

    public void setPostalCode(String postCode) {
        WebElement postalCode = this.getPostalCode();
        postalCode.clear();
        postalCode.sendKeys(postCode);
    }

    public void selectCountry(String country) {
        Select selectCountry = this.selectCountry();
        selectCountry.selectByVisibleText(country);
    }

    public void setAdditionalInfo(String info) {
        WebElement additionalInfo = this.getAdditionalInfo();
        additionalInfo.clear();
        additionalInfo.sendKeys(info);
    }

    public void setHomePhone(String homePhone) {
        WebElement hPhone = this.getHomePhone();
        hPhone.clear();
        hPhone.sendKeys(homePhone);
    }

    public void setMobilePhone(String mobilePhone) {
        WebElement mPhone = this.getMobilePhone();
        mPhone.clear();
        mPhone.sendKeys(mobilePhone);
    }

    public void setAddressAlias(String alias) {
        WebElement addressAlias = this.getAddressAlias();
        addressAlias.clear();
        addressAlias.sendKeys(alias);
    }

    public WebElement getLoginSuccessInfo() {
        return driver.findElement(By.xpath("//p[contains(text(), \"Welcome to your account.\")]"));
    }

    public boolean isLoginSuccessful() {
        WebElement accountSuccess = this.getLoginSuccessInfo();
        return accountSuccess.isDisplayed();
    }
//-------------------------------------------------------------------------------------------------------
    //Errors

    public WebElement getErrorPanel() {
        return driver.findElement(By.xpath("//li[contains(text(), \"You must register\")]/../.."));
    }

    public WebElement getNoPhoneNumberError() {
        return driver.findElement(By.xpath("//li[contains(text(), \"You must register at least one phone number.\")]"));
    }

    public WebElement getHomePhoneInvalidError() {
        return driver.findElement(By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"phone\")]"));
    }

    public WebElement getMobilePhoneInvalidError() {
        return driver.findElement(By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"phone_mobile\")]"));
    }
    public WebElement getLastNameError(){
        return driver.findElement(By.xpath("//b[contains(text(), \"lastname\")]"));
    }
    public WebElement getLastNameInvalidError(){
        return driver.findElement(By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"lastname\")]"));
    }
    public WebElement getFirstNameError(){
        return driver.findElement(By.xpath("//b[contains(text(), \"firstname\")]"));
    }
    public WebElement getFirstNameInvalidError(){
        return driver.findElement(By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"firstname\")]"));
    }
    public WebElement getEmailRequiredError(){
        return driver.findElement(By.xpath("//b[contains(text(), \"lastname\")]"));
    }
    public WebElement getEmailInvalidError(){
        return driver.findElement(By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"email\")]"));
    }
    public WebElement getEmailAlreadyRegisteredError(){
        return driver.findElement(By.xpath("//li[contains(text(), \"An account using this\")]"));
    }
    public WebElement getPasswordRequiredError(){
        return driver.findElement(By.xpath("//b[contains(text(), \"passwd\")]"));
    }
    public WebElement getPasswordInvalidError(){
        return driver.findElement(By.xpath("//li[contains(text(), \" is invalid.\")]/b[contains(text(), \"passwd\")]"));
    }
    public WebElement getCountryRequiredError(){
        return driver.findElement(By.xpath("//b[contains(text(), \"id_country\")]"));
    }
    public WebElement getAddressAliasRequiredError(){
        return driver.findElement(By.xpath("//b[contains(text(), \"alias\")]"));
    }
    public WebElement getAddressRequiredError(){
        return driver.findElement(By.xpath("//b[contains(text(), \"address1\")]"));
    }
    public WebElement getCityRequiredError(){
        return driver.findElement(By.xpath("//b[contains(text(), \"city\")]"));
    }
    public WebElement getStateRequiredError(){
        return driver.findElement(By.xpath("//li[contains(text(), \"This country requires you to choose a State.\")]"));
    }
    public WebElement getPostalCodeError(){
        return driver.findElement(By.xpath("//li[contains(text(), \"The Zip/Postal code you\")]"));
    }
//--------------------------------------------------------------------------------------------------------------------
//Highlights
    public WebElement getFirstNameHighlightGreen(){
        return driver.findElement(By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_firstname\"]"));
    }
    public WebElement getFirstNameHighlightRed(){
        return driver.findElement(By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_firstname\"]"));
    }
    public WebElement getLastNameHighlightGreen(){
        return driver.findElement(By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"customer_lastname\"]"));
    }
    public WebElement getLastNameHighlightRed(){
        return driver.findElement(By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"customer_lastname\"]"));
    }
    public WebElement getEmailHighlightGreen(){
        return driver.findElement(By.xpath("//div[@class=\"required form-group form-ok\"]//input[@id=\"email\"]"));
    }
    public WebElement getEmailHighlightRed(){
        return driver.findElement(By.xpath("//div[@class=\"required form-group form-error\"]//input[@id=\"email\"]"));
    }
    public WebElement getPasswordHighlightGreen(){
        return driver.findElement(By.xpath("//div[@class=\"required password form-group form-ok\"]//input[@id=\"passwd\"]"));
    }
    public WebElement getPasswordHighlightRed(){
        return driver.findElement(By.xpath("//div[@class=\"required password form-group form-error\"]//input[@id=\"passwd\"]"));
    }
}