package PageObjectDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllPostsPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//span[@class='sidebar__menu-link-text menu-link-text'][contains(text(),'Posts')]")
    WebElement PostLink;

    @FindBy(how = How.XPATH, xpath = "//*[@class='gridicon gridicons-search search__open-icon']")
    WebElement searchPost;

    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div/div[2]/div[1]/div/ul/li/div[2]/ul[2]/li[1]/h2/span")
    WebElement siteLink;

    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div/div[2]/div[1]/div/ul/li/div[2]/ul[2]/li[2]/ul/li[2]/a/span")
    WebElement posts;

    @FindBy(how = How.XPATH, xpath = "/html/body/div[1]/div/div[2]/div[2]/main/div[2]/div[1]/div[2]/a")
    WebElement clickAddNewPost;

    @FindBy(how = How.ID, id = "gridicons-search")
    WebElement searchIcon;

    @FindBy(how = How.ID, id = "search-component-50")
    WebElement searchBar;

    String postFrameUrl = "https://pwnmojo.wordpress.com/wp-admin/post.php?post=NUM&action=edit&calypsoify=1&block-editor=1&frame-nonce=255ccac29d&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user&_support_token";


    public AllPostsPage(WebDriver driver){

        this.driver = driver;
        //driver.get(AllPostsPageUrl);

    }


    public void createANewPost(String title, String Description){

        System.out.println("Inside create");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        siteLink.click();
        posts.click();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        clickAddNewPost.click();
        AddNewPost newPost = PageFactory.initElements(driver, AddNewPost.class);
        newPost.typeTextInTitle(title);
        //newPost.typeTextInDescription(Description);
        newPost.publishPost();
    }

    public void editAPost(String presentTitle, String newTitle){

        System.out.println("in edit");
        try{
            Thread.sleep(4000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        WebElement element1;
        List<WebElement> allPosts = driver.findElements(By.className("post-item__title-link"));
        System.out.println(allPosts);
        for(WebElement ele : allPosts){
            System.out.println(ele.getText());
            if(ele.getText().equals(presentTitle)){
                Actions builder = new Actions(driver);
                builder.moveToElement(ele);
                System.out.println("Before find element in edit");
                System.out.println(ele.getText());
                ele.click();

                try{
                    Thread.sleep(5000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }

                break;
            }
        }

        System.out.println("out of the loop");
        EditPost editPostHandle = PageFactory.initElements(driver,EditPost.class);
        editPostHandle.ReplaceText(newTitle);
        editPostHandle.Update();
        editPostHandle.ResetToAllPostsPage();

    }


    public void deleteAPost(String postTitle){

        //It will not have a class as there are no different page for the actions. Its in AllPostsPage

        try{
            Thread.sleep(10000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("inside delete");
        //Rule: I have fetched an element inside element tree. The first occurance is fetched.
        List<WebElement> list = driver.findElements(By.className("post-item__title-link"));
        for(WebElement e : list){
            System.out.println(e.getText());
            if(e.getText().equals(postTitle)){
                Actions builder = new Actions(driver);
                builder.moveToElement(e);
                builder.click(driver.findElement(By.className("post-actions-ellipsis-menu")));


                Action compositeAction = builder.build();
                compositeAction.perform();

                try{
                    Thread.sleep(3000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }

                List<WebElement> popover = driver.findElements(By.className("popover__menu-item"));
                for(WebElement pops : popover){
                    if(pops.getText().equals("Trash")){
                        Actions popbuilder = new Actions(driver);
                        builder.moveToElement(pops);
                        builder.click();
                        Action compositeAction2 = builder.build();
                        compositeAction2.perform();
                        break;
                    }
                }

                break;
            }
        }

    }

    public void searchInPost(String searchText){

        /*
        try{
            Thread.sleep(3000);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

         */

        searchIcon.click();
        searchBar.sendKeys(searchText);

    }



}
