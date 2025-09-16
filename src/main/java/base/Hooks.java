
package base;
 
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Hooks extends BaseClass {
	
 
	@Before
	
	
	public void setUp() {
	    String browserName = prop.getProperty("browser").toLowerCase();

	    switch (browserName) {
	        case "chrome":
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver(getChromeOptions());
	            break;

	        case "firefox":
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver(getFirefoxOptions());
	            break;

	        case "edge":
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver(getEdgeOptions());
	            break;

	        default:
	            throw new IllegalArgumentException("Unsupported browser: " + browserName);
	    }

	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	}

	// ✅ Centralized options for each browser
	private ChromeOptions getChromeOptions() {
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
	    options.addArguments("--headless");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    // remove if not needed
	    options.addArguments("--remote-allow-origins=*");
	    return options;
	}

	private FirefoxOptions getFirefoxOptions() {
	    FirefoxOptions options = new FirefoxOptions();
	    options.addArguments("--incognito");
	    options.addArguments("--remote-allow-origins=*");
	    return options;
	}

	private EdgeOptions getEdgeOptions() {
	    EdgeOptions options = new EdgeOptions();
	    options.addArguments("--inprivate"); // Edge uses --inprivate instead of --incognito
	    options.addArguments("--remote-allow-origins=*");
	    return options;
	}

//	   public void setUp() {
//        String browserName = prop.getProperty("browser");
//
//        switch (browserName.toLowerCase()) {
//            case "chrome":
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--remote-allow-origins=*");
//                chromeOptions.addArguments("--incognito");
//                driver = new ChromeDriver(chromeOptions);
//                break;
//
//            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.addArguments("--remote-allow-origins=*");
//                firefoxOptions.addArguments("--incognito");
//                driver = new FirefoxDriver(firefoxOptions);
//                break;
//
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                EdgeOptions edgeOptions = new EdgeOptions();
//                edgeOptions.addArguments("--remote-allow-origins=*");
//                edgeOptions.addArguments("--incognito");
//                driver = new EdgeDriver(edgeOptions);
//                break;
//
//            default:
//                throw new IllegalArgumentException("Unsupported browser: " + browserName);
//        }
//
//        driver.get(prop.getProperty("url"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
//    }

	
	@After
	public void tearDown(Scenario s) {
	        if (s.isFailed()) {
	            if (driver instanceof TakesScreenshot) {
	                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                s.attach(screenshot, "image/png", "Failure Test Case Screenshot");
	            }
	        }
	      driver.quit();
	  	}		
}
 