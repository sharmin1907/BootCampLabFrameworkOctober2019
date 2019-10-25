package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ExtentManager;
import report.ExtentTestManager;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static String sauceUserName = "";
    public static String sauceKey = "";
    public static String browserStackUserName = "";
    public static String browserStackKey = "";
    public static String SAUCE_URL = "http://" + sauceUserName + ":" + sauceKey + "@ondemand.saucelabs.com:80/wd/hub";
    public static String BROWERSTACK_URL = "http://" + browserStackUserName + ":" + browserStackKey + "@hub-cloud.browserstack.com:80/wd/hub";

    @Parameters({"platform", "url", "browser", "cloud", "browserVersion", "envName"})
    @BeforeMethod
    public static WebDriver setupDriver(String platform, String url, String browser,
                                        boolean cloud, String browserVersion, String envName) throws MalformedURLException {
        if (cloud) {
            driver = getCloudDriver(browser, browserVersion, platform, envName);
        } else {
            driver = getLocalDriver(browser, platform);
        }
        driver.get(url);
        return driver;
    }
    public static WebDriver getLocalDriver(String browser, String platform) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/src/main/resources/chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);
        } else if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/src/main/resources/chromedriver");
            driver = new ChromeDriver(chromeOptions);
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getCloudDriver(String browser, String browserVersion, String platform,
                                           String envName) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("name", "Cloud Execution");
        desiredCapabilities.setCapability("browserName", browser);
        desiredCapabilities.setCapability("browser_version", browserVersion);
        desiredCapabilities.setCapability("os", platform);
        desiredCapabilities.setCapability("os_version", "Windows 10");
        desiredCapabilities.setCapability("resolution", "1600x1200");
        if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL(SAUCE_URL), desiredCapabilities);
        } else if (envName.equalsIgnoreCase("browserstack")) {
            desiredCapabilities.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL(BROWERSTACK_URL), desiredCapabilities);
        }
        return driver;
    }
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH.mm.ss)");
        Date date = new Date();
        df.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + df.format(date) + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }
        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
    }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }
    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
    public void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickOnElementByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickOnElementById(String locator) {
        driver.findElement(By.id(locator)).click();
    }

    public void typeOnElementByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    public void typeOnElementById(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }

    public String getTextByXpath(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }

   public void clickOnElementByClassName(String locator){
       driver.findElement(By.className(locator)).click();
   }
   public void clickOnElementByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
   }
    public boolean isElementDisplayed(String locator) {
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

    public boolean isElementEnabled(String locator) {
        boolean flag = true;
        flag = driver.findElement(By.xpath(locator)).isEnabled();
        return flag;
    }
    public boolean isElementSelected(String locator) {
        boolean flag = true;
        flag = driver.findElement(By.xpath(locator)).isEnabled();
        return flag;
    }
    public WebElement getElement(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element;
    }

    public WebElement getElementByLinkText(String locator) {
        return driver.findElement(By.linkText(locator));
    }
    public void dragNdropByXpaths(String fromLocator,String toLocator){
        Actions actions=new Actions(driver);
        WebElement from =getElement(fromLocator);
        WebElement to =getElement(toLocator);
        actions.dragAndDrop(from,to).build().perform();
    }
    public void scrollIntoView(String locator) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", getElementByLinkText(locator));
    }
}