import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Skelbiu {
    public static WebDriver driver;
    public static ArrayList<String> urls = new ArrayList<>();
    public static String search = "baidarė";

    // @Test
    //    public void baigesFantazija(){
    //        pagination();
    //        openUrls();
    //    }

    public void pagination() {
        for (int i = 1; i < 15; i++) {
            String url = "https://www.skelbiu.lt/skelbimai/" + i + "?keywords=" + search; //persuka cikla per psl
            driver.get(url);
            if (!url.equals(driver.getCurrentUrl())) {
                return;
            }
            //  System.out.println(driver.getCurrentUrl());
            getUrls(); //parasyti urls
        }
    }
    //sujungia masyvus i elementa // is saraso paima paprastus ir paryskintus skelbimus
    public void getUrls() {
        List<WebElement> cards = Stream.concat(
                driver.findElement(By.id("itemsList")).findElements(By.className("simpleAds")).stream(),
                driver.findElement(By.id("itemList")).findElements(By.className("boldAds")).stream()).toList();
    }
    for(
    WebElement card : cards )

    {

    }
}


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        acceptCookies();
    }

    public void acceptCookies() {
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }