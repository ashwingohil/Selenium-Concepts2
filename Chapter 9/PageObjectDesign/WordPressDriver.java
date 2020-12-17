
package PageObjectDesign;


import WordPress.WordPressLogin_Annotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class WordPressDriver {

    String baseUrl = "https://wordpress.com/";
    WebDriver driver;
    String AfterLoginUrl;

    public void TriggerInitiation(){

        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        //WebDriver driver = new ChromeDriver();
        this.driver = driver;
        driver.get(baseUrl);
        String parentWindow = driver.getWindowHandle();

        WordPressLogin  object = PageFactory.initElements(driver,WordPressLogin.class);
        String currentUrl = object.Login(driver,parentWindow);
        AfterLoginUrl = currentUrl;
    }

    public void Initiate_CreateAPost(String title, String Description){

        AllPostsPage object = PageFactory.initElements(driver,AllPostsPage.class);
        object.createANewPost(title,Description);
        object.editAPost("qaz","qaz new random value");
        object.deleteAPost("qaz new random value");
        object.searchInPost("monjo");
    }



    public static void main(String[] args){


        WordPressDriver object = new WordPressDriver();
        object.TriggerInitiation();

        object.Initiate_CreateAPost("qaz","random value");
    }
}
