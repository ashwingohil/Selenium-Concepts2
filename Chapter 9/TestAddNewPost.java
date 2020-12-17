
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class TestAddNewPost {

    String baseUrl = "https://wordpress.com/";
    private Object ExpectedConditions;

    public void LoginIntoWordpress(){

        //System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);
        String parentWindow = driver.getWindowHandle();

        WebElement LoginButton = driver.findElement(By.xpath("//a[@class='x-nav-link x-link'][contains(text(),'Log In')]"));
        LoginButton.click();

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        WebDriverWait wait = new WebDriverWait(driver,3);
        Function<WebDriver,Boolean> function = new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver1) {
                WebElement element = driver1.findElement(By.xpath("//span[contains(text(),'Continue with Google')]"));
                try {
                    element.click();
                }catch(StaleElementReferenceException ex){
                    return false;
                }
                return true;
            }

        };

        wait.until(function);
        System.out.println(driver.getWindowHandles());
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iteratorHandles = windows.iterator();
        int i=0;
        for(String handle : windows){
           System.out.println("Handle-" + i + " id is: " + handle);
           i++;
        }

        while(iteratorHandles.hasNext()){
            String childWindow = iteratorHandles.next();
            if(!parentWindow.equals(childWindow)){
                //driver.switchTo().window(childWindow);
                System.out.println("Child Window title is: "+driver.switchTo().window(childWindow).getTitle());
                driver.switchTo().window(childWindow);
                WebDriverWait wait1 = new WebDriverWait(driver,3);
                Function<WebDriver,Boolean> function1 = new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver1) {
                        WebElement element = driver1.findElement(By.xpath("//*[@id=\"identifierId\"]"));
                        return true;
                    }

                };
                wait1.until(function1);
                WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
                email.sendKeys("ashwin.k.gohil@gmail.com");
                WebElement next = driver.findElement(By.className("VfPpkd-RLmnJb"));
                next.click();

                try{
                    Thread.sleep(3000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                //This time Function object wait did not work

                WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
                password.sendKeys("passwordToType");
                WebElement nextButton = driver.findElement(By.xpath("//div[@id='passwordNext']//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']//button[@type='button']//div[@class='VfPpkd-RLmnJb']"));
                nextButton.click();
            }
        }

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("Parent window title is: "+driver.switchTo().window(parentWindow).getTitle());



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

        //driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")));
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

    }

    public static void main(String[] args){

        TestAddNewPost object = new TestAddNewPost();
        object.LoginIntoWordpress();
    }
}
