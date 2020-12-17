import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Point;

public class MoveByOffset {

    public static void main(String[] args){

        //This prog works in Chrome

        String baseUrl = "file:///home/ashwin/IdeaProjects/Selenium/Chapter%202/Selectable.html";
        //System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement three = driver.findElement(By.name("three"));
        System.out.println("Xoffset and Yoffset by method getLocation() in pixels is: "+three.getLocation());

        //Above is a print statement but getLocation() throws a Point object which contains x and y values in integers
        //How to see the pixel information which getLocation() throws. Open Inspect Element(Firefox). On the right corner just
        //next to cross(close) button there is three dot icon. Click it and click settings. Then on far left among the
        //option select the "measure the portion of the page" option. An icon will appear on the same line of cross(close)
        // and three dots icon.

        int x,y;
        x = three.getLocation().getX();
        y = three.getLocation().getY();
        System.out.println("X and Y are: "+x+ ","+y);

        Actions builder = new Actions(driver);
        //builder.moveByOffset(three.getLocation().getX()+1, three.getLocation().getY()+1).click();
        builder.moveByOffset(three.getLocation().getX()+105, three.getLocation().getY()+1).click();

        //Note in above where value is 105. How do we get it and how I see it in actual as clicking on 4th tile from 3rd
        //From Firefox, use "measure the portion of the page). Not the pixel on the start of 4th tile. here 317 , 11
        //So I have to subtract 212 (3rd tile x pixel) from 317. Whatever is the remainder is 105. That is put above
        //and hence we can see clicking on 4th tile. Otherwise directly adding +317 would go out of region.


        /*
        Now lets try to move at different tiles. After tile4 lets move at 8. Refer mouse positions as above
        */
        builder.moveByOffset(0,87).click();
        /*
        What is happening here . earlier point of click was 317,9. X axis is maintaining at 317 so difference is 0
        But y is changing to 96. So subtract 96-9 . This is the value. So it hops on new position
        Remember we first got the location for x and y and now we are just hopping from last point
         */

        builder.perform();



    }
}
