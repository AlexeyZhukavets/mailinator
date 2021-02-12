package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MailinatorSearchResultPage {

    private WebDriver driver;
    private final static Logger logger = LoggerFactory.getLogger(MailinatorSearchResultPage.class);

    public MailinatorSearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean pageIsOpened(){
        WebElement searchField = null;
        try{
            searchField = driver.findElement(By.xpath("//*[@id=\"inbox_field\"]"));
        }catch (Exception exception){
            logger.error("Mailinator search result page is not opened");
        }
        return searchField != null;
    }

    public void openLastMessage(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.textToBe(By.xpath("//table/tbody/tr[1]/td[4]"), "just now"));
        driver.findElement(By.xpath("/html/body/div/main/div[2]/div[3]/div/div[4]/div/div/table/tbody/tr[1]/td[2]")).click();
    }

}
