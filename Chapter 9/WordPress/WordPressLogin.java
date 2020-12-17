package WordPress;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class WordPressLogin {

    WebDriver driver;
    WebElement LoginButton;

    public void Login(WebDriver driver, String parentWindow){

        this.driver = driver;

        LoginButton = driver.findElement(By.xpath("//a[@class='x-nav-link x-link'][contains(text(),'Log In')]"));
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
                password.sendKeys("havepatience2082");
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

    }


}
