package CookieExample;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;


public class CookieWrite {

    String baseUrl = "http://demo.guru99.com/test/cookie/selenium_aut.php";

    public void WriteTheCookie(){

        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        //before i do driver.get() we have to load the cookie


        try{
            File file = new File("Cookies.data");
            FileReader fread = new FileReader(file);
            BufferedReader bread = new BufferedReader(fread);

            String stringline;
            while((stringline=bread.readLine())!= null){
                StringTokenizer token = new StringTokenizer(stringline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if(!(val= token.nextToken()).equals("null")){
                        expiry = new Date(val);
                    }

                    Boolean isSecure = new Boolean(token.nextToken());
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    System.out.println(ck);
                    driver.manage().addCookie(ck);
                }
            }

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }

        driver.get(baseUrl);
    }


    public static void main(String[] args){

        CookieWrite object = new CookieWrite();
        object.WriteTheCookie();
    }
}
