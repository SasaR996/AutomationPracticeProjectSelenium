package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
    private WebDriver driver;

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("logout"));
    }
    public WebElement getLoginButton(){
       return driver.findElement(By.id("SubmitLogin"));
    }
    public WebElement getEmailInput(){
     return driver.findElement(By.id("email"));
    }
    public WebElement getPassInput(){
        return driver.findElement(By.id("passwd"));
    }
    public WebElement getAuthError(){ return driver.findElement(By.xpath("//li[contains(text(), \"Authentication failed.\")]")); }
    public WebElement getBlankPassError(){ return driver.findElement(By.xpath("//li[contains(text(), \"Password is required.\")]")); }
    public WebElement getBlankEmailError(){ return driver.findElement(By.xpath("//li[contains(text(), \"An email address required.\")]")); }
    public WebElement getInvalidPassError(){ return driver.findElement(By.xpath("//li[contains(text(), \"Invalid password\")]")); }
    public WebElement getInvalidMailError(){ return driver.findElement(By.xpath( "//li[contains(text(), \"Invalid email address.\")]")); }

    public SignInPage(WebDriver driver){
    this.driver = driver;
    }

    public void clickLogin(){
       WebElement loginButton = this.getLoginButton();
        loginButton.click();
    }
    public void setEmail(String mail){
        WebElement email = this.getEmailInput();
        email.clear();
        email.sendKeys(mail);
    }
    public void setPass(String pass){
        WebElement password = this.getPassInput();
        password.clear();
        password.sendKeys(pass);
    }
    public void signOut(){
        WebElement logout = this.getLogoutButton();
        logout.click();
    }

    public boolean emailHighlightRed(){
        WebElement emailHighlightRed = driver.findElement(By.xpath("//div[@class=\"form-group form-error\"]//input[@id=\"email\"]"));
        return emailHighlightRed.isDisplayed();
    }
    public boolean emailHighlightGreen(){
        WebElement emailHighlightGreen = driver.findElement(By.xpath("//div[@class=\"form-group form-ok\"]//input[@id=\"email\"]"));
        return emailHighlightGreen.isDisplayed();
    }

}
