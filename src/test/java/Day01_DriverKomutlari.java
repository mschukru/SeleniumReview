import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_DriverKomutlari {
    @Test
    public void test1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //driveri tam ekran yaptik
        driver.manage().window().maximize();
        // web elementlerinin 10 saniye kadar beklemsini sagliyouz.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");

        //herhangi bir web sayfasina gider
        driver.navigate().to("http://amazon.com");

        //bir önceki sayfaya geri döner
        driver.navigate().back();

        // ileri gider
        driver.navigate().forward();

        //sayfayi yeniler
        driver.navigate().refresh();

        //driveri kapatmak icin kullanilir
        driver.quit();

        // acik olan sekmeyi kapatir
        driver.close();

    }
}
