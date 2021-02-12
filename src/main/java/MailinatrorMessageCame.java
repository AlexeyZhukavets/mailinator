import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MailinatorMainPage;
import pages.MailinatorSearchResultPage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class MailinatrorMessageCame {

    private static String fromUser = "azhuk170988@gmail.com";
    private static String toUser = "azhuk170988@mailinator.com";

    public static void main(String... args) throws IOException, MessagingException {
        //Send message
        MimeMessage mimeMessage
                = GmailInteraction.createEmail(toUser, fromUser,"SUBJECT", "BODY0202020304" + new Date().getTime());
        GmailInteraction.sendMessage(fromUser, mimeMessage);

        //Checking that the letter came
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mailinator.com/");
        new MailinatorMainPage(driver).findMail("azhuk170988");
        MailinatorSearchResultPage mailinatorSearchResultPage = new MailinatorSearchResultPage(driver);
        mailinatorSearchResultPage.pageIsOpened();
        mailinatorSearchResultPage.openLastMessage();
        mailinatorSearchResultPage.getMessageBody();
    }

}
