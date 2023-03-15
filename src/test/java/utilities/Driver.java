package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;


    private static String browser = Config.getValue("browser");

    //This method will open driver: Chrome or Firefox

    public static WebDriver getDriver(){
        if(driver == null){
            if(browser.equalsIgnoreCase("chrome")){

                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(co);


                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            }else if(browser.equalsIgnoreCase("firefox")){

                driver = new FirefoxDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            }else{
                System.out.println("Invalid Browser Type. Launching default Browser");

                driver = new ChromeDriver();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                return driver;
            }

        }else{
            return driver;
        }

    }
    //This method will quit browser
    public static void quitBrowser(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }







}
