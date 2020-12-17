import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.Point;

public class ActionsOnWebElement {

    String baseUrl = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%202/Selectable.html";
    String baseUrl2 = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%202/Sortable.html";
    String baseUrl3 = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%202/DragMe.html";
    String baseUrl4 = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%202/DragAndDrop.html";
    String baseUrl5 = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%202/DoubleClick.html";
    String baseUrl6 = "file:///home/ashwin/IdeaProjects/Selenium%20Concepts2/Chapter%202/ContextClick.html";


    public void ClickOnWebElement(){

        //System.setProperty("webdriver.gecko.driver", "/home/ashwin/Desktop/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement one = driver.findElement(By.xpath("//body/ol[@id='selectable']/li[1]"));
        //WebElement one = driver.findElement(By.name("one"));
        //Both the loaded webelement will work. xpath and name

        Actions builder = new Actions(driver);
        builder.click(one); //here
        //builder.build().perform(); //This will also work
        builder.perform(); //This will also work. the direct form as mentioned in Actions class

        WebElement eight = driver.findElement(By.name("eight"));
        eight.click();

        /*
        Note the difference : WebElement is loaded and can be directly used by this object to call click()
        But when Actions object is used , click method with Webelement parameter is used. The no parameter version clicks
        on the mouse position
        */


        /*
        Now as we see click() is used by WebElement object. Lets try to use click with Actions object without the parament
        version of click()
         */
        int x = eight.getLocation().getX();
        int y = eight.getLocation().getY();

        System.out.println("x and y is: "+x+" "+y);
        /*
        We got 314 90. So now to click on 12. calculate. move the mouse and see the position and add subtract from x y
        So I move the mouse on tile 12 and set a position 314 182. so 182-90 = 92 which is y i need
         */

        builder.moveByOffset(eight.getLocation().getX()+0, eight.getLocation().getY()+90);
        builder.click(); //Here
        builder.perform();

        //Now chaining clicks
        WebElement two = driver.findElement(By.name("two"));
        WebElement seven = driver.findElement(By.name("seven"));
        WebElement nine = driver.findElement(By.name("nine"));
        builder.click(one).click(seven).click(nine);
        builder.build().perform();
    }


    public void ClickAndHold(){

        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl2);

        Actions builder = new Actions(driver);

        /*
        Now inspect the element and get to know the mouse position and know the position of the tile3 with mouse postion
        and calculate the position. 161 54 in the middle of tile3. And to know the position at center in tile2 it is
        273 54. Note that moving left will decrease and moving right will increase the offset. 273-161 = 112

         */

        builder.moveByOffset(161,54).clickAndHold().moveByOffset(112,0).release().perform();

        //We can release also. it is needed. Remove release() from above and see the behaviour

        //We are also now using clickAndHold method with parameter. Note there is use of moveByOffset and release and perform
        driver.get(baseUrl2);
        WebElement three = driver.findElement(By.name("three"));
        builder.clickAndHold(three).moveByOffset(120,0).release().perform();


        //Release() has two methods one parameterless and other with WebElement parameter
        driver.get(baseUrl2);
        WebElement two = driver.findElement(By.name("two"));
        builder.clickAndHold(three).release(two).perform();
    }


    public void MoveToElement(){

        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl2);

        //moveToElement has 2 methods. one with WebElement parameter and other with offset
        //Earlier we were using moveToOffset method. Now we are holding the element directly

        Actions builder = new Actions(driver);
        WebElement three = driver.findElement(By.name("three"));
        builder.moveToElement(three).clickAndHold().moveByOffset(120,0).release().perform();
    }


    public void DragAndDrop(){
        /*
        There are 2 methods dragAndDrop and dragAndDropBy. Lets explore
         */

        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl3);

        //Refer dragAndDropBy method in Action class in api documentation. There is WebElement source and offsets
        //Get position from inspect element mouse postion feature to some random value
        Actions builder = new Actions(driver);
        WebElement dragme = driver.findElement(By.id("draggable"));
        builder.dragAndDropBy(dragme, 300,200).perform();

        //Next dragAndDrop(src,target). These are WebElement objects in parameters
        driver.get(baseUrl4);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement tgt = driver.findElement(By.id("droppable"));
        builder.dragAndDrop(src,tgt).perform();
    }


    public void DoubleClick(){

        /*
        doubleClick() has two methods. Lets explore
         */

        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl5);

        Actions builder = new Actions(driver);
        //Now refer doubleClick() in api class information over the web
        //doubleClick(WebElement target)
        WebElement target = driver.findElement(By.name("dblClick"));
        builder.doubleClick(target).perform();


        /*
        Now lets explore other method doubleClick(). This double clicks at mouse postion. There are two ways to do this
         */

        //Below method works fine
        //Comment in doubleClick(target) line and comment out below line to see the change
        //builder.moveToElement(target).doubleClick().perform();
    }

    public void ContextClick(){

        /*
        contextClick() is again with 2 methods. contextClick() on mouse position and second on WebElement parameter
         */
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl6);


        //Lets use the WebElement parameter method. Here in order to know the element attribute in firefox, press
        //cntrl+shift+C . click on the text to click you will know the attribute element id=div-context
        //Note here you will find the element attribute but how to find the element attribute of context menu items
        //look around in inspect you will find the elements too
        //We are using click() method with WebElement target parameter

        Actions builder = new Actions(driver);
        WebElement contextMenu = driver.findElement(By.id("div-context"));
        builder.contextClick(contextMenu).click(driver.findElement(By.name("Item 4"))).perform();
        driver.close();


        /*
        Another method is parameterless. That is on mouseposition. So use moveToElement or lets try moveByOffset method
         */
    }



    public void ContextClick2(){

        //Using contextClick() parameterless version
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl6);
        Actions builder = new Actions(driver);
        WebElement contextMenu = driver.findElement(By.id("div-context"));
        builder.moveToElement(contextMenu).contextClick().click(driver.findElement(By.name("Item 2"))).perform();
        driver.close();
    }

    public void ContextClick3(){

        //Using contextClick() parameterless version. Using moveByOffset to use contextClick() parameterless
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl6);
        Actions builder = new Actions(driver);
        builder.moveByOffset(80,14).contextClick().click(driver.findElement(By.name("Item 2"))).perform();
    }





    public static void main(String[] args){

        ActionsOnWebElement object = new ActionsOnWebElement();
        //object.ClickOnWebElement();
        //object.ClickAndHold();
        //object.MoveToElement();
        //object.DragAndDrop();
        //object.DoubleClick();
        //object.ContextClick();
        //object.ContextClick2();
        //object.ContextClick3();

    }
}
