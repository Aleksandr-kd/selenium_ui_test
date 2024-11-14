import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


class FirstTest {

    static WebDriver driver;

    @BeforeAll
    public static void webDriverInstall(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void webDriverStart() {
        driver = new ChromeDriver();

    }

    @AfterEach
    public void webDriverStop () {
        if (driver != null)
            driver.close();
    }

    @Test
    public  void test(){
        driver.get("https://otus.home.kartushin.su/training.html");

        driver.findElement(By.id("textInput")).sendKeys("Текст ввели!");
        driver.findElement(By.id("btnClick")).click();

        Alert alert = driver.switchTo().alert();
        String expected = "Кнопка нажата!";
        String actual = alert.getText();
        alert.accept(); //нажать кнопку  ОК
        Assertions.assertEquals(expected, actual);  // сравнение ожид. с факт. результатом
    }
}
