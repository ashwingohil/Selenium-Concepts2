package PageObjectDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditPost {

    WebDriver driver;
    String tempUrl;
    String postFrameUrl = "https://pwnmojo.wordpress.com/wp-admin/post.php?post=NUM&action=edit&calypsoify=1&block-editor=1&frame-nonce=255ccac29d&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user&_support_token";
    String newUrl;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"post-title-0\"]")
    WebElement replaceText;

    @FindBy(how = How.XPATH, xpath = "//button[contains(text(),'Update')]")
    WebElement updateButton;

    @FindBy(how = How.XPATH, xpath = "//body[@class='wp-admin wp-core-ui js legacy-color-fresh post-php auto-fold admin-bar post-type-post branch-5-6 version-5-6 admin-color-fresh locale-en multisite block-editor-page is-fullscreen-mode wp-embed-responsive customize-support svg jetpack-enable-upgrade-nudge sticky-menu']/div[@id='wpwrap']/div[@id='wpcontent']/div[@id='wpbody']/div[@id='wpbody-content']/div[@class='block-editor']/div[@id='editor']/div[@class='components-drop-zone__provider']/div/div[@class='components-navigate-regions']/div[@class='edit-post-layout is-mode-visual interface-interface-skeleton']/div[@class='interface-interface-skeleton__editor']/div[@class='interface-interface-skeleton__header']/div[@class='edit-post-header']/div[1]/button[1]")
    WebElement topLeftButton;

    @FindBy(how = How.XPATH, xpath = "//a[@class='components-button wpcom-block-editor-nav-sidebar-nav-sidebar__home-button has-text has-icon']")
    WebElement allPostsLink;



    public EditPost(WebDriver driver){

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        tempUrl = driver.getCurrentUrl();
        String shortUrl = tempUrl.substring(tempUrl.indexOf("pwnmojo.wordpress.com/"),tempUrl.length());
        int start = shortUrl.indexOf("/");
        int end = shortUrl.length();
        String tempCode = shortUrl.substring(start+1,end);
        newUrl = postFrameUrl.replace("NUM",tempCode);
        driver.get(newUrl);
        this.driver = driver;
    }

    public void ReplaceText(String newTitle){

        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        replaceText.clear();
        replaceText.sendKeys(newTitle);
    }

    public void Update(){

        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        updateButton.click();
    }

    public void ResetToAllPostsPage(){

        try{
            Thread.sleep(4000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        driver.navigate().back();

        try{
            Thread.sleep(4000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        driver.navigate().back();
    }

}
