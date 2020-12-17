package PageObjectDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class WordPressLogin {

    WebDriver driver;
    @FindBy(how = How.XPATH, xpath = "//a[@class='x-nav-link x-link'][contains(text(),'Log In')]")
    WebElement LoginButton;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"identifierId\"]")
    WebElement email;
    @FindBy(how = How.CLASS_NAME, className =  "VfPpkd-RLmnJb")
    WebElement next;
    @FindBy(how = How.XPATH, xpath = "//input[@type='password']")
    WebElement password;
    @FindBy(how = How.XPATH, xpath = "//div[@id='passwordNext']//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']//button[@type='button']//div[@class='VfPpkd-RLmnJb']")
    WebElement nextButton;

    public WordPressLogin(WebDriver driver){

        this.driver = driver;
        //driver.get("https://wordpress.com/");
    }



    public String Login(WebDriver driver, String parentWindow){

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
                System.out.println(driver.getWindowHandles());
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }

                //WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
                email.sendKeys("ashwin.k.gohil@gmail.com");
                next.click();

                try{
                    Thread.sleep(3000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                //This time Function object wait did not work


                password.sendKeys("passwordToType");
                nextButton.click();
            }
        }

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        String afterLoginUrl = driver.switchTo().window(parentWindow).getCurrentUrl();
        System.out.println("Parent window title is: "+driver.switchTo().window(parentWindow).getTitle());
        return afterLoginUrl;

    }


}
