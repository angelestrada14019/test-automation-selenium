package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PageOpencartSearch extends PageBase {

    public PageOpencartSearch(WebDriver driver, JavascriptExecutor executor) {
        super(driver, executor);
    }
    private void iphoneCampoBuscar(){
        teclear("iphone", By.xpath("//*[@id=\"search\"]/input"));
    }
    private void oprimirBotonBuscar() throws InterruptedException {
        oprimir(By.xpath("//*[@id=\"search\"]/span/button"));
        Thread.sleep(500);
    }
    private void addCart() throws InterruptedException {
        oprimir(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]"));
        Thread.sleep(500);
    }
    private void compararTextoProductoAdd() throws InterruptedException {
        comparar(By.xpath("//*[@id=\"product-search\"]/div[1]/a[2]"),"shopping cart");
        Thread.sleep(500);
    }
    public void hacerTest() throws InterruptedException {
        iphoneCampoBuscar();
        oprimirBotonBuscar();
        addCart();
        compararTextoProductoAdd();
    }
}
