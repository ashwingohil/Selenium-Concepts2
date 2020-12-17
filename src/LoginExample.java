import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginExample {

    public static void main(String[] args){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();

        //opening the page of login
        String baseUrl = "http://demo.guru99.com/test/login.html";
        driver.get(baseUrl);

        //Now catching web elements in login field and stuffing input with sendKeys
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("abcd@gmail.com");

        //Now catching web elements in password field and stuffing input with sendKeys
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("abcdefghijkl");

        System.out.println("Text field set");

        //Just checking out if we can clear the fields with clear() method of WebElement
        email.clear();
        password.clear();
        System.out.println("Text field cleared");

        //Now stuffing the fields in the text boxes and using click() method

        email.sendKeys("abcd@gmail.com"); //email instance or object is still alive. we used with sendkeys and clear methods
        password.sendKeys("abcdefghijkl");

       WebElement login = driver.findElement(By.id("SubmitLogin"));
       login.click();
       System.out.println("Login done with click");

        //Now chaining methods and using sendKeys methods
        //driver object is still alive and email and password objects are also alive

        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        driver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Done with Submit");

        //driver.findElement throws return as WebElement . This is chained and we use sendKeys method
        //which is invoked by the WebElement object that is "email" and "password"


        //driver.close();

    }


}
