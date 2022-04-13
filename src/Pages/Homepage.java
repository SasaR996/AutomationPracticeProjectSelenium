package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {
    private WebDriver driver;
    public Homepage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getSignInButton(){
        return driver.findElement(By.xpath("//a[contains(text(), \"Sign in\")]"));
    }
}
