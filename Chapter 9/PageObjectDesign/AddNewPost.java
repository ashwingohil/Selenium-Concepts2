package PageObjectDesign;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewPost {

    String AddNewPostFrameUrl = "https://pwnmojo.wordpress.com/wp-admin/post-new.php?calypsoify=1&block-editor=1&frame-nonce=8b4ed99053&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user&_support_token";

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"post-title-0\"]")
    WebElement writeTitle;

    @FindBy(how = How.CLASS_NAME, className = "block-editor-rich-text__editable block-editor-block-list__block wp-block is-selected rich-text")
    WebElement writeDescription;

    @FindBy(how = How.XPATH, xpath = "//button[contains(text(),'Publish')]")
    WebElement publish1;

    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[3]/div/div/div/div[1]/div[1]/button")
    WebElement publish2;

    @FindBy(how = How.CLASS_NAME, className = "components-button edit-post-fullscreen-mode-close wpcom-block-editor-nav-sidebar-toggle-sidebar-button__button has-icon")
    WebElement topLeftPath;


    public AddNewPost(WebDriver driver){
        this.driver = driver;
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        driver.get(AddNewPostFrameUrl);
        System.out.println("Initiating frame");
    }


    public void typeTextInTitle(String title){

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        writeTitle.sendKeys(title);
    }

    public void typeTextInDescription(String description){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        //writeDescription.click();
        //writeDescription.sendKeys(description);
        WebElement handle = driver.findElement(By.cssSelector("p.block-editor-rich-text__editable block-editor-block-list__block wp-block is-selected rich-text"));
        handle.sendKeys(description);
    }

    public void publishPost(){
        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        publish1.click();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        publish2.click();

        try{
            Thread.sleep(4000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        driver.navigate().back();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        driver.navigate().back();
    }

}
