package WordPress;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


//Its working. 
public class WordPressAddPost_Annotation {

    String baseUrl = "https://wordpress.com/";

    public void triggerLogin(){

        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);
        String parentWindow = driver.getWindowHandle();

        WordPressLogin_Annotation object = PageFactory.initElements(driver,WordPressLogin_Annotation.class);
        object.Login(driver,parentWindow);




    }


    public static void main(String[] args){

        WordPressAddPost_Annotation object = new WordPressAddPost_Annotation();
        object.triggerLogin();

    }
}
