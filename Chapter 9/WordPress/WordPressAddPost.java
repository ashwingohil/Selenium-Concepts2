package WordPress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

public class WordPressAddPost {

    String baseUrl = "https://wordpress.com/";

    public void AddPost(){


        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);
        String parentWindow = driver.getWindowHandle();

        WordPressLogin object = new WordPressLogin();
        object.Login(driver, parentWindow);

        WebElement clickSite = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/ul/li/div[2]/ul[2]/li[1]/h2/span"));
        clickSite.click();
        WebElement clickPosts = driver.findElement(By.xpath("//span[@class='sidebar__menu-link-text menu-link-text'][contains(text(),'Posts')]"));
        clickPosts.click();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        WebElement addNewPost = driver.findElement(By.xpath("//a[@class='button post-type-list__add-post is-compact is-primary']"));
        addNewPost.click();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        driver.get("https://pwnmojo.wordpress.com/wp-admin/post-new.php?calypsoify=1&block-editor=1&frame-nonce=2efcab0d7b&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user&_support_token");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebElement writeTitle = driver.findElement(By.xpath("//*[@id=\"post-title-0\"]"));
        writeTitle.sendKeys("Hello world");

        WebElement PublishPost = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[1]/div[1]/div/div[3]/button[2]"));
        PublishPost.click();
        WebElement PublishPost2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/div/div[1]/div[1]/button"));
        PublishPost2.click();


    }

    public static void main(String[] args){
        WordPressAddPost object = new WordPressAddPost();
        object.AddPost();
    }
}
