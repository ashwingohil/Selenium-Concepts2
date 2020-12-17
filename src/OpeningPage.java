import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpeningPage {

    public static void main(String[] args){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
    }
}
