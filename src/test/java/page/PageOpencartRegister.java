package page;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PageOpencartRegister extends PageBase {

    public PageOpencartRegister(WebDriver driver, JavascriptExecutor executor) {
        super(driver, executor);
    }

    private void clicCuenta(){
        oprimir(By.xpath("//*[@id=\"top-links\"]/ul/li[2]"));
    }
    private void clicRegistro(){
        oprimir(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
    }
    private void rellenarFormulario(){
        teclear("Agel",By.xpath("//*[@id=\"input-firstname\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        teclear("Estada",By.xpath("//*[@id=\"input-lastname\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        teclear("rayh.rt@gmail.com",By.xpath("//*[@id=\"input-email\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        teclear("3723492897",By.xpath("//*[@id=\"input-telephone\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        teclear("12345A.a",By.xpath("//*[@id=\"input-password\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        teclear("12345A.a",By.xpath("//*[@id=\"input-confirm\"]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }
    private void noSeleccionNoticias(){
        oprimir(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input"));
    }
    private void banderaPoliticas(){
        oprimir(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
    }
    private void oprimirContinuar(){
        oprimir(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
    }

    public void hacerTest(){
        clicCuenta();
        clicRegistro();
        rellenarFormulario();
        noSeleccionNoticias();
        banderaPoliticas();
        oprimirContinuar();
    }

}
