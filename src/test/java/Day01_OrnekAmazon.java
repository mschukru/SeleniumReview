import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    //1. Amazon.com'a gidecegiz.
    //2. arama kutusuna "baby stroller"
    //3. 2. siradaki ürüne tiklayacagiz
    //4. ürün sayfasina gittikten sonra, ürünün toplam fiyatini alacagiz
    //5. Ürünün ortalama puanin (5 üzerinden) alacagiz.
    WebDriver driver;

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller");
        aramaKutusu.submit();

        WebElement ikincUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikincUrun.click();

        WebElement urunFiyati = driver.findElement(By.id("priceblock_ourprice_row"));
        System.out.println(urunFiyati.getText());

    }
    @Test
    public void test2(){
        //1. Google.com gecis yapalim (navigate().to.())
        //2. "kemal oyden" yazip arama yapalim
        //3. Karsimiza cikan sonuc sayisini ekrana yazdiralim.

        driver = new ChromeDriver();
        driver.navigate().to("https://google.com");

        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("Kemal ozden");
        arama.submit();

        WebElement sonuc = driver.findElement(By.id("result-stats"));
        System.out.println(sonuc.getText());


    }
}
