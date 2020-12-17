
package CookieExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.By;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CookieRead {

    String baseUrl = "http://demo.guru99.com/test/cookie/selenium_aut.php";

    public void ReadTheCookie(){

        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("abc123");
        password.sendKeys("123xyz");
        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();

        //Once you have logged in. Try clear all cookies from firefox preferences else it stays logged in


        File file = new File("Cookies.data");
        try{
            //delete old file if exists
            file.delete();
            file.createNewFile();
            FileWriter fwrite = new FileWriter(file);
            BufferedWriter bwrite = new BufferedWriter(fwrite);

            for(Cookie ck : driver.manage().getCookies()){
                bwrite.write(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
                bwrite.newLine();
                //this above is how it is. we are using write(String) method
            }

            bwrite.close();
            fwrite.close();


        }catch(IOException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){

        CookieRead object = new CookieRead();
        object.ReadTheCookie();
    }

}
