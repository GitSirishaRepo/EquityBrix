package steps;

/*
 * Hooks File: [Hooks File Name]
 *
 * Description:
 * This file contains custom hooks used throughout the [Application Name] application.
 * Hooks are reusable functions that encapsulate stateful logic, allowing you to
 * share this logic between different components in your application.
 *
 * Hooks Included:
 * - [Hook1Name]: [Brief description of Hook1]
 * - [Hook2Name]: [Brief description of Hook2]
 * - [Hook3Name]: [Brief description of Hook3]
 *
 * Usage:
 * To use a hook, import it from this file and call it within your component:
 *
 * import { [Hook1Name] } from './hooks';
 *
 * function MyComponent() {
 *   const [state, setState] = [Hook1Name]();
 *   // Use the state and setState functions returned by the hook
 * }
 *
 * Author:
 * [Your Name] ([email@example.com])
 *
 * Copyright (c) [Current Year] [Your Name]
 * Licensed under the [License Type] License.
 */
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DataUtility;
import utils.ElementUtil;
import utils.EqBrikOTP;

public class Hooks {

    private DriverFactory df;
    private WebDriver driver;
    private Properties prop;
    private LoginPage loginPage;
    private ElementUtil eleUtil;
    private EqBrikOTP eqBrikOTP;
    private DataUtility dataUtil;

    @Before
    public void setUp() {
        df = new DriverFactory();
        prop = df.initProp();

//        String browserName = System.getProperty("browser", prop.getProperty("browser", "chrome"));
//        String browserVersion = System.getProperty("browserversion", prop.getProperty("browserversion", ""));
//        String testName = System.getProperty("testname", prop.getProperty("testname", "defaultTest"));
//
//        prop.setProperty("browser", browserName);
//        prop.setProperty("browserversion", browserVersion);
//        prop.setProperty("testname", testName);

        driver = df.initDriver(prop);
        loginPage = new LoginPage(driver);
        eleUtil = new ElementUtil(driver);
        eqBrikOTP= new EqBrikOTP(driver);
         dataUtil= new DataUtility(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
           // driver.quit();
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public LoginPage getLoginPage() {
        return this.loginPage;
    }

    public ElementUtil getElementUtil(){
        return this.eleUtil;
    }

    public EqBrikOTP getEbOTP(){
        return this.eqBrikOTP;
    }

    public DataUtility getDataUtil(){
        return this.dataUtil;
    }

}



