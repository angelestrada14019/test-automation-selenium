import Reports.ExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import page.PageOpencartRegister;

public class SeleniumTestOpencartRegister {
    private WebDriver driver;
    private PageOpencartRegister pageOpencartRegister;
    JavascriptExecutor executor;
    ExtentReports report;

    ExtentTest test;

    @BeforeEach
    public void setUp(){
        pageOpencartRegister = new PageOpencartRegister(driver,executor);
        driver= pageOpencartRegister.chromeDriverConnection();
        executor = pageOpencartRegister.runExecutor();
        driver.manage().window().maximize();
        pageOpencartRegister.link("https://opencart.abstracta.us/index.php?route=common/home");
        report = ExtentReport.getIntance();

    }
    @AfterEach
    public void tearDown(){
        driver.quit();
        report.flush();
    }
    @Test
    public void test(){
        test = report.startTest("Test Registro exitoso");
        test.log(LogStatus.INFO, "Inicia Test");
        pageOpencartRegister.hacerTest();
        test.log(LogStatus.PASS,"Finalizo Test Correctamente");
        report.endTest(test);
    }
}
