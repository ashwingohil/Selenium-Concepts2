
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CheckingPrintOfWebElement {




    public static void main(String[] args){

        String baseUrl = "https://www.google.com/";

        //System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement searchBox = driver.findElement(By.name("q")); //Yes it prints the WebElement
        System.out.println(searchBox);
    }

}
