package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class IamDriver {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        EventFiringWebDriver eventFiringDriver = new EventFiringWebDriver(driver);
        IamEventListener eventLister = new IamEventListener();

        eventFiringDriver.register(eventLister);

        eventFiringDriver.get("https://www.google.com/");
        eventFiringDriver.get("https://www.facebook.com/");
        eventFiringDriver.navigate().back();
        //In above line, observe that EventFiringWebDriver class api has many methods. One of them is navigate()
        //Now note that navigate returns object WebDriver.Navigation. Open this class api you will find method back()
        //So chain them

        //I have overriden lines on beforeChangeValueOf and afterChangeValueOf. This is invoked before WebElement
        //values change . Invoked when sendKeys and clear is executed on WebElement.

        eventFiringDriver.get("https://www.google.com/");
        WebElement searchBox = eventFiringDriver.findElement(By.name("q"));
        searchBox.sendKeys("hackthebox");
        searchBox.clear();

    }

}

/*
I create a Listener named IamEventListener which implements WebDriverEventListener (this is a class and methods are to
be overriden. Not all are required but the ones we use.
In This class main class IamDriver
Create a WebDriver object;
Create EventFiringWebDriver object and pass the webdriver object. EventFiringWebDriver is a pre class
Now instantiate out Listener class object which is IamEventListener
Use EventFiringWebDriver object to do things. Note the output
 */