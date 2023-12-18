import Reports.ExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import page.PageOpencartSearch;

public class SeleniumTestOpencartSearch {
    private WebDriver driver;
    private PageOpencartSearch pageOpencartSearch;
    JavascriptExecutor executor;
    ExtentReports report;

    ExtentTest test;

    @BeforeEach
    public void setUp(){
        pageOpencartSearch = new PageOpencartSearch(driver,executor);
        driver= pageOpencartSearch.chromeDriverConnection();
        executor = pageOpencartSearch.runExecutor();
        driver.manage().window().maximize();
        pageOpencartSearch.link("https://opencart.abstracta.us/index.php?route=common/home");
        report = ExtentReport.getIntance();

    }
    @AfterEach
    public void tearDown(){
        driver.quit();
        report.flush();
    }
    @Test
    public void test() throws InterruptedException {
            test = report.startTest("Test Registro exitoso");
            test.log(LogStatus.INFO, "Inicia Test");
            pageOpencartSearch.hacerTest();
            test.log(LogStatus.PASS, "Finalizo Test Correctamente");
            report.endTest(test);

    }
}
