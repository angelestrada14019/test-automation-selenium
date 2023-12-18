package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor executor;

    public PageBase(WebDriver driver, JavascriptExecutor executor) {
        this.driver = driver;
        this.executor = executor;

    }

    public WebDriver chromeDriverConnection() {
        System.setProperty(Drivers.NAME_DRIVE_CHROME, Drivers.URL_DRIVE_CHROME);
        driver = new ChromeDriver();
        return driver;
    }
    public WebDriver edgeDriverConnection() {
        System.setProperty(Drivers.NAME_DRIVE_EDGE, Drivers.URL_DRIVE_EDGE);
        driver = new EdgeDriver();
        return driver;
    }
    public JavascriptExecutor runExecutor(){
        executor=(JavascriptExecutor)driver;
        return executor;
    }
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    public void teclear(String imputText,By locator) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(imputText);
    }
    public void tecla (By locator, String tecla) {
        driver.findElement(locator).sendKeys(Keys.valueOf(tecla));
    }
    public void obtenerTexto (By locator) {
        String res = driver.findElement(locator).getText();
        System.out.println("Texto : " + res );
    }
    public void oprimir (By locator) {
        driver.findElement(locator).click();
    }
    public void oprimirJs (WebElement webElement) {
        executor.executeScript("arguments[0].click();", webElement);
    }
    public void enter (By locator){
        driver.findElement(locator).submit();
    }
    public void link (String url) {
        driver.get(url);
    }
    public void comparar (By locator, String texto) {
        String res = driver.findElement(locator).getText();
        assertTrue(res.contains(texto));
    }
    public void esperaExplicita(By locator,String texto, int tiempo) {
        new WebDriverWait(driver, Duration.ofSeconds(tiempo))
                .until(ExpectedConditions.textToBe(locator,texto ));
    }
}
