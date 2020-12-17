import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class LocatingWebElementsUsingWebDriver1 {

    public void VariousMethodsOfWebDriver(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com");
        String currentUrl = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();
        String windowHandle = driver.getWindowHandle();

        System.out.println("Current URL is: "+currentUrl);
        System.out.println("Current Title is:"+currentTitle);
        System.out.println("Current Window Handle:"+windowHandle);


        List<WebElement> elementList = driver.findElements(By.name("q"));

        for(int i=0; i < elementList.size(); i++){
            System.out.println(elementList.get(i));
        }

        WebElement toClick = driver.findElement(By.name("btnI"));
        toClick.click();
        System.out.println("I am feeling lucky clicked");

        driver.close();

    }


    public static void main(String[] args){

        LocatingWebElementsUsingWebDriver1 object = new LocatingWebElementsUsingWebDriver1();
        object.VariousMethodsOfWebDriver();
    }
}
