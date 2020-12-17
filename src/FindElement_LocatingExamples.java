
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElement_LocatingExamples {


    String baseUrl = "https://www.google.com";
    String baseUrl2 = "http://demo.guru99.com/test/newtours/"; //This works with WebElement click method
    String baseUrl3 = "http://demo.guru99.com/test/facebook.html";
    String baseUrl4 = "https://www.testandquiz.com/selenium/testing.html";


    public void ByName(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        driver.get(baseUrl2);

        //WebElement byname = driver.findElement(By.name("btnI"));
        WebElement byname = driver.findElement(By.name("submit"));
        byname.click();

        driver.close();
    }


    public void ById(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl3);

        WebElement byId = driver.findElement(By.id("email")); //Inspect the email or phone box in firfox. right click
        byId.sendKeys("ashwin@gmail.com");

        driver.close();

    }

    public void ByTagName(){

        //This is different. Visit baseUrl4 and see that there is only 1 text box. So tagname is "input"
        //Here it is unique. Otherwise it can return zero or more results.
        //Tag here is <input . This string input is the tag
        //Similarly for baseUrl4 Button Submit as shown has tag <button

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl4);
        WebElement byTagName = driver.findElement(By.tagName("input"));
        byTagName.sendKeys("hello");

        WebElement byTagName2 = driver.findElement(By.tagName("button"));
        byTagName2.click();

        driver.close();

        //Note: I cannot use driver.findElement again on WebElement byTagName. Have to declare another
        //WebElement for next action like clicking button

    }


    public void ByClassName(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        WebElement byClassName = driver.findElement(By.className("gLFyf"));
        byClassName.sendKeys("hellow");

        driver.close();

        //Here, I opened baseurl. Click on searchbox and see there is <input class=" . On the right hand side
        //of inspect element you will see 2 nodes which are class (css) with the names mentioned in <input class=
        //Just put the first name found in the tag <input of the two strings seperated by space. No need to put
        // the whole thing. Both the values do not produce any output
    }


    public void ByLinkText(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        WebElement byLinkText = driver.findElement(By.linkText("About"));
        byLinkText.click();
    }


    public static void main(String[] args){

        FindElement_LocatingExamples object = new FindElement_LocatingExamples();
        //object.ByName();
        //object.ById();
        //object.ByTagName();
        //object.ByClassName();
        object.ByLinkText();

    }

}
