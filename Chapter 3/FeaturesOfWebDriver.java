
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils; //This is important commons.io.jar is to be imported in project structure/dependencies


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class FeaturesOfWebDriver {

    String baseUrl = "https://www.google.com/";
    String baseUrl2 = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%203/Window.html";
    String baseUrl3 = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%203/Frames.html";

    public void SettingCapabilities() throws IOException {

        //This is important method. See how I have handled exception and see the main method too
        //class
        Map capabilitiesMap = new HashMap();
        capabilitiesMap.put("takesScreenShot",true);
        DesiredCapabilities capabilities = new DesiredCapabilities(capabilitiesMap);
        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get(baseUrl);

        //Very important. OutputType is a class. TakesScreenshot is also a class. you will have to understand
        try {

            //Below line is given in TakesScreenshot api class
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("/home/ashwin/Desktop/seleniumScreenshot");
            FileUtils.copyFile(screenshotFile, destFile);
            System.out.println(screenshotFile.getAbsolutePath());
            //The screenshot is deleted once it is taken in system temp folder once jvm is closed. So copy needed

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }


    public void WindowHandling() throws InterruptedException{

        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        //WebDriver driver = new ChromeDriver();
        driver.get(baseUrl2);

        //driver object of WebDriver has many methods
        String window1 = driver.getWindowHandle();
        System.out.println("Title of this parent window which opened is: "+driver.getTitle()); //not showing
        System.out.println("WindowHandle name is: "+driver.getWindowHandle());

        WebElement clickMe = driver.findElement(By.linkText("Google Search")); //imp By linkText
        clickMe.click();
        try {
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        String window2 = driver.getWindowHandle();
        System.out.println("Title of this child window which opened is: "+driver.getTitle()); //not showing
        System.out.println("Current WindowHandle is: "+driver.getWindowHandle());
        System.out.println("Total WindowHandles are: "+driver.getWindowHandles().size());

        driver.switchTo().window(window1);
        driver.switchTo().window(window2);

        //I dont get different values of the windowHandles

    }

    public void SwitchingBetweenFrames(){

        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl3);

        //driver.switchTo() driver object that is WebDriver class has method switchTo() . The return is
        //WebDriver.TargetLocator Open this interface in api you will see method frame() 3 overloaded methods. Each method
        //will return WebDriver object. so switchTo() returns TargetLocator object (Interface). Chain it with methods
        //in TargetLocator to produce return as WebDriver object. driver is WebDriver object.
        //Frames are indexed as 0,1,2 and so on

        driver.switchTo().frame(0);
        WebElement textBox1 = driver.findElement(By.name("1"));
        textBox1.sendKeys("Hello World");

        //Switching to method defaultContent() is necessary to make a switch else it will not be able to find frame index
        driver.switchTo().defaultContent();
        //Now hopping to frame 1 that is second frame
        driver.switchTo().frame(1);
        WebElement textBox2 = driver.findElement(By.name("2"));
        textBox2.sendKeys("See you World");

        //Now lets try other frame method. overloaded.
        driver.switchTo().defaultContent(); //this is again necessary
        driver.switchTo().frame("frameOne"); //inspect and find the attribute of frame
        textBox1.sendKeys("Overloaded method try");

    }

    public static void main(String[] args){

        FeaturesOfWebDriver object = new FeaturesOfWebDriver();

        /*
        try {
            object.SettingCapabilities();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        */

        /*
        try {
            object.WindowHandling();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        */

        object.SwitchingBetweenFrames();
    }
}
