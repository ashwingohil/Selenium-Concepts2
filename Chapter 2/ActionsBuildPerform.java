import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;


public class ActionsBuildPerform {



    public static void main(String[] args) {

        //The program does not work as intended with Firefox but works with Chrome

        String baseUrl = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%202/Selectable.html";
        //System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        driver.get(baseUrl);

        WebElement eight = driver.findElement(By.name("eight"));
        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));

        //Now instantiating object of Actions
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click(one).click(eight).click(three).keyUp(Keys.CONTROL);
        //This above action is not performing

        //Now instantiating object of Action
        //Action compositeAction = builder.build();
        //compositeAction.perform();

        builder.perform(); // or you can user this directly

        //driver.close();


    }

}
