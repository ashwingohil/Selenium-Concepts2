import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;


public class ActionsOnWebElements {

    String baseUrl = "https://www.google.com/";
    String baseUrl1 = "http://demo.guru99.com/test/login.html";
    String baseUrl2 = "http://automationpractice.com/index.php";

    public void GetAttribute(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        WebElement searchButton = driver.findElement(By.name("q"));
        WebElement searchButton1 = driver.findElement(By.className("gLFyf"));

        //As you can see I have loaded the WebElement with name and className. Both objects can get
        //attributes for various values

        //Inspect the element searchbox on base url (google). Note that there are various attribute value pairs
        //Trying all of them. You only need to load Webelement

        System.out.println("Search button name value is "+searchButton.getAttribute("name"));
        System.out.println("Id of the button is: "+searchButton.getAttribute("type"));
        System.out.println("Area auto complete value is: "+searchButton.getAttribute("aria-autocomplete"));


        System.out.println("JS action value is: "+searchButton1.getAttribute("jsaction"));
        System.out.println("Class value is: "+searchButton1.getAttribute("class"));


        driver.close();
    }



    public void SendKeys(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl1);

        WebElement textBox = driver.findElement(By.id("email"));
        textBox.sendKeys("abcd@gmail.com");
        textBox.clear();
        textBox.sendKeys(Keys.chord(Keys.SHIFT,"abcd@gmail.com")); //This is about Keys class. little complicate
        // takes practise

        //driver.close();

    }

    public void Submit(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl1);

        WebElement SubmitButton = driver.findElement(By.id("SubmitLogin"));
        SubmitButton.submit();

        //Submit works on form element. If you try doing it on link, behaviour is NoSuchElement

        //driver.close();

    }


    public void GetCSSValue(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        //Inspect search box of google and note on right pane various css value. pick them
        WebElement searchButton = driver.findElement(By.name("q"));
        System.out.println("Css value of font-family is: "+searchButton.getCssValue("font-family"));
        System.out.println("Css value of line-height is: "+searchButton.getCssValue("line-height"));
        System.out.println("Css value of line-height is: "+searchButton.getCssValue("line-height"));
        System.out.println("Css value of background-color is: "+searchButton.getCssValue("background-color"));
        //I am not able to get the value for font. dont know why
    }


    public void GetLocation(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        WebElement locationSearchBox = driver.findElement(By.name("q"));
        System.out.println("Location of SearchBox is: "+locationSearchBox.getLocation());

        //GetLocation gives the location of the web element in pixels
        driver.close();
    }

    public void GetSize(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        WebElement SearchBox = driver.findElement(By.name("q"));
        System.out.println("Dimension of searchbox is: "+SearchBox.getSize());

        //Note that dimension is width and height. Hover over the inspect data down below and check the
        //searchbox above . there will be value showing 527,34

        WebElement about = driver.findElement(By.className("Fx4vi"));
        System.out.println("Dimension of about is: "+about.getSize());

        driver.close();
    }


    public void GetText(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        WebElement searchBox = driver.findElement(By.name("q"));
        System.out.println("Text on the search box is: "+searchBox.getText());

        //Does not show anything about the search box

        //This one shows on baseUrl1
        driver.get(baseUrl1);
        WebElement AlreadyRegisteredBox = driver.findElement(By.id("login_form"));
        System.out.println("Text on the box of AlreadyRegistered?: "+AlreadyRegisteredBox.getText());


        driver.close();

    }


    public void IsSelectedIsEnabled(){

        System.setProperty("webdriver.gecko.driver","/home/ashwin/Desktop/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl2);

        //Here by sheer class locator we are not able to find. using xpath. Inspect the element. Click
        //on women tab of the url and inspect. See in xpath there u see relative xpath. use that entire value

        WebElement womenTab = driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"));
        womenTab.click();

        womenTab = driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"));
        //The above code is to be repeated again . Have to load the webElement again otherwise throws
        //StaleException

        System.out.println("Is it enabled?"+womenTab.isEnabled());
        System.out.println("Is it enabled?"+womenTab.isSelected());

        //Note that isSelected is used in check boxs , radio buttons, options in select

        driver.close();
    }

    public static void main(String[] args){

        ActionsOnWebElements object = new ActionsOnWebElements();
        //object.GetAttribute();
        //object.SendKeys();
        //object.Submit();
        //object.GetCSSValue();
        //object.GetLocation();
        //object.GetSize();
        //object.GetText();

        object.IsSelectedIsEnabled();
    }

}
