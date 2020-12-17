
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;


public class LocatingWebElementsUsingWebDriver {


    public static void main(String[] args){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");

        WebDriver driver = new FirefoxDriver(); //WebDriver is an interface and can be instantiated by FirefoxDriver
        //FirefoxDriver driver = new FirefoxDriver(); //This also can be used

        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        /*
        Goto Firefox, keep the mouse on the search field and right click and click inspect and read the highlighted
        information.
         */

        searchBox.sendKeys("novels");
        searchBox.submit();

    }

}
