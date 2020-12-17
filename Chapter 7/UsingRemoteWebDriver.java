import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class UsingRemoteWebDriver {

    public static void main(String[] args) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        RemoteWebDriver remoteWD = null;
        capabilities.setBrowserName("chrome"); //on chrome it shows a session not with firefox
        try{
            remoteWD = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
            // /wd/hub is necessary
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }
        //Goto http://127.0.0.1:4444/wd/hub/static/resource/hub.html in chrome to see information
        //Only type till wd/hub and page should come
        remoteWD.get("https://www.google.com"); //This is not required. just for testing
        remoteWD.findElement(By.name("q")).sendKeys("Ebooks");

        //class defined information is File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = ((TakesScreenshot)remoteWD).getScreenshotAs(OutputType.FILE);
        System.out.println("Absolute path is: "+screenshotFile.getAbsolutePath());
        try{
            Thread.sleep(30000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        //The version of remoteWebDriver jar that i have has the screenshot implementation else read the book. augmenter
        //class is to be used
    }
}
