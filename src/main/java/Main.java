import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
/*Otići na kupujemprodajem.com, u pretragu ukucati iphone 13, kliknuti na prvi rezultat. Proveriti da je naslov oglasa
 onaj koji smo uočili i tokom manuelnog izvođenja kejsa.*/

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mila-\\Desktop\\EXE file\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.kupujemprodajem.com/");

        driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]")).click();
        WebElement elSrc = driver.findElement(By.xpath("//*[@id=\"searchKeywordsInput\"]"));
        elSrc.sendKeys("iphone 13");
        driver.findElement(By.xpath("//*[@id=\"searchFormHolder\"]/div/div/div[2]/div[2]/div[2]/div[1]/input")).click();

        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();

//        WebElement scroll = driver.findElement(By.xpath("//*[@id=\"middleCol\"]/div[2]"));
//        scroll.click();
//        scroll.sendKeys(Keys.DOWN);
//        scroll.sendKeys(Keys.DOWN);
//        scroll.sendKeys(Keys.DOWN);
//        scroll.sendKeys(Keys.DOWN);
//        scroll.sendKeys(Keys.DOWN);
        //ovako mi nije spustalo stranu


        WebElement firstAdd = driver.findElement(By.xpath("//*[@id=\"adDescription7321776\"]/a"));
        firstAdd.click();
        String actualTitle = driver.findElement(By.tagName("h1")).getText();
        String expectedTitle="iPhone 13, iPhone 12, iPhone 11 - NOVO!";


        if ( actualTitle.equals(expectedTitle)) {
            System.out.println("Validno!");
        }else {
            System.out.println("Nevalidno, naslov prvog oglasa je zapravo: "+  actualTitle+" oglas");
        }
        driver.close();
    }
}
