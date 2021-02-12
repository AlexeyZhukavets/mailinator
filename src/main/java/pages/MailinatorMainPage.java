package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailinatorMainPage {

    WebDriver driver;

    public MailinatorMainPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getSearchField(){
        return driver.findElement(By.xpath("//*[@id=\"addOverlay\"]"));
    }

    public void findMail(String searchQuery){
        getSearchField().sendKeys(searchQuery + "\n");
    }

}
