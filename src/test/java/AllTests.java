import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ SeleniumTestOpencartRegister.class, SeleniumTestOpencartSearch.class })
public class AllTests {

}
