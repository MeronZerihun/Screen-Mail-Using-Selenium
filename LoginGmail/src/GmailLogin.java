import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GmailLogin {
    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 50);

        // Open gmail web site
        String appUrl = "http://www.gmail.com";
        driver.get(appUrl);

        // Login to gmail
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("meron393demissie@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span")).click();
        Thread.sleep(4000);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("merry2210");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
        Thread.sleep(5000);

        // Get all unread emails
        List<WebElement> unread = driver.findElements(By.className("zE"));
        System.out.println("You have "+unread.size()+ " unread messages.\n" );
        System.out.println("------------------------------------------------------------------------------------------");
        for (WebElement email: unread) {

            // Get the sender's name
            WebElement sender = email.findElement(By.className("zF"));
            String senderName = sender.getAttribute("name");
            Thread.sleep(10);

            // Get the mail's subject
            List<WebElement> detail = email.findElements(By.className("bqe"));
            String subject = detail.get(1).getText();
            Thread.sleep(10);

            System.out.println("Sent by: " + senderName + "\tSubject: " + subject);
            System.out.println("------------------------------------------------------------------------------------------");

        }
        driver.close();
    }
}
