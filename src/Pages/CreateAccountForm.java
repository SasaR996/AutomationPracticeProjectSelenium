package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountForm {
    private WebDriver driver;

    public CreateAccountForm(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getCreateForm(){
        return driver.findElement(By.id("create-account_form"));
    }
    public WebElement getFormEmailField(){
        return driver.findElement(By.id("email_create"));
    }
    public WebElement getCreateAccButton(){
        return driver.findElement(By.xpath("//button[@id=\"SubmitCreate\"]"));
    }
    public WebElement getInvalidEmailError(){
        return driver.findElement(By.xpath("//li[contains(text(), \"Invalid email address.\")]"));
    }
    public WebElement getEmailRegisteredError(){
        return driver.findElement(By.xpath("//li[contains(text(), \"An account using this email\")]"));
    }
    public WebElement getEmailHighlightRed(){
        return driver.findElement(By.xpath("//div[@class=\"form-group form-error\"]"));
    }
    public WebElement getEmailHighlightGreen(){
        return driver.findElement(By.xpath("//div[@class=\"form-group form-ok\"]"));
    }

    public void setCreateEmail(String email){
        WebElement emailField = this.getFormEmailField();
        emailField.clear();
        emailField.sendKeys(email);
    }

    //Errors
    public WebElement getCreateEmailHighlightRed(){
        return driver.findElement(By.xpath("//div[@class=\"form-group form-error\"]"));
    }
    public WebElement getCreateEmailHighlightGreen(){
        return driver.findElement(By.xpath("//div[@class=\"form-group form-ok\"]"));
    }
    public WebElement getCreateEmailError(){
        return driver.findElement(By.xpath("//li[contains(text(), \"Invalid email address.\")]"));
    }
    public WebElement getCreateEmailRegisteredError(){
        return driver.findElement(By.xpath("//li[contains(text(), \"An account using this email\")]"));
    }
}
