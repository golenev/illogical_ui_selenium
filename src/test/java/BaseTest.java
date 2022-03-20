import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static helpers.TestingConfiguration.*;
import java.util.Objects;

public abstract class BaseTest {
    protected Browser browser = AqualityServices.getBrowser();;


    @BeforeMethod
    public void setUp() {
       /* String value = setStartBrowser();
        System.out.println(value + "  qweqweqwe");
        if (value.equals("chrome")) {
            // if (Objects.equals(setStartBrowser(), "${BROWSER}"))
            value = "edge";
            System.out.println(value + "11111111");
        }*/

      //  browser = AqualityServices.getBrowser();
        browser.maximize();
    }
        @AfterMethod
        public void tearDown () {
            browser.quit();
        }

}