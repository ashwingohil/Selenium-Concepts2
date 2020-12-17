import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyTabStatus {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");

        // Locating Women tab
        //WebElement tabWomen = driver.findElement(By.xpath("//a[@title='Women']/.."));
        //body[@id='category']
        WebElement tabWomen = driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"));

        // CLicking on Women tab
        tabWomen.click();

        // Relocating otherwise it will give StaleElementException
        tabWomen = driver.findElement(By.xpath("//a[@title='Women']/.."));

        // If we use isSelected() or isEnabled() method on it
        System.out.println("===========Verifying using isEnabled and isSelected method===========");
        System.out.println("Women Tab status as per isEnabled() method when it is selected: " + tabWomen.isEnabled());
        System.out.println("Women Tab status as per isSelected() method when it is selected:: " + tabWomen.isSelected());


        /*
        // Click on another tab Dresses
        driver.findElement(By.xpath("(//a[@title='Dresses']/..)[2]")).click();
        Thread.sleep(15000);

        // Relocating Home tab
        tabWomen = driver.findElement(By.xpath("//a[@title='Women']/.."));

        // If we use isSelected() or isEnabled() method on it again. You will see there is no change. So it is not correct way of validation.
        System.out.println("Home Tab status as per isEnabled() method when it is not selected: " + tabWomen.isEnabled());
        System.out.println("Home Tab status as per isSelected() method when it is not selected:: " + tabWomen.isSelected());

        // Above code does not validate what actually we want to do
        System.out.println("==============Verify using attributes=======================================");

        driver.get("http://automationpractice.com/");
        // Locating Women tab
        tabWomen = driver.findElement(By.xpath("//a[@title='Women']/.."));

        // CLicking on Women tab
        tabWomen.click();

        // Relocating otherwise it will give StaleElementException
        tabWomen = driver.findElement(By.xpath("//a[@title='Women']/.."));

        // Retrieving value of class attribute
        String classValue = tabWomen.getAttribute("class");
        if (classValue.contains("sfHoverForce"))
            System.out.println("Women tab is currently selected.");

        // Click on another tab Dresses
        driver.findElement(By.xpath("(//a[@title='Dresses']/..)[2]")).click();
        Thread.sleep(15000);

        // Relocating Home tab
        tabWomen = driver.findElement(By.xpath("//a[@title='Women']/.."));

        // Retrieving value of class attribute
        String classValueAfter = tabWomen.getAttribute("class");
        if (!(classValueAfter.contains("sfHoverForce")))
            System.out.println("Women tab is currently not selected.");

        */

        driver.quit();

    }

}